package com.example.controller;

import com.example.controller.commands.additional.ErrorCommand;
import com.example.controller.commands.department.AddDepartmentCommand;
import com.example.controller.commands.department.AddPageDepartmentCommand;
import com.example.controller.commands.department.DeleteDepartmentCommand;
import com.example.controller.commands.department.EditDepartmentCommand;
import com.example.controller.commands.department.EditPageDepartmentCommand;
import com.example.controller.commands.department.ListDepartmentsCommand;
import com.example.controller.commands.employee.AddEmployeeCommand;
import com.example.controller.commands.employee.AddPageEmployeeCommand;
import com.example.controller.commands.employee.DeleteEmployeeCommand;
import com.example.controller.commands.employee.EditEmployeeCommand;
import com.example.controller.commands.employee.EditPageEmployeeCommand;
import com.example.controller.commands.employee.ListEmployeesCommand;
import com.example.server.impl.DepartmentService;
import com.example.server.impl.EmployeeService;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();
    private final Map<String, ICommand> commands = new HashMap<>();

    public CommandFactory() {
        EmployeeService employeeService = new EmployeeService();
        DepartmentService departmentService = new DepartmentService();

        /** Department commands */
        commands.put("addDept", new AddDepartmentCommand(departmentService));
        commands.put("addPageDept", new AddPageDepartmentCommand());

        commands.put("deleteDept", new DeleteDepartmentCommand(departmentService, employeeService));

        commands.put("editDept", new EditDepartmentCommand(departmentService));
        commands.put("editPageDept", new EditPageDepartmentCommand(departmentService));

        commands.put("listDept", new ListDepartmentsCommand(departmentService));

        /** Employee commands */
        commands.put("addEmpl", new AddEmployeeCommand(employeeService, departmentService));
        commands.put("addPageEmpl", new AddPageEmployeeCommand());

        commands.put("deleteEmpl", new DeleteEmployeeCommand(employeeService));

        commands.put("editEmpl", new EditEmployeeCommand(employeeService));
        commands.put("editPageEmpl", new EditPageEmployeeCommand(employeeService));

        commands.put("listEmpl", new ListEmployeesCommand(employeeService));
    }

    public static CommandFactory getFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        ICommand command = commands.get(action);
        return command == null ? new ErrorCommand() : command;
    }
}
