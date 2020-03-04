<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Third Domino</h2>
		<select id="csel" name="cNum">
		<option value="">--------선택하세요--------</option>
		<c:forEach items="${cc }" var="cdto" >
		<option value="${cdto.c1 }">${cdto.c2 }</option>
		</c:forEach>
		</select>
</body>
</html>