<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border =1>
	<tr><td colspan=3>
			자동로그인<input type="checkbox" 
			name="autoLogin" value="auto"/>
		</td>
	</tr>
	<tr><td>아이디 입력</td>
		<td>
		<input type ="text" id="id1" name="id1" />
		</td>
		<td><input type="checkbox" name="idStore" 
		 value="store" />
		</td>
	</tr>
	<tr><td>비밀번호</td>
		<td>
			<input type="password" id="pw" name="pw" />
		</td>
		<td><input type="button" id="btn" value="로그인" /></td>
	</tr>
	<tr><td colspan=3>
		<a href="#">아이디 찾기</a>|<a href="#">비밀번호 찾기</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="register/agree">회원가입</a>
	</td></tr>
</table>
<!-- 로그인 되었을 때 -->
<a href ="memberDetail">내 정보</a>
<a href ="logout" >로그아웃</a>
<a href ="memberList">회원리스트</a>
<a href ="board">공지사항 게시판</a>
<a href ="library">일반 자료실</a>
<a href ="answerBoard">답변형 게시판</a>
<a href ="commentBoard">댓글 게시판</a>
<a href ="goodsList">상품목록</a>
<a href="mailForm">메일전송</a>
</body>
</html>