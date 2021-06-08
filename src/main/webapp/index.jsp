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
                <th>id</th>
                <th>Name</th>
                <th>Phone Number</th>
                <th><a href="${pageContext.request.contextPath}/app?action=addPageDept" class="button">Add department</a></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${departments}" var="departments">
            <tr>
                <td><c:out value="${departments.id}"/></td>
                <td><c:out value="${departments.name}"/></td>
                <td><c:out value="${departments.number}"/></td>
                <td>
                    <ul>
                        <li>
                            <form name="deleteDept" action="${pageContext.request.contextPath}/app?action=editPageDept" method="post">
                                <button name = "deptId" value="${departments.id}" class="button" type="submit">
                                    Edit
                                </button>
                            </form>
                        </li>
                        <li>
                        </li>
                        <li>
                            <form name="deleteDept" action="${pageContext.request.contextPath}/app?action=listEmpl" method="post">
                                <button name = "deptId" value="${departments.id}" class="button" type="submit">
                                    List of employees
                                </button>
                            </form>
                        </li>
                        <li>
                            <form name="deleteDept" action="${pageContext.request.contextPath}/app?action=deleteDept" method="post">
                                <button name = "deptId" value="${departments.id}" class="button" type="submit">
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
