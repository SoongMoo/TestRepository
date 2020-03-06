<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript">
$(function(){
	$("#wishBtn").click(function(){
		$.ajax({
			type: "POST",
			url: "goodsWishAdd",
			data : "num=${goods.goodsSeq }", 
			dataType:"html",
			success:wish_ok,
			error: function(){
				alert('서버오류 입니다. 잠시후 다시해주세요.');
				return;
			}
		});
	});
	$("#cartBtn").click(function(){
		$.ajax({
			type: "POST",
			url: "goodsCartAdd",
			data : "num=${goods.goodsSeq }", 
			dataType:"html",
			success:cart_ok,
			error: function(){
				alert('로그인 아웃 되었습니다.\n다시 로그인 해 주세요.');
				location.href="../main";
				return;
			}
		});
	});
});
function cart_ok(responseText, statusText, xhr, $form){
	if(statusText == "success"){
		if(confirm("장바구니로 가실려면 예를 눌러 주세요.")){
			location.href="goodsCartList";	
		}
	}
}
function wish_ok(responseText, statusText, xhr, $form){
	var i = responseText.trim();
	if(statusText == "success"){
		if( i == "1"){
			alert("관심상품에 등록되었습니다.")
		}else{
			alert("관심상품에 삭제되었습니다.")
		}
	}
}
</script>
</head>
<body>
<table align="center" width="600" border="1">
	<tr bgcolor="orange">
		<td align="right">
		<button id="wishBtn">관심상품</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button id="cartBtn">장바구니 담기</button>
		<a href="goodsCartAdd?num=${goods.goodsSeq }"></a>
	</tr>
</table>
<table align="center" width="600"  >
	<tr>
		<td rowspan="4">
		<c:forTokens items="${goods.goodsImage }" delims="-" var="goodsImage" 
				varStatus="ii">
		<c:if test="${ii.index == 0}">
		<img src="../GoodsView/update/${goodsImage }"/>
		</c:if>
		</c:forTokens>
		</td>
		<td>상품명 : ${goods.goodsName }</td>
	</tr>
	<tr>
	 <td>가격: ${goods.goodsPrice }</td>
	</tr>
	<tr>
	 <td>수량: ${goods.goodsQty }</td>
	</tr>
	<tr>
	 <td>상품 설명: ${goods.goodsContent }<br />
	 	<c:forTokens items="${goods.goodsImage }" delims="-" var="goodsImage" 
				varStatus="ii">
		<c:if test="${ii.index > 0}">
		<img src="../GoodsView/update/${goodsImage }"/>
		</c:if>
		</c:forTokens>
	 </td>
	</tr>
    <tr><td colspan="2" align="center">
    		<a href="goodsList.gd">목록보기</a> |
    		<a href=
    		"goodsDelete.gd?num=${goods.goodsSeq }&image=${goods.goodsImage }">
    		상품 삭제</a> |
    		<a href="goodsModify.gd?num=${goods.goodsSeq }">상품 수정</a>
    	</td>
    </tr>
</table>


</body>
</html>