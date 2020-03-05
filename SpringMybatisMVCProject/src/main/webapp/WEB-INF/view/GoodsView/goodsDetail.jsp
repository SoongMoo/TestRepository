<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<table align="center" width="600" border="1">
	<tr bgcolor="orange">
		<td align="right">
		<a href="goodsWishAdd?num=${goods.goodsSeq }">관심상품
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="goodsCartAdd?num=${goods.goodsSeq }">장바구니 담기</a>
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