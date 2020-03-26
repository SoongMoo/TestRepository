<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
 src="http://code.jquery.com/jquery-latest.js" ></script>
<script type="text/javascript">
$(function(){
	$("#frm").submit(function(){
		if($("#userId").val() == ""){
			$("#userId").focus();
			alert("아이디를 입력하세요.");
			return false;
		}
		if($("#userPw").val() == ""){
			$("#userPw").focus();
			alert("비밀번호를 입력하세요.");
			return false;
		}
		if($("#userPw").val() !=  $("#userPwCon").val()){
			$("#userPw").val("");
			$("#userPwCon").val("");
			$("#userPw").focus();
			alert("비밀번호가 다릅니다.");
			return false;
		}
		if($("#userName").val()==""){
			$("#userName").focus();
			alert("사용자 이름을 입력하세요.");
			return false;
		}
		if($("#userBirth").val()==""){
			$("#userBirth").focus();
			alert("사용자 생년월일을 입력하세요.");
			return false;
		}
		if($("#userPh1").val()==""){
			$("#userPh1").focus();
			alert("사용자 연락처을 입력하세요.");
			return false;
		}
		if($("#confirmNum").val() == "1"){
			alert("중복확인을 해주세요.");
			return false;
		}
	});
	$("#userConfirm").click(function(){
		if($("#userId").val() == ""){
			$("#userId").focus();
			alert("아이디를 입력하세요.");
			return false;
		}
		var url="userConfirm.nhn?userId="+$("#userId").val();
		open(url,"userConfirm","width=300, height=200" );
	});
});
</script>
</head>
<body>
<form action="MemberJoinAction.nhn" name = "frm" id="frm" method = "post" >
<input type="hidden" name = "confirmNum" id = "confirmNum" value="1">
 <table width = 600 align = "center" border = 1 >
 	<tr>
 		<td width = "200">사용자 ID</td>
 		<td width = "400"><input type = "text" name="userId" 
 			size = "12" maxlength="10" id="userId">
 			<input type ="button" name="userConfirm" id="userConfirm" value="중복확인">
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">비밀번호</td>
 		<td  width = "400">
 			<input type = "password" name="userPw" id = "userPw"
 			size = "12" maxlength="10">
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">비밀번호 확인</td>
 		<td  width = "400">
 			<input type = "password" name="userPwCon" 
 			 id = "userPwCon" size = "12" maxlength="10">
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">사용자 이름</td>
 		<td  width = "400">
 			<input type = "text" name="userName" 
 			 id = "userName" size = "12" maxlength="10">
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">생년원일</td>
 		<td  width = "400">
 			<input type = "text" name="userBirth" 
 			 id = "userBirth" size = "12" maxlength="10">
 		</td>
 	</tr>
 	<tr>
 		<td  width = "200">성별</td>
 		<td  width = "400">
 			남자 : <input type="radio" value="M" name="userGender" 
 			 id  = "userGender" checked="checked">
 			 여자 : <input type="radio" value="F" name="userGender" 
 			 id  = "userGender">
 		</td>
 	</tr>
 	<tr><td width = 200 ><b>사용자 이메일 </b></td>
		<td width = 400 >
			<input type="text" name="userEmail" 
				id = "userEmail" size = "30" maxlength="28"/>
		</td>
	</tr>
	<tr><td width = 200 ><b>사용자 주소 </b></td>
		<td width = 400 >
			<input type="text" name="userAddr" 
				id = "userAddr" size = "30" maxlength="28"/>
		</td>
	</tr>
	<tr><td width = 200 ><b>* 사용자 연락처1 </b></td>
		<td width = 400 >
			<input type="text" name="userPh1" 
				id = "userPh1" size = "30" maxlength="28"/>
		</td>
	</tr>
	<tr><td width = 200 ><b>* 사용자 연락처2 </b></td>
		<td width = 400 >
			<input type="text" name="userPh2" 
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
</form>
</body>
</html>