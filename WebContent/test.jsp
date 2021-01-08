<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<form action="Controller" method="post">
		<input type="hidden" name="command" value="menuUpdate">
		<input type="hidden" name="menu" value="${param.name}">
		<table border="1" style="height: 205px; text-align: left">
			<tr>
				<td>메뉴명</td><td>${param.name}</td>
			</tr>
			<tr>
	 			<td>표시재료</td><td>${param.config}</td>
			</tr>
			<tr>	
				<td>부연설명</td><td><input type="text" name="status" value="${param.status}"></td>
		 	</tr>
		 	<tr>
	 			<td>가격</td><td><input type="text" name="price" value="${param.price}"></td>
	 		</tr>
	 		<tr>
	 			<td>카테고리</td><td>${param.category}</td>
	 		</tr>
	 		<tr>
	 			<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소"></td>
	 		</tr>
		</table>
	</form> 