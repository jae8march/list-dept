package com.example.controller.commands.employee;

import com.example.controller.ICommand;
import com.example.entity.Employee;
import com.example.server.impl.EmployeeService;
import com.example.util.constants.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Go to edit-page Department.
 */
public class EditPageEmployeeCommand implements ICommand {
    private final EmployeeService employeeService;

    public EditPageEmployeeCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Long emplId = Long.valueOf(request.getParameter("emplId"));
        Employee employee = employeeService.findEntity(emplId);

        request.setAttribute("emplId", employee.getId());
        request.setAttribute("name", employee.getName());
        request.setAttribute("email", employee.getEmail());
        request.setAttribute("birthDate", employee.getBirthDate());
        request.setAttribute("yearsWorking", employee.getYearsWorking());
        request.setAttribute("idDept", employee.getDepartment().getId());

        forward(request, response, Paths.EDIT_EMPL);
    }
}
