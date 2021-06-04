<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List of employees</title>
</head>
<style>
    <%@include file='../../style/table.css' %>
    <%@include file='../../style/main.css' %>
</style>

<body>
<div id="container">
    <div id="header">
        Employees
    </div>
    <div id="content">
        <br>
        <table class="table">
            <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Years Working</th>
                <th>Email</th>
                <th><a href="#" class="button">Add employee</a></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>id</td>
                <td>Gloria Reeves Reeves</td>
                <td>0000-00-00</td>
                <td>000</td>
                <td>qweqwe@gmail.com</td>
                <td>
                    <ul>
                        <li><a href="#" class="button">Update</a></li>
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
