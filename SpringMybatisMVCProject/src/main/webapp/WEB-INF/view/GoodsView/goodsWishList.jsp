<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsWishList</title>
</head>
<body>
번호 &nbsp;&nbsp;&nbsp;&nbsp;
상품명&nbsp;&nbsp;&nbsp;&nbsp;
이미지&nbsp;&nbsp;&nbsp;&nbsp;
가격<br />
<c:forEach items="${wishList }" var="goods">
${goods.goodsNum } &nbsp;&nbsp;&nbsp;&nbsp; 
<a href="goodsDetail?num=${goods.goodsSeq }" >${goods.goodsName }</a>&nbsp;&nbsp;&nbsp;&nbsp;
<c:forTokens items="${goods.goodsImage } " var="goodsImage" delims="-" varStatus="ii">
	<c:if test="${ii.index == 0 }">
		<img src="../GoodsView/update/${goodsImage }" width="30" height="30" />
	</c:if>
</c:forTokens>
&nbsp;&nbsp;&nbsp;&nbsp;${goods.goodsPrice }
</c:forEach>

</body>
</html>