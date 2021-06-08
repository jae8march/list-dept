package com.example.controller.commands.employee;

import com.example.controller.ICommand;
import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.server.impl.EmployeeService;
import com.example.util.Validator;
import com.example.util.constants.Actions;
import com.example.util.constants.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Adds employee to the database.
 */
public class AddEmployeeCommand implements ICommand {
    private final EmployeeService employeeService;

    public AddEmployeeCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Checks the entered data, if the data was entered incorrectly adds an error message to the list.
     * At the end of the method, checks if the list with errors empty.
     * If yes - after adding a new employee, redirects the user to the list of employees.
     * If not, it returns to the add page and displays errors.
     *
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String yearsWorkingStr = request.getParameter("yearsWorking");
        String email = request.getParameter("email");
        String dateOfBirthStr = request.getParameter("dateOfBirth");
        Long deptId = (Long) request.getSession().getAttribute("deptId");

        List<String> errors = new ArrayList<>();
        int yearsWorking = 0;

        if (!Validator.isValidInt(yearsWorkingStr)) {
            errors.add("Enter integer for the number of years of work");
        } else if ((yearsWorking = Integer.parseInt(yearsWorkingStr)) > 100) {
            errors.add("Enter the allowed number of years of work");
        }

        if (!Validator.isValidEmail(email)) {
            errors.add("Please enter a valid mail format");
        } else if (!employeeService.isUniqueExpression(email)) {
            errors.add("An employee with this mail exists");
        }

        if (Validator.getTimeLength(dateOfBirthStr) < 18) {
            errors.add("You can add an employee who has reached the age of 18");
        }

        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
        if (!errors.isEmpty()) {
            request.setAttribute("errorList", errors);
            request.setAttribute("name", name);
            request.setAttribute("yearsWorking", yearsWorkingStr);
            request.setAttribute("email", email);
            request.setAttribute("birthDate", dateOfBirth);
            forward(request, response, Paths.NEW_EMPL);
        } else {
            Department department = new Department();
            department.setId(deptId);
            Employee employee = new Employee(name, dateOfBirth, yearsWorking, email, department);

            employeeService.create(employee);
            forward(request, response, Actions.ACTION_EMPLOYEE_LIST);
        }
    }
}

