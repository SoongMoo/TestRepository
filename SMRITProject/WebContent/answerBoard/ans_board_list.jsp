<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
</head>
<body>
<table width=50% border="0" cellpadding="0" cellspacing="0">
<c:if test="${!empty list }">
	<tr align="center" valign="middle">
		<td colspan="4">MVC 게시판</td>
		<td align=right>
			<font size=2>글 개수 :${count }</font>
		</td>
	</tr>	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
			<div align="center">번호</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">제목</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">작성자</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="17%">
			<div align="center">날짜</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="11%">
			<div align="center">조회수</div>
		</td>
	</tr>
	<c:forEach items="${list }" var="dto" varStatus="cnt">
	<tr align="center" valign="middle" bordercolor="#333333">
		<td height="23">${cnt.count }</td>
		<td>
			<div align="left">
			<c:forEach begin="1" end="${dto.boardReLev }" 
				step="1">
				▶
			</c:forEach>
			<a href="ansBoardDetail.ans?boardNum=${dto.boardNum }">
			${dto.boardSubject }</a></div>
		</td>
		<td><div align="center">${dto.boardName }</div></td>
		<td ><div align="center">${dto.boardDate }</div></td>	
		<td ><div align="center">${dto.readCount }</div></td>
	</tr>
	</c:forEach>
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			<%@ include file="/include/includePage.jsp" %>
		</td>
	</tr>
</c:if>
<c:if test="${empty list }">
	<tr align="center" valign="middle">
		<td colspan="4">MVC 게시판</td>
		<td align=right>
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>
</c:if>
	<tr align="right">
		<td colspan="5">
	   		<a href="ansBoardWrite.ans">[글쓰기]</a>
		</td>
	</tr>
</table>
</body>
</html>