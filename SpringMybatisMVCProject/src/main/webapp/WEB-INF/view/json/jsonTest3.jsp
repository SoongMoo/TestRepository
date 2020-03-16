<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
</head>
<body>
<div id="container"></div>
<input type="text" id="id" />
<button id="joinOk" >jsonView사용</button>
<button  onclick="javascript:history.back();" >뒤로가기</button>
</body>
<script type="text/javascript">
//Script
$("#joinOk").bind("click",function(){
        $.ajax({
            url : "ajax3.seo",
            type: "get",
            data : { "id" : $("#id").val() },
            success : function(responseData){
                var data = responseData.member;
                alert(responseData);
                $("#ajax").remove();
                if(!data){
                    alert("존재하지 않는 ID입니다");
                    return false;
                }
                var html = '';
                html += '<form class="form-signin" action="" id="ajax">';
                html += '이름<input type="text" class="form-control"  name="name" value="'+data.userName+'">';
                html += '아이디<input type="text" class="form-control" name=id" value="'+data.userId+'">';
                html += '이메일<input type="text" class="form-control"  name="email" value="'+data.userEmail+'">';
                html += '비밀번호<input type="text" class="form-control" name="password" value="'+data.userPw+'">';
                html += '</form>';
                $("#container").after(html);
            },
            error : function(request,status,error){
            	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });

    });
</script>
</html>