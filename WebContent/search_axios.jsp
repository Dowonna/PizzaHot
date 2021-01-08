<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="w3-main" style="margin-left: 100px; margin-top: 43px;">
	<br><br><br>
	<center>
		<h3>로그인이 필요한 페이지입니다.</h3>
		<hr>
		<p>
		<form action="Controller" Method="get">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이름 : <input
				type="text" name="Name"> <br> 전화번호 : <input
				type="password" name="Phone"> <br> <input type="hidden"
				name="command" value="someguest"> <input type="submit"
				value="로그인">
		</form>
	</center>
	
</div>