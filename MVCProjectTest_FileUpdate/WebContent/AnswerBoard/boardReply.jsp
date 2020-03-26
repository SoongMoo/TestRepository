<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	function replyboard(){
		frm.submit();
	}
	</script>
</head>
<body>
<form action="answerBoardReplyPro.ab" method="post" name="frm">
<input type="hidden" name="boardNum" value="${board.boardNum }">
<input type="hidden" name="boardReRef" value="${board.boardReRef }">
<input type="hidden" name="boardReLev" value="${board.boardReLev }">
<input type="hidden" name="boardReSeq" value="${board.boardReSeq }">
<table border="1" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan=2>답글</td>
	</tr>
	<tr >
		<td height="16" align="center">글쓴이</td>
		<td><input type="text" name="boardName" /></td>
	</tr>
	<tr >
		<td height="16" align="center">제목</td>
		<td><input type="text" name="boardSubject" size="50" 
		value="Re:${board.boardSubject }" /></td>
	</tr>
	<tr >
		<td height="16" align="center">내용</td>
		<td><textarea cols="67" rows="15" name="boardContent">${board.boardContent } &#10;====================== &#10;====================== &#10;====================== &#10;</textarea></td>
	</tr>
	<tr >
		<td height="16" align="center">글쓴이</td>
		<td><input type="password" name="boardPass" /></td>
	</tr>
	<tr align="center" valign="middle">
		<td colspan="2">
		<a href="javascript:replyboard()">[등록]</a>&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>