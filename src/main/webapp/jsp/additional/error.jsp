<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Something went wrong</title>
</head>
<style>
    <%@include file='../../style/main.css' %>
</style>
<body>
<div id="container">
    <div id="header">
        Error
    </div>
    <br>
    <div id="content">
        <h1>Sorry, something went wrong.</h1>
        <h2>Back to <a href="${pageContext.request.contextPath}/app?action=listDept">list of departments</a>.</h2>
    </div>
</div>
</body>
</html>
