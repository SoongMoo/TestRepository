<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty memId}">
	<script>
		location.href="index.nhn";
	</script>
</c:if>

<table width=100% border="1" cellpadding="0" cellspacing="0" align="center">
<c:if test="${! empty boardList }">
	<tr align="center" valign="middle">
		<td align='center' colspan="4">답변 게시판</td>
		<td align=right>
			<font size=2>글 개수 : ${boardCount }</font>
		</td>
	</tr>
	<tr align="center" valign="middle" >	
		<td width="8%" height="26">번호</td>
		<td width="28%" height="26">제목</td>
		<td width="8%" height="26">작성자</td>
		<td width="8%" height="26">날짜</td>
		<td width="8%" height="26">조회수</td>
	</tr>
	<c:forEach var="board" items="${boardList }" varStatus="status" >
	<tr valign="middle" >	
		<td width="8%" height="26" align="center">${status.count }</td>
		<td width="28%" height="26" align="left">	
			<c:forEach begin="1" end="${board.boardReLev }" step="1" >
			▶ 
			</c:forEach>
			<a href = "answerBoardDetail.ab?num=${board.boardNum }">
			${board.boardSubject }
			</a>
		</td>
		<td width="8%" height="26" align="center">${board.boardName }</td>
		<td width="8%" height="26" align="center">
			<fmt:formatDate value="${board.boardDate }" type="date" /> 
		</td>
		<td width="8%" height="26" align="center">${board.boardReadcount }</td>
	</tr>
	</c:forEach>
</c:if>
<c:if test="${empty boardList }">
	<tr align="center" valign="middle">
		<td align=center colspan="4">답변 게시판</td>
		<td align=right>
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>
</c:if>
	<tr align="right">
		<td colspan="5">
	   		<a href="answerBoardWrite.ab">[글쓰기]</a>
		</td>
	</tr>
</table>
</body>
</html>