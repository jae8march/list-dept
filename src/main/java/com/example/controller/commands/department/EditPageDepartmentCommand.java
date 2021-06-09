package com.example.controller.commands.department;

import com.example.controller.ICommand;
import com.example.entity.Department;
import com.example.server.impl.DepartmentService;
import com.example.util.constants.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Go to edit-page Department.
 */
public class EditPageDepartmentCommand implements ICommand {
    private final DepartmentService departmentService;

    public EditPageDepartmentCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Long deptId = Long.valueOf(request.getParameter("deptId"));
        Department dept = departmentService.findEntity(deptId);

        request.setAttribute("name", dept.getName());
        request.setAttribute("id", dept.getId());
        request.setAttribute("phone", dept.getNumber());

        forward(request, response, Paths.EDIT_DEPT);
    }
}
