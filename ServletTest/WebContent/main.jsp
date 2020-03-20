<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>옵션을 이용하여 페이지 선택</title>
</head>
<body>
	<form action="view.jsp">
		원하는 페이지 선택:
		<select name="code">
		    <option value="1">1 페이지</option>
		    <option value="2">2 페이지</option>
		    <option value="3">3 페이지</option>
		</select>
		<input type="submit" value="이동">
	</form>
</body>
</html>