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
<p>응답 내용:</p>
	<c:forEach items="${ansData.responses }" var="response" 
		varStatus="status">
		${status.count }번 문항 : ${response } <br />
	</c:forEach>    
	<p>응답자 위치: ${ansData.res.location }</p>
	<p>응답자 나이: ${ansData.res.age }
</body>
</html>