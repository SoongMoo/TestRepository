<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comment_list.jsp</title>
</head>
<body>
<table>
<c:if test="${!empty comments }">
	<tr><td colspan="3">댓글게시판</td>
		<td>댓글 갯수 : ${count }</td></tr>
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td><td>작성일</td>
	</tr>
	<c:forEach items="${comments }" var="dto" varStatus="cnt">
	<tr>
		<td>${cnt.count }</td>
		<td><a href="commentDetail?commentNo=${dto.commentNo }">
		${dto.commentSubject }</a></td>
		<td>${dto.cuserId }</td>
		<td>
		<fmt:formatDate value="${dto.regDate }" type="date" 
		pattern="yyyy-MM-dd"/> 
		</td>
	</tr>
	</c:forEach>
	<tr><td><%@ include file="../include/includePage.jsp" %></td></tr>
</c:if>
<c:if test="${empty comments }">	
	<tr><td colspan="4">등록된 댓글이 없습니다.</td></tr>
</c:if>	
	<tr>
		<td colspan="4">
			<a href="commentBoard">[글쓰기]</a>
		</td>
	</tr>
</table>
</body>
</html>