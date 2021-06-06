package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main servlet controller.
 */
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Main method of this controller.
     * Accepts a request from the client, creates an instance of the class {@link CommandFactory}
     * and finds the required object {@link CommandFactory#getFactory()} in the internal map with commands
     * and calls the method {@link ICommand#execute(HttpServletRequest, HttpServletResponse)}
     * to process the request as needed.
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CommandFactory commandFactory = CommandFactory.getFactory();
        ICommand command = commandFactory.getCommand(request);
        command.execute(request, response);
    }
}
