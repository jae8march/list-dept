package com.example.controller.commands.employee;

import com.example.controller.ICommand;
import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.server.impl.DepartmentService;
import com.example.server.impl.EmployeeService;
import com.example.util.Validator;
import com.example.util.constants.Actions;
import com.example.util.constants.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles the editing process employee.
 */
public class EditEmployeeCommand implements ICommand {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private List<String> errors;

    public EditEmployeeCommand(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    /**
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("emplId"));

        Employee empl = employeeService.findEntity(id);
        errors = new ArrayList<>();

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        String yearsWorkingStr = request.getParameter("yearsWorking");
        String birthDateStr = request.getParameter("dateOfBirth");
        String deptId = request.getParameter("deptId");

        if (!Objects.equals(empl.getEmail(), email)) {
            checkEmail(email);
        }

        checkYearsWorking(yearsWorkingStr);
        checkBirthDate(birthDateStr);
        checkDept(deptId);

        LocalDate dateOfBirth = LocalDate.parse(birthDateStr);

        if (!errors.isEmpty()) {
            request.setAttribute("errorList", errors);

            request.setAttribute("emplId", empl.getId());
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("birthDate", birthDateStr);
            request.setAttribute("yearsWorking", yearsWorkingStr);
            request.setAttribute("deptId", deptId);

            forward(request, response, Paths.EDIT_EMPL);
        } else {
            Department department = new Department();
            department.setId(Long.valueOf(deptId));
            Employee employee = new Employee(id, name, dateOfBirth, Integer.parseInt(yearsWorkingStr), email, department);

            if (employeeService.update(employee)) {
                forward(request, response, Actions.ACTION_EMPLOYEE_LIST);
            } else {
                forward(request, response, Paths.ERROR);
            }
        }
    }

    private void checkEmail(String email) {
        if (!Validator.isValidEmail(email)) {
            errors.add("Please enter a valid mail format");
        } else if (!employeeService.isUniqueEmail(email)) {
            errors.add("An employee with this mail exists");
        }
    }

    private void checkYearsWorking(String yearsWorkingStr) {
        if (!Validator.isValidInt(yearsWorkingStr)) {
            errors.add("Enter integer for the number of years of work");
        } else if (Integer.parseInt(yearsWorkingStr) > 100) {
            errors.add("Enter the allowed number of years of work");
        }
    }

    private void checkBirthDate(String birthDate) {
        if (Validator.getTimeLength(birthDate) < 18) {
            errors.add("You can add an employee who has reached the age of 18");
        }
    }

    private void checkDept(String dept) {
        if (!Validator.isValidInt(dept)) {
            errors.add("Enter integer for the dept");
        } else if (departmentService.findEntity(Long.valueOf(dept)).getName() == null) {
            errors.add("Department with " + dept + " id doesn't exist");
        }
    }
}
