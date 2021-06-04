package com.example.controller.commands.department;

import com.example.controller.ICommand;
import com.example.server.impl.DepartmentService;
import com.example.server.impl.EmployeeService;
import com.example.util.constants.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Deletes department.
 */
public class DeleteDepartmentCommand implements ICommand {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DeleteDepartmentCommand(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    /**
     * If the department has employees, it first deletes employees, then the department itself.
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Long deptDeleteId = Long.valueOf(request.getParameter("deptDeleteId"));

        employeeService.deleteEmployeesFromDepartment(deptDeleteId);
        departmentService.delete(deptDeleteId);

        redirect(request, response, Paths.LIST_DEPT);
    }
}
