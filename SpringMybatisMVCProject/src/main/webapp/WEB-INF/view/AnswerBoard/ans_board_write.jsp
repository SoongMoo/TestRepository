<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form  method="POST"  name="frm"
	commandName="answerCommand" enctype="multipart/form-data" >
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">MVC 게시판</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이</div>
		</td>
		<td>
			<form:input path="boardName" size="10" maxlength="10" />
			<form:errors path="boardName"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<form:password path="boardPass"  size="10" maxlength="10" />
			<form:errors path="boardPass"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td>
			<form:input path="boardSubject" size="50" maxlength="100" />
			<form:errors path="boardSubject"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<form:textarea path="boardContent" cols="67" rows="15" />
		</td>
	</tr>
	<tr>
		<td>파일 첨부</td>
		<td>
			<input type="file"  name="boardFile"  multiple = "multiple" />
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">
			<a href="javascript:frm.submit();">[등록]</a>&nbsp;&nbsp;
			
			<a href="javascript:location.href='answerBoard';">[뒤로]</a>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>