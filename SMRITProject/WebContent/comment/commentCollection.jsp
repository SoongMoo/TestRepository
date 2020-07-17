<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commentCollection.jsp</title>
<script>
	function commentDel(num){
		if(confirm("정말 사실 진짜 real 삭제?")){
			location.href="commentDelete.cb?commentNo="+num
		}
	}
</script>
</head>
<body>
아이디번호 : ${cmtReDTO.commentDTO.cuserId }<br />
글번호 : ${cmtReDTO.commentDTO.commentNo }<br />
글제목 : ${cmtReDTO.commentDTO.commentSubject }<br />
글내용 : ${fn:replace(cmtReDTO.commentDTO.commentContent,cn,br) }<br />
작성일 : ${comment.regDate }<br />
<a href="commentModify.cb?commentNo=${cmtReDTO.commentDTO.commentNo }">
수정</a>
<a href="javascript:commentDel('${cmtReDTO.commentDTO.commentNo }');">
삭제</a>
<p>
<form action="replyInsert.cb" method="post" name="frm">
댓글 달어!!! : <br />
<textarea rows="3" cols="50" name="replyContent"></textarea>
<input type="hidden" name="commentNo" 
				value="${cmtReDTO.getCommentDTO().getCommentNo() }"/>
<input type="hidden" name= "cuserId" 
				value="${cmtReDTO.commentDTO.cuserId }">
<input type="submit" value="전송">
</p>
</form>
+++ 여기부터 댓글목록 +++ <br />
<c:forEach items="${cmtReDTO.replies }" var="reply">
<c:if test="${reply.replyNo != 0}">
<p>
답글번호 : ${reply.replyNo }<br />
답글작성자 : ${reply.ruserId }<br />
답글내용 : ${reply.replyContent }<br />
답글작성일시 : ${reply.regDate }<br />
<img src="" alt="수정하기" title="수정하기" />
<img src="" alt="삭제하기" title="삭제하기" />
</p>
</c:if>
</c:forEach>
</body>
</html>