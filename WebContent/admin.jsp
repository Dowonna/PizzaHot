<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="w3-main" style="margin-left: 100px; margin-top: 43px;">
	<br>
	<br>
	<br>
	<center>
		<h3>로그인이 필요한 페이지입니다.</h3>
		<hr>
		<p>
		<form action="Controller" Method="get">
			&nbsp;&nbsp;&nbsp;&nbsp;아이디 : <input type="text" name="id"> <br>
			패스워드 : <input type="password" name="pw"> <br> <input
				type="hidden" name="command" value="verification"> <input
				type="submit" value="로그인">
		</form>

	</center>
</div>