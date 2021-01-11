<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="model.Service"%>
<% String url = application.getContextPath() + "/"; %>

<<c:if test="${empty sessionScope.user}">
	<c:redirect url="home.html"/> 
</c:if>
<!DOCTYPE html>
<html>
<title>PizzaHot</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/f51c1b79cc.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
#left_banner
{	
	position: fixed;
	width:200px;
	height:400px;
	top:300px;
	right:0%;
	background-color:#ccff33;
}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> Â Menu</button>
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

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">
<div class="w3-display-container w3-center">
 	<%
			Service instance = Service.getInstance();
			request.setAttribute("menuAll", instance.getAllMenu());
	%>
	<table border="1">
	<thead>
		<tr>
			<th>메뉴명</th><th>표시재료</th><th>부연설명</th><th>가격</th><th>카테고리</th><th>삭제하기</th>
		</tr>
	</thead>
	<c:forEach items="${requestScope.menuAll}" var="data">
		<tr>
			
			<th><button onclick='menumove("${data.name}","${data.config}","${data.status}","${data.price}","${data.category}")'>
				${data.name}</button>
			</th>
			<th>${data.config}</th>
			<th>${data.status}</th>
			<th>${data.price}</th>
			<th>${data.category}</th>
			<th><a href="Controller?command=menuDelete&menu=${data.name}">삭제하기</a></th>
		</tr>
	</c:forEach>
	</table>
	<br>
	
	<table>
	<tr>
	<td>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="menuInsert">
		<table border="1" style="height: 200px">
			<tr>
				<td>메뉴명</td><td><input type="text" name="name"></td>
			</tr>
			<tr>
	 			<td>표시재료</td><td><input type="text" name="config"></td>
			</tr>
			<tr>	
				<td>부연설명</td><td><input type="text" name="status"></td>
		 	</tr>
		 	<tr>
	 			<td>가격</td><td><input type="text" name="price"></td>
	 		</tr>
	 		<tr>
	 			<td>카테고리</td><td><input type="text" name="category"></td>
	 		</tr>
	 		<tr>
	 			<td colspan="2"><input type="submit" value="등록">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소"></td>
	 		</tr>
		</table>
	</form>
	</td>
	<td>&nbsp;&nbsp;&nbsp;</td>
	<td>
	<div id = "12"></div>
	</td>
	</tr>
	</table>
	<br>
	<a href="${pageContext.request.contextPath}/guestList.jsp">뒤로가기</a>
</div>
</div>

<script>
function menumove(name, config , status, price, category) {
	let url = "Controller?command=menuManage&menu="+name+"&config="+config+"&status="+status+"&price="+price+"&category="+category;
	//let test =v
	console.log(url);
	axios.get("menuupdate.jsp",{
		params :{
			"name" : name,
			"config" : config,
			"status" : status,
			"price" : price,
			"category" : category
		}
	}).then(function (r12){
		console.log(r12.data)
		document.getElementById("12").innerHTML = r12.data;
	}).catch(function(){
	console.log("예외 발생");
	})
}
</script>
</body>
</html>
