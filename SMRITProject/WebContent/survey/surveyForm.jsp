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
설문조사
<form method="get" action="surveyOk.sv">
<c:forEach items="${list }" var="qosdto" varStatus="aaa">
	${aaa.count }번 문제)  ${qosdto.question.questionTitle }? <br />
		<c:forEach items="${qosdto.options}" var="options" >
			<c:if test="${options.optionsName != null}">
				<input type="radio" name="responses[${aaa.count }]" 
							value="${options.optionsNum }"/>${options.optionsName }
			</c:if>
			<c:if test="${options.optionsName == null}">
				<input type="text" name="responses[${aaa.count }]">
			</c:if>
		</c:forEach>
		<p />
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