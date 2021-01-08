<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% String url = application.getContextPath() + "/"; %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>PizzaHot</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
  <div class="w3-bar-block">
	<a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a onclick="home()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-home fa-fw"></i>  Overview</a>
    <a onclick="menu()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-pizza-slice fa-fw"></i>  MENU</a>
    <a onclick="about()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bullhorn fa-fw"></i>  ABOUT</a>
    <a onclick="reservation()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-calendar-plus fa-fw"></i>  Reservation</a>
    <a onclick="search1()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-search fa-fw"></i>  Search</a>
    <a onclick="home.html/administer()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user-shield fa-fw"></i>  Administer</a>
    </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<br><br><br>
<center>
<h3>음식 list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>번호</th><th>이름</th><th>갯수</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.reservationAll}" var="data">
		<tr>
			<td>${data.reservationNum}</td>
			<td>${data.menuName}</td>
			<td>${data.foodNum}</td>
			
		</tr>
	</c:forEach>
	





</table>

<br><br><br>
<br><br><br>
<a href="${pageContext.request.contextPath}/home.html">메인 화면 이동</a>
</center>
</body>
</html>