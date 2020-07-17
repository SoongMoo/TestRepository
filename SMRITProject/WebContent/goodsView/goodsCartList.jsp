<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkQty(num, qty){
	if(qty > 1){
		location.href="goodsCartQtyDown.gd?goodsNum="+num;
	}else{
		return false;
	}
}
</script>
</head>
<body>
<form action="goodsCartRemove.gd" method="post" name="frm">
<table align="center" width="600" border="1">
	<tr align="center" bgcolor="orange">
		<td>번호	</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
		<td align="center">
		<input type="submit"  value="삭제" />
		</td>
	</tr>
<c:forEach items="${cartList }" var="dto" varStatus="cnt">
	<tr align="center" bgcolor="orange">
		<td>${cnt.count }</td>
		<td><img src = "../goodsView/upload/${dto.goodsImage }" 
					width="30"/>
		</td>
		<td>${dto.goodsName }</td>
		<td>
			<fmt:formatNumber value="${dto.goodsPrice }" 
										type="currency"/>
		</td>
		<td><a href="goodsCartAdd.gd?goodsNum=${dto.goodsNum }"> + </a> 
		 ${dto.qty }
		<a href="javascript:checkQty('${dto.goodsNum }','${dto.qty }');" > - </a></td>
		<td align="center">
		<input type="checkbox" name="delete" value="${dto.cartNum }" />
		</td>
	</tr>	
</c:forEach>
</table>
</form>
<table align="center" width="600" border="0">
	<tr align="center" bgcolor="yellow">
		<td align="right" colspan="6">
		<font color ="gray" size="5">
			총 결제금액 :
			<fmt:formatNumber value="${cartList[0].sumTotalPrice }"
				type="currency"/></font>
		<font color ="black" size="5">원</font>
		</td>
	</tr>
</table>
<a href="goodsList.gd" >목록으로 가기</a>
</body>
</html>