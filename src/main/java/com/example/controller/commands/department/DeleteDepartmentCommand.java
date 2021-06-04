package com.example.controller.commands.department;

import com.example.controller.ICommand;
import com.example.server.impl.DepartmentService;
import com.example.server.impl.EmployeeService;
import com.example.util.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteDepartmentCommand implements ICommand {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DeleteDepartmentCommand(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    /**
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String nameOfDepartment = request.getParameter("deleteName");

        employeeService.deleteEmployeesFromDepartment(nameOfDepartment);
        departmentService.delete(nameOfDepartment);

        redirect(request, response, Paths.LIST_DEPT);
    }
}
