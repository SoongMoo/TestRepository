<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="answerBoardWritePro.ans" method="POST"  name="frm" enctype="multipart/form-data" >
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">MVC 게시판</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이</div>
		</td>
		<td>
			<input type="text" name="boardName" size="10" maxlength="10" />
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input type="text" name="boardPass"  size="10" maxlength="10" />

		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td>
			<input type="text" name="boardSubject" size="50" maxlength="100" />

		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="boardContent" cols="67" rows="15" ></textarea>
		</td>
	</tr>
	<tr>
		<td>파일</td>
		<td><input type="file" name="fileUp"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">
			<a href="javascript:frm.submit();">[등록]</a>&nbsp;&nbsp;
			
			<a href="javascript:location.href='answerBoard';">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>