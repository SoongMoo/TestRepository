<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="goodsPro.gd" method="post" enctype="multipart/form-data" >
	<table border="1">
		<tr><td>상품번호</td>
			<td><input type="text" name="goodsNum" id="goodsNum" />
			</td>
		</tr>
		<tr><td>상품명</td>
			<td><input type="text" name="goodsName" id="goodsName" />
			</td>
		</tr>
		<tr><td>상품가격</td>
			<td><input type="text" name="goodsPrice" id="goodsPrice" />
			</td>
		</tr>
		<tr><td>상품 설명</td>
			<td><textarea rows="13" cols="56" 
					name="goodsContent" id="goodsContent"></textarea>
			</td>
		</tr>
		<tr><td>상품 이미지</td>
			<td><input type="file" name="goodsImage" id="goodsImage" >
			</td>
		</tr>
		<tr>
			<td colspan=2>
				<input type="submit" value="상품등록" />
				<input type="reset" value="취소" />
				<input type="button" value="메인으로 이동" onclick=""/>
			</td>
		</tr>
	</table>				
</form>
</body>
</html>