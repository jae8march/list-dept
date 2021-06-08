package com.example.controller.commands.employee;

import com.example.controller.ICommand;
import com.example.entity.Employee;
import com.example.server.impl.EmployeeService;
import com.example.util.constants.Paths;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Finds all employees in the department in the database.
 */
public class ListEmployeesCommand implements ICommand {
    private final EmployeeService employeeService;

    public ListEmployeesCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * When you first go to the page, deptId parameter from request is owned and the method adds it to the session
     * so that when you try to go back to the page, get the parameter from the session and find list with employees.
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        final String deptId = "deptId";

        Long id;
        String idStr = request.getParameter(deptId);

        if (idStr == null) {
            id = (Long) request.getSession().getAttribute(deptId);
        } else {
            id = Long.parseLong(idStr);
            HttpSession session = request.getSession();
            session.setAttribute(deptId, id);
        }

        Set<Employee> employees = employeeService.findFromDept(id);
        request.setAttribute("employees", employees);
        request.setAttribute(deptId, id);

        forward(request, response, Paths.LIST_EMPL);
    }
}
