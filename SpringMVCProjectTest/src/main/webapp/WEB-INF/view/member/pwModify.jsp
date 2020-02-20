<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pwModify.jsp</title>
</head>
<body>

<form:form action = "changePassword" method="post" name="frm" 
	commandName = "memberCommand" >
	<form:hidden path = "userId" />
	<spring:message code="password" /> : 
	<form:password path = "userPw" id = "pw" /><br />
	<form:errors path="userPw"/>
	<br />
	<input type="submit" value="확인" />
</form:form>
</body>
</html>