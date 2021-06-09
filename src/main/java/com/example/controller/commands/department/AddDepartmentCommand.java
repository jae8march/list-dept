package com.example.controller.commands.department;

import com.example.controller.ICommand;
import com.example.entity.Department;
import com.example.server.impl.DepartmentService;
import com.example.util.Validator;
import com.example.util.constants.Actions;
import com.example.util.constants.Paths;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Adds department to the database.
 */
public class AddDepartmentCommand implements ICommand {
    private final DepartmentService departmentService;

    public AddDepartmentCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * Checks the entered data, if the data was entered incorrectly adds an error message to the list.
     * At the end of the method, checks if the list with errors empty.
     * If yes - after adding a new employee, redirects the user to the list of employees.
     * If not, it returns to the add page and displays errors.
     *
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        List<String> errors = new ArrayList<>();

        if (!Validator.isValidPhone(phone)) {
            errors.add("Phone number is not valid");
        } else if (departmentService.isUniquePhone(phone)) {
            errors.add("Phone number is not unique");
        }

        if (!departmentService.isUniqueName(name)) {
            errors.add("Department name is not unique");
        }

        if (!errors.isEmpty()) {
            request.setAttribute("errorList", errors);
            request.setAttribute("name", name);
            request.setAttribute("phone", phone);
            forward(request, response, Paths.NEW_DEPT);
        } else {
            Department department = new Department(name, phone);
            if (departmentService.create(department)) {
                forward(request, response, Actions.ACTION_DEPT_LIST);
            } else {
                forward(request, response, Paths.ERROR);
            }
        }
    }
}
