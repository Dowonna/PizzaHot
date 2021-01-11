<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% String url = application.getContextPath() + "/"; %>
<<c:if test="${empty sessionScope.user}">
	<c:redirect url="home.html"/> 
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>PizzaHot</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/f51c1b79cc.js" crossorigin="anonymous"></script>
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <span class="w3-bar-item w3-right">Logo</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <jsp:include page="nav.jsp"/>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<div id = "11" class="w3-main" style="margin-left:100px;margin-top:43px;">
<br><br><br>
<center>
<h3>예약 list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>id</th><th>이름</th><th>핸드폰번호</th><th>방문자 수</th><th>날짜</th><th>삭제</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.guestAll}" var="data">
		<tr>
			<td><form action="Controller">
			    	<input type="hidden" name="id" value=${data.id}>
			    	<input type="hidden" name="command" value="getSomeReservation"/>			    
			    	<input type="submit" value=${data.id}>
			  </form></td>
			<td>${data.name}</td>
			<td>${data.phone}</td>
			<td>${data.people}</td>
			<td>${data.data}</td>
			<td><form action="Controller">
			    	<input type="hidden" name="id" value=${data.id}>
			    	<input type="hidden" name="Name" value=${data.name}>
			    	<input type="hidden" name="Phone" value=${data.phone}>			    	
			    	<input type="hidden" name="command" value="deleteGuest"/>			    
			    	<input type="submit" value="삭제">
			  </form></td>
			
		</tr>
	</c:forEach>
</table>

<br><br><br>
<font color="blue">id를 클릭하면 상세 정보 확인이 가능합니다</font>
<br><br><br>
<a href="Controller?command=menuManage">메뉴 관리하기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/home.html">뒤로가기</a>
</center>
</div>
</body>
</html>