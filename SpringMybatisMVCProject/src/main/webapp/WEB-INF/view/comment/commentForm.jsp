<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="comment_insert" name = "frm" method="post">
	입력할 제목 : <input type="text" name="commentSubject"><br />
	입력할 내용 : <input type="text" name="commentContent"><br />
	<input type="submit" value="전송">
</form>
</body>
</html>