<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" width="600" border="1">
	<tr bgcolor="orange">
		<td align="right">조회수 : ${list[0].goodsVisit }
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="goodsCartAdd.gd?goodsNum=${list[0].goodsNum }">장바구니 담기</a>
	</tr>
</table>

<table align="center" width="600"  >
	<tr>
		<td rowspan="4">
		<img src="../goodsView/upload/${list[0].goodsImage }"/></td>
		<td>상품명 : ${list[0].goodsName } </td>
	</tr>
	<tr>
	 <td>가격: ${list[0].goodsPrice }</td>
	</tr>
	<tr>
	 <td>상품 설명: ${list[0].goodsContent }</td>
	</tr>
    <tr><td colspan="2" align="center">
    		<a href="goodsList.gd">목록보기</a> |
    		<a href=
    		"goodsDelete.gd?goodsNum=${list[0].goodsNum }&image=${list[0].goodsImage }">
    		상품 삭제</a> |
    		<a href="goodsModify.gd?goodsNum=${list[0].goodsNum }">상품 수정</a>
    	</td>
    </tr>
</table>
</body>
</html>