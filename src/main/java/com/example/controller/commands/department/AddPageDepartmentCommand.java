package com.example.controller.commands.department;

import com.example.controller.ICommand;
import com.example.util.constants.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Go to add-page Department.
 */
public class AddPageDepartmentCommand implements ICommand {
    /**
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        forward(request, response, Paths.NEW_DEPT);
    }
}
