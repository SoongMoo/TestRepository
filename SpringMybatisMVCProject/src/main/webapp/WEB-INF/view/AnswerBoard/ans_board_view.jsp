<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="2">MVC 게시판</td>
	</tr>
	<tr align="left" valign="middle">
		<td colspan="2">글쓴이 : ${answerCommand.boardName }
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${answerCommand.ipAddr }</td>
	</tr>	
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목&nbsp;&nbsp;</div>
		</td>
		
		<td style="font-family:돋음; font-size:12">
		<c:set var="string1" value="${answerCommand.boardSubject }"/>
		<c:set var="string2" value="${fn:replace(string1, '&#10;', '<br />')}" />
		${string2}
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td style="font-family:돋음; font-size:12">
			<table border=0 width=490 height=250 style="table-layout:fixed">
				<tr>
					<td valign=top style="font-family:돋음; font-size:12">
					${answerCommand.boardContent }
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">첨부파일</div>
		</td>
		<td style="font-family:돋음; font-size:12">
		<c:forEach items="${storeFileName }" var="str" varStatus="status">
		<a href="../../AnswerBoard/update/${str }">
			${originalfileName[status.index] }
		</a><br />
		</c:forEach>
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<a href="../answerBoardReply?num=${answerCommand.boardNum }">
			[답변]
			</a>&nbsp;&nbsp;
			<a href="../boardModify?num=${answerCommand.boardNum }">
			[수정]
			</a>&nbsp;&nbsp;
			<a href="../boardDelete?num=${answerCommand.boardNum }">
			[삭제]
			</a>&nbsp;&nbsp;
			<a href="../answerBoard">[목록]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</body>
</html>