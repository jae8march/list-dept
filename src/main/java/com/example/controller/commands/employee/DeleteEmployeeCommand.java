package com.example.controller.commands.employee;

import com.example.controller.ICommand;
import com.example.server.impl.EmployeeService;
import com.example.util.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Deletes an employee by mail.
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
        String mail = request.getParameter("deleteMail");
        employeeService.delete(mail);
        redirect(request, response, Paths.LIST_EMPL);
    }
}
