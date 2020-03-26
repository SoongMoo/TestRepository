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
	$("#btn").click(function(){
		if($("#btn").attr("value") == "삭제"){
			$("#btn").attr("value","삭제취소");
			$("#fileDel").val("${goods.goodsImage}");
			$("#imageView").html(
					"<input type='file' name='goodsImage' >");
		}else{
			$("#btn").attr("value","삭제");
			$("#fileDel").val("");
			$("#imageView").html("");
		}
	});
});
</script> 
</head>
<body>
<form action="goodsModifyPro.gd" method="post" enctype="multipart/form-data" >
	<table border="1">
		<tr><td>상품번호</td>
			<td>${goods.goodsNum }</td>
		</tr>
		<tr><td>상품명</td>
			<td>${goods.goodsName }</td>
		</tr>
		<tr><td>상품가격</td>
			<td><input type="text" name="goodsPrice" id="goodsPrice" 
				value="${goods.goodsPrice }"/>
			</td>
		</tr>
		<tr><td>입고수량</td>
			<td><input type="text" name="goodsQty" id="goodsQty" 
				value = "${goods.goodsQty }"/>
			</td>
		</tr>
		<tr><td>상품 설명</td>
			<td><textarea rows="13" cols="56"
					name="goodsContent" id="goodsContent">${goods.goodsContent }</textarea>
			</td>
		</tr>
		<tr>
			<td>파일</td>
			<td >${goods.goodsImage }
				<input type="button" id="btn" value="삭제"/>
				<img src="Goods/upload/${goods.goodsImage }" width="30" height="30"/>
			</td>
		</tr>
		<tr><td>상품 이미지</td>
			<td><div id="imageView"></div>
			</td>
		</tr>
		<tr>
			<td colspan=2>
				<input type="submit" value="상품수정" />
				<input type="button" value="메인으로 이동" onclick="mainGo();"/>
			</td>
		</tr>
	</table>	
	<input type="text" name="fileDel" id = "fileDel" />		
	<input type="text" name="goodsSeq" id = "goodsSeq" 
		value="${goods.goodsSeq }"/>	
</form>
</body>
</html>