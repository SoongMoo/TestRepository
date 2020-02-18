<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<spring:message code="register.done" 
	 arguments="${memberCommand.userName },${memberCommand.userEmail }" />
	<br />
	<p><a href="<c:url value='/main'/>">메인으로</a>
</body>
</html>