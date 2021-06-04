<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List of departments</title>
</head>
<style>
    <%@include file='style/table.css' %>
    <%@include file='style/main.css' %>
</style>

<body>
<div id="container">
    <div id="header">
        Departments
    </div>
    <div id="content">
        <br>
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Number</th>
                <th><a href="#" class="button">Add department</a></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Gloria Reeves Reeves</td>
                <td>Reeve s Reeves Reeves Reeves Reeves Reeves</td>
                <td>
                    <ul>
                        <li><a href="#" class="button">Update</a></li>
                        <li><a href="#" class="button">List of employees</a></li>
                        <li><a href="#" class="button">Delete</a></li>
                    </ul>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
