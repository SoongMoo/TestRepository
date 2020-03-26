<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_view.jsp</title>
</head>
<body>
<table width=50% border="1" cellpadding="0" cellspacing="0" >
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16">답변형 게시판 </td>
		<td style="font-size:12" align="right">
			조회수 : ${board.boardReadcount } 
			| 등록일  <fmt:formatDate value="${board.boardDate }" type="date" />
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16">글쓴이 </td>
		<td style="font-size:12">
			${board.boardName } 
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16">제목 </td>
		<td style="font-size:12" >
			${board.boardSubject } 
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td style="font-size:12" height="16" >내용 </td>
		<td style="font-size:12">
			${board.boardContent }
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td colspan=2>
			<a href ="answerBoardReply.ab?num=${board.boardNum }" >[답변]</a> | 
			<a href ="answerBoardUpdate.ab?num=${board.boardNum }" >[수정]</a> | 
			<a href ="answerBoardDelete.ab?num=${board.boardNum }" >[삭제]</a> | 
			<a href ="answerBoard.ab" >[목록]</a>
		</td>
	</tr>
</table>
</body>
</html>