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
<div><a href="goodsCartList.gd" >장바구니 가기</a></div>
<table width=80% border="1" cellpadding="0" cellspacing="0" >
	<tr align="center" valign="middle">
		<td colspan="3">상품리스트</td>
		<td align=right>
			<font size=2>상품 개수 : ${goodsCount }</font>
		</td>
	</tr>
	<tr><td>번호</td><td>이미지</td><td>상품명</td><td>가격</td></tr>
	<c:forEach var="goods" items="${goodsList }" varStatus="status">
	<tr>
		<td>${status.count }</td>
		<td><img src="GoodsView/update/${goods.goodsImage }"/></td>
		<td><a href="goodsDetail.gd?num=${goods.goodsSeq }">
				${goods.goodsName  }</a></td>
		<td>${goods.goodsPrice  }</td>
	</tr>
	</c:forEach>	
</table>
<table>
<tr>
	<td>
		<c:if test="${page <=1 }">
		[이전]&nbsp;
		</c:if>
		<c:if test="${page > 1 }">
		<a href="goodsList.gd?page=${page -1 }">[이전]</a>
		</c:if>
	
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">	
			<a href="goodsList.gd?page=${i }">[${i }]</a>
		</c:forEach>
		
		<c:if test="${page >= maxPage }">
		[이후]&nbsp;
		</c:if>
		<c:if test="${page < maxPage }">
		<a href="goodsList.gd?page=${page +1 }">[이후]</a>
		</c:if>
	</td>
</tr>
</table>
<div><a href="goodsWriter.gd" >상품등록</a></div>
</body>
</html>