<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA 게시판</title>
</head>
<body>
<table width=50% border="0" cellpadding="0" cellspacing="0">
<!-- 데이터가 있는 경우 -->
<c:if test="${!empty list1234  }">
	<tr align="center" valign="middle">
		<td colspan="4">QNA 게시판</td>
		<td align=right>
			<font size=2>글 개수 : ${qnaCount }</font>
		</td>
	</tr>
	<tr align="center" valign="middle" bordercolor="#333333">
		<td width="8%" height="26">번호</td>
		<td width="50%">제목</td>
		<td width="14%">작성자</td>
		<td width="17%">날짜</td>
		<td width="11%">조회수</td>
	</tr>
<c:forEach items="${list1234}" var="dto" varStatus="cnt">
	<tr align="center" valign="middle">
		<td height="23">${cnt.count }</td><!-- 1, 2, 3,... -->
		                            <!-- index : 0,1,2,... -->
		<td><a href="qnaDetail.qna?num=${dto.boardNum }">
			${dto.boardSubject}</a></td>
		<td >${ dto.boardName }</td>
		<td >${ dto.boardDate }</td>	
		<td>${ dto.readCount }</td>
	</tr>
</c:forEach>
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
<%@ include file="/include/includePage.jsp" %>
		</td>
	</tr>
</c:if>
<!-- 데이터가 있는 영역 -->
<!-- 데이터가 없는 경우 -->
<c:if test="${empty list1234  }">
	<tr align="center" valign="middle">
		<td colspan="5">QNA 게시판</td>
	</tr>
	<tr>
		<td align=right colspan="5">
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>
</c:if>
<!-- 끝 -->

	<tr align="right">
		<td colspan="5">
	   		<a href="qnaWrite.qna">[글쓰기]</a>
		</td>
	</tr>
</table>
</body>
</html>