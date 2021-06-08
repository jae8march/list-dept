<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>New dept</title>
</head>
<style>
    <%@include file='../../style/table.css' %>
    <%@include file='../../style/main.css' %>
    <%@include file='../../style/form.css' %>
</style>

<body>
<div id="container">
    <div id="header">
        Create department
    </div>
    <div id="content">
        <br>
        <form action="${pageContext.request.contextPath}/app?action=addDept" method="post">
            <div class="container">
                <div class="container error">
                    <c:if test="${not empty requestScope.errorList}">
                        <c:forEach items="${errorList}" var="error">
                            <p>${error}</p>
                        </c:forEach>
                    </c:if>
                </div>
                <hr>
                <label for="name" class="label">Name of new department</label>
                <input type="text" placeholder="Enter unique name" value="${name}" id="name" name="name" required>

                <label for="phone" class="label">Department phone number</label>
                <input type="text" placeholder="Phone" value="${phone}" id="phone" name="phone" required>
                <hr>

                <button type="submit" class="add">Add</button>
            </div>

            <div class="container back">
                <p>Back to <a href="${pageContext.request.contextPath}/app?action=listDept">list of departments</a>.</p>
            </div>
        </form>
    </div>
</div>
</body>
</html>
