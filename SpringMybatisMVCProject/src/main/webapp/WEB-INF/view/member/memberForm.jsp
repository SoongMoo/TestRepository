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
<form:form action="memberJoinAction" name = "frm" id="frm" 
	method = "post" commandName="memberCommand">
 <table width = 600 align = "center" border = 1 >
 	<tr>
 		<td width = "200">사용자 ID</td>
 		<td width = "400">
 			<form:input path="userId" 
 			size = "12" maxlength="10" id="userId" />
 			<form:errors path="userId"/>
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">비밀번호</td>
 		<td  width = "400">
 			<form:password path="userPw" id = "userPw"
 			size = "12" maxlength="10" />
 			<form:errors path="userPw"/>
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">비밀번호 확인</td>
 		<td  width = "400">
 			<form:password path="userPwCon" 
 			 id = "userPwCon" size = "12" maxlength="10" />
 			<form:errors path="userPwCon"/>
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">사용자 이름</td>
 		<td  width = "400">
 			<form:input  path="userName" 
 			 id = "userName" size = "12" maxlength="10" />
 			<form:errors path="userName" />
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">생년원일</td>
 		<td  width = "400">
 			<form:input  path="userBirth" 
 			 id = "userBirth" size = "12" maxlength="10" />
 			<form:errors path="userBirth" />
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">성별</td>
 		<td  width = "400">
 			남자 : <form:radiobutton value="M" path="userGender" 
 			 id  = "userGender" checked="checked" />
 			 여자 : <form:radiobutton value="F" path="userGender" 
 			 id  = "userGender" />
 		</td>
 	</tr>
 	<tr><td width = 200 ><b>사용자 이메일 </b></td>
		<td width = 400 >
			<form:input  path="userEmail" 
				id = "userEmail" size = "30" maxlength="28"/>
			<form:errors path="userEmail"/>
		</td>
	</tr>
	<tr><td width = 200 ><b>사용자 주소 </b></td>
		<td width = 400 >
			<form:input path="userAddr" 
				id = "userAddr" size = "30" maxlength="28"/>
			<form:errors path="userAddr"/>
		</td>
	</tr>
	<tr><td width = 200 ><b>* 사용자 연락처1 </b></td>
		<td width = 400 >
			<form:input path="userPh1" 
				id = "userPh1" size = "30" maxlength="28"/>
			<form:errors path="userPh1"/>
		</td>
	</tr>
	<tr><td width = 200 ><b>* 사용자 연락처2 </b></td>
		<td width = 400 >
			<form:input path="userPh2" 
				id = "userPh2" size = "30" maxlength="28"/>
		</td>
	</tr>
	<tr>
		<td colspan = 2>
			<input type= "submit" value="가입완료" />
			<input type= "reset" value="다시 입력" />
			<input type= "button" value="가입 안함" />
 		</td>
	</tr>
 </table>
</form:form>
</body>
</html>