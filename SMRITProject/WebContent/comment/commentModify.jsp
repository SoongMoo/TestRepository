<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="commentModifyPro.cb" name="frm" method="post">
	<input type="hidden" name="commentNo" 
							value="${comment.commentNo }"/>
	아이디번호 : ${comment.cuserId }<br />
	글번호 : ${comment.commentNo }<br />
	글제목 : <input type="text" name="commentSubject" 
				value="${comment.commentSubject }"><br />
	글내용 : <textarea rows="5" cols="50" name="commentContent">${comment.commentContent }</textarea><br />
	<input type="submit" value="전송">
</form>
</body>
</html>