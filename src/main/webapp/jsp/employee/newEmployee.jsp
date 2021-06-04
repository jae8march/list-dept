<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>New employee</title>
</head>
<style>
    <%@include file='../../style/table.css' %>
    <%@include file='../../style/main.css' %>
</style>

<body>
<div id="container">
    <div id="header">
        New employee
    </div>
    <div id="content">
        <br>
        <form action="action_page.php">
            <div class="container">
                <hr>
                <input type="text" placeholder="Name" id="name" name="name" required>

                <input type="text" placeholder="Phone Number" id="phone" name="phone" required>

                <input type="text" placeholder="How many years has it been working" id="yearsWorking" name="yearsWorking" required>

                <input type="text" placeholder="Email" id="email" name="email" required>

                <input type="date" dataformatas="yyyy-MM-dd" id="dateOfBirth" name="dateOfBirth" placeholder="Date Of Birth" required>

                <input type="text" placeholder="Department" name="department" required>
                <hr>

                <button type="submit" class="add">Add</button>
            </div>

            <div class="container back">
                <p>Back to <a href="#">list of departments</a> or <a href="#">list of employees</a>.</p>
            </div>
        </form>
    </div>
</div>
</body>
</html>
