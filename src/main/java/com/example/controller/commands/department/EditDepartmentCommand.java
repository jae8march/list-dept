package com.example.controller.commands.department;

import com.example.controller.ICommand;
import com.example.entity.Department;
import com.example.server.impl.DepartmentService;
import com.example.util.Validator;
import com.example.util.constants.Actions;
import com.example.util.constants.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles the editing process department.
 */
public class EditDepartmentCommand implements ICommand {
    private final DepartmentService departmentService;
    private List<String> errors;

    public EditDepartmentCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Long deptId = Long.valueOf(request.getParameter("deptId"));

        Department dept = departmentService.findEntity(deptId);
        errors = new ArrayList<>();

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        if (!Objects.equals(dept.getName(), name)) {
            checkName(name);
        }

        if (!Objects.equals(dept.getNumber(), phone)) {
            checkPhone(phone);
        }

        if (!errors.isEmpty()) {
            request.setAttribute("errorList", errors);
            request.setAttribute("id", dept.getId());
            request.setAttribute("name", name);
            request.setAttribute("phone", phone);
            forward(request, response, Paths.EDIT_DEPT);
        } else {
            Department department = new Department(deptId, name, phone);
            if (departmentService.update(department)) {
                forward(request, response, Actions.ACTION_DEPT_LIST);
            } else {
                forward(request, response, Paths.ERROR);
            }
        }
    }

    private void checkName(String name) {
        if (!departmentService.isUniqueName(name)) {
            errors.add("Department name is not unique");
        }
    }

    private void checkPhone(String phone) {
        if (!Validator.isValidPhone(phone)) {
            errors.add("Phone number is not valid");
        } else if (!departmentService.isUniquePhone(phone)) {
            errors.add("Phone number is not unique");
        }
    }
}
