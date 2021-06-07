package com.example.controller.commands.employee;

import com.example.controller.ICommand;
import com.example.server.impl.EmployeeService;
import com.example.util.constants.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Deletes employee.
 */
public class DeleteEmployeeCommand implements ICommand {
    private final EmployeeService employeeService;

    public DeleteEmployeeCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Long deptId = Long.valueOf(request.getParameter("deptId"));
        employeeService.delete(deptId);
        forward(request, response, Paths.LIST_EMPL);
    }
}
