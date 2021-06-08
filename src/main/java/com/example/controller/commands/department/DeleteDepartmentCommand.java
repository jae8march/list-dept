package com.example.controller.commands.department;

import com.example.controller.ICommand;
import com.example.server.impl.DepartmentService;
import com.example.server.impl.EmployeeService;
import com.example.util.constants.Actions;

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
        Long deptId = Long.valueOf(request.getParameter("deptId"));

        employeeService.deleteEmployeesFromDept(deptId);
        departmentService.delete(deptId);

        redirect(request, response, Actions.ACTION_DEPT_LIST);
    }
}
