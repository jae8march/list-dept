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
    <%@include file='../../style/form.css' %>
</style>

<body>
<div id="container">
    <div id="header">
        Employees in ${deptId} dept
    </div>
    <div id="content">
        <div class="container back">
            <p>Back to <a href="${pageContext.request.contextPath}/app?action=listDept">list of departments</a>.</p>
        </div>
        <br>
        <table class="table">
            <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Years Working</th>
                <th>Email</th>
                <th><a href="${pageContext.request.contextPath}/app?action=addPageEmpl" class="button">Add employee</a></th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${employees}" var="employees">
            <tr>
                <td><c:out value="${employees.id}"/></td>
                <td><c:out value="${employees.name}"/></td>
                <td><c:out value="${employees.birthDate}"/></td>
                <td><c:out value="${employees.yearsWorking}"/></td>
                <td><c:out value="${employees.email}"/></td>
                <td>
                    <ul>
                        <li>
                            <form name="editDept" action="${pageContext.request.contextPath}/app?action=editPageEmpl" method="post">
                                <button name = "emplId" value="${employees.id}" class="button" type="submit">
                                    Edit
                                </button>
                            </form>
                        </li>
                            <form name="deleteDept" action="${pageContext.request.contextPath}/app?action=deleteEmpl" method="post">
                                <button name = "emplId" onclick="return confirm('Are you sure you want to do this?')" value="${employees.id}" class="button" type="submit">
                                    Delete
                                </button>
                            </form>
                        </li>
                    </ul>
                </td>
            </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
