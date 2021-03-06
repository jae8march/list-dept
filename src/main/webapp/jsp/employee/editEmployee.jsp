<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Edit employee ${emplId}</title>
</head>
<style>
    <%@include file='../../style/table.css' %>
    <%@include file='../../style/main.css' %>
    <%@include file='../../style/form.css' %>
</style>

<body>
<div id="container">
    <div id="header">
        Edit employee
    </div>
    <div id="content">
        <br>
        <form action="${pageContext.request.contextPath}/app?action=editEmpl" method="post">
            <div class="container">
                <div class="container error">
                    <c:if test="${not empty requestScope.errorList}">
                        <c:forEach items="${errorList}" var="error">
                            <p>${error}</p>
                        </c:forEach>
                    </c:if>
                </div>

                <hr>
                <label for="name" class="label">Name of employee</label>
                <input type="text" placeholder="Name" value="${name}" id="name"  name="name" required>

                <label for="yearsWorking" class="label">How many years has it been working</label>
                <input type="text" placeholder="How many years has it been working" value="${yearsWorking}" id="yearsWorking" name="yearsWorking" required>

                <label for="email" class="label">Email</label>
                <input type="text" placeholder="Email" value="${email}" id="email" name="email" required>

                <label for="deptId" class="label">In which department does employee work</label>
                <input type="text" placeholder="Department" value="${deptId}" id="deptId" name="deptId" required>

                <label for="dateOfBirth" class="label">Birthday</label>
                <input type="date" value="${birthDate}" id="dateOfBirth" name="dateOfBirth" placeholder="Date Of Birth" required>
                <hr>

                <input type="hidden" name="emplId" id="emplId" value="${emplId}">

                <button type="submit" class="add">Edit</button>
            </div>

            <div class="container back">
                <p>Back to <a href="${pageContext.request.contextPath}/app?action=listDept">list of departments</a>
                    or <a href="${pageContext.request.contextPath}/app?action=listEmpl">list of employee in ${deptId} dept</a>.</p>
            </div>
        </form>
    </div>
</div>
</body>
</html>
