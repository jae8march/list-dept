package com.example.controller.commands.employee;

import com.example.controller.ICommand;
import com.example.entity.Employee;
import com.example.server.impl.EmployeeService;
import com.example.util.constants.Paths;

import java.util.LinkedHashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Finds all employees in the department in the database.
 */
public class ListEmployeesCommand implements ICommand {
    private final EmployeeService employeeService;

    public ListEmployeesCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Long deptId = Long.valueOf(request.getParameter("deptId"));

        LinkedHashSet<Employee> employees = employeeService.findFromDepartment(deptId);
        request.setAttribute("employees", employees);
        forward(request, response, Paths.LIST_EMPL);
    }
}
