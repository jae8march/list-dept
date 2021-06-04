package com.example.controller.commands.employee;

import com.example.controller.ICommand;
import com.example.entity.Employee;
import com.example.server.impl.EmployeeService;
import com.example.util.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        String deptName = request.getParameter("deptName");

        List<Employee> employees = employeeService.findFromDepartment(deptName);
        request.setAttribute("employees", employees);
        forward(request, response, Paths.LIST_EMPL);
    }
}
