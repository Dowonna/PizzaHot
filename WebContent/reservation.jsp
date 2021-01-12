<%@page import="model.Service"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#left_banner {
	border: 1px solid black;
	position: fixed;
	width: 200px;
	height: 400px;
	top: 300px;
	right: 0%;
	background-color: white;
}
</style>
</head>
<body class="w3-light-grey">

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 100px; margin-top: 43px;">
	
		<%
			Service instance = Service.getInstance();
			request.setAttribute("menuAll", instance.getAllMenu());
		%>
		<div id='left_banner'>
			<table id="basket" style="font-size: 13px; border-collapse: collapse;" border="1">
				<tr>
					<th width="110px">Menu</th>
					<th>number</th>
					<th>price</th>
				</tr>
			</table>

			<p id="cost" style="position: absolute; bottom: 20px;">Total cost : </p>
			
			<form action='Controller' name="bk" method="post">
				<input type="hidden"  id="basketValue" name="basket">
				<input type="hidden" name="command" value="addReservation">
				<button onclick="toRes()" style="position: absolute; bottom: 10px; right: 5px">예약하기</button>
			</form>
			
		</div>


		<div class="w3-content">
			<h1 class="w3-center w3-jumbo" style="margin-bottom: 64px">THE
				MENU</h1>
			<div class="w3-row w3-center w3-border w3-border-dark-grey">
				<a href="javascript:void(0)" onclick="openMenu(event, 'Pizza');" id="myLink">
					<div class="w3-col s4 tablink w3-padding-large w3-hover-red">Pizza</div>
				</a> <a href="javascript:void(0)" onclick="openMenu(event, 'Pasta');">
					<div class="w3-col s4 tablink w3-padding-large w3-hover-red">Pasta</div>
				</a> <a href="javascript:void(0)" onclick="openMenu(event, 'Starter');">
					<div class="w3-col s4 tablink w3-padding-large w3-hover-red">Starter</div>
				</a>
			</div>

			<div id="Pizza" class="w3-container menu w3-padding-32 w3-white">
				<c:forEach items="${requestScope.menuAll}" var="data">
					<c:if test="${data.category=='pizza'}">
						<h1>
							<b><a onclick='addBasket("${data.name}",${data.price})'>${data.name}</a></b>
							<c:if test="${data.status!='none'}">
								<span class="w3-tag w3-red w3-round">${data.status}</span>
							</c:if>
							<span class="w3-right w3-tag w3-dark-grey w3-round">$
								${data.price}</span>
						</h1>
						<p class="w3-text-grey">${data.config}</p>
						<hr>
					</c:if>
				</c:forEach>
			</div>

			<div id="Pasta" class="w3-container menu w3-padding-32 w3-white">
				<c:forEach items="${requestScope.menuAll}" var="data">
					<c:if test="${data.category=='pasta'}">
						<h1>
							<b><a onclick='addBasket("${data.name}",${data.price})'>${data.name}</a></b>
							<c:if test="${data.status!='none'}">
								<span class="w3-tag w3-red w3-round">${data.status}</span>
							</c:if>
							<span class="w3-right w3-tag w3-dark-grey w3-round">$
								${data.price}</span>
						</h1>
						<p class="w3-text-grey">${data.config}</p>
						<hr>
					</c:if>
				</c:forEach>
			</div>


			<div id="Starter" class="w3-container menu w3-padding-32 w3-white">
				<c:forEach items="${requestScope.menuAll}" var="data">
					<c:if test="${data.category=='starter'}">
						<h1>
							<b><a onclick='addBasket("${data.name}",${data.price})'>${data.name}</a></b>
							<c:if test="${data.status!='none'}">
								<span class="w3-tag w3-red w3-round">${data.status}</span>
							</c:if>
							<span class="w3-right w3-tag w3-dark-grey w3-round">$
								${data.price}</span>
						</h1>
						<p class="w3-text-grey">${data.config}</p>
						<hr>
					</c:if>
				</c:forEach>
			</div>
			<br>

		</div>
	</div>
	
</body>
</html>
