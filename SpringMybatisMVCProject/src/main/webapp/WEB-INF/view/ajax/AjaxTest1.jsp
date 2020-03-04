<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn3").click(function(){
		$("#frm").ajaxSubmit({
			type : "post",
			url : "AjaxTest2",
			dataType: "html",
			success: function(result){
				$("#notice_content").html(result);
			},
			error: function(){
				alert('에러가 나왔다 홀홀홀~');
				return;
			} 
		});
	});

	$("#btn4").click(function(){
		var option = {
			type : "post",
			url : "AjaxTest2",
			dataType: "html",
			success: function(result){
				$("#notice_content").html(result);
			},
			error: function(){
				alert('에러가 나왔다 홀홀홀~');
				return;
			} 
		}
		$("#frm").ajaxSubmit(option);
	});
	
	$("#btn5").click(function(){
		var option = {
			type : "post",
			url : "AjaxTest2",
			dataType: "html",
			beforeSubmit: beforeTest,
			success: okTest,
			error: function(){
				alert('에러가 나왔다 홀홀홀~');
				return;
			} 
		}
		$("#frm").ajaxSubmit(option);
	});
});

function okTest(responseText, statusText, xhr, $form){
	if(statusText = "success"){
		$("#notice_content").html(responseText);
		$form.css('background','red');
	}
}
function beforeTest(){
	if($("#n").val() == ""){
		alert("값을 입력해주세요.");
		$("#n").focus();
		return false;
	}else{
		alert("Ajax가 실행되기전에 사용하는 함수다 홀홀홀~~")
	}
}

function testDiv(n){
	$.ajax({
		type : "post",
		url : "AjaxTest2",
		dataType: "html",
		data : "n=" + n, //AjaxTest2?n=2
		success: function(result){
			$("#notice_content").html(result);
		},
		error: function(){
			alert('에러가 나왔다 홀홀홀~');
			return;
		} 
	});
}
</script>
</head>
<body>
<div id="notice_content"> </div>
	<form id="frm" action="AjaxTest2">
		<input type="text" id="n" name="n" /> 
		<input type="submit" value="전송" />
	</form>
	<button id="btn2" onclick="javascript:testDiv(1)">버튼1</button>
	<button id="btn3" >버튼2</button>
	<button id="btn4" >버튼3</button>
	<button id="btn5" >버튼4</button>
</body>
</html>