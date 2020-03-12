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
<form method="post">
<c:forEach items="${questions}" var="q" varStatus="status">
<p>
	${status.count }번 문제 ) ${q.title } <br />
	<c:if test="${q.choice }">
		<c:forEach items="${q.options }" var="option">
		<input type="radio" name="responses[${status.index}]" value="${option }" />${option }
		</c:forEach>
	</c:if>
	<c:if test="${!q.choice }">
		<input type="text" name="responses[${status.index}]">
	</c:if>
</p>	
</c:forEach>
<p>
<label>응답자 위치:<br>
<input type="text" name="res.location">
</label>
</p>
<p>
<label>응답자 나이:<br>
<input type="text" name="res.age">
</label>
</p>
<input type="submit" value="전송">
</form>
</body>
</html>