package com.example.controller.commands.employee;

import com.example.controller.ICommand;
import com.example.util.constants.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPageEmployeeCommand implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        forward(request, response, Paths.NEW_EMPL);
    }
}
