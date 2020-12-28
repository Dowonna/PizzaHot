<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.dto.GuestDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	session.setAttribute("Name", request.getParameter("Name"));
	session.setAttribute("People", request.getParameter("People"));
	session.setAttribute("date", request.getParameter("date"));
	session.setAttribute("Phone", request.getParameter("Message"));
	GuestDTO guest = new GuestDTO();
	guest.setName(request.getParameter("Name"));
	guest.setNumber(request.getParameter("People"));
	guest.setDate(request.getParameter("date"));
	guest.setPhone(request.getParameter("Message"));
	request.setAttribute("guest", guest);
	%>
	두 개의 버튼을 전부 눌러주세요
	<form action="http://127.0.0.1:1880/hello">
			    	<input type="hidden" name="Name" value=${sessionScope.Name}>
			    	<input type="hidden" name="People" value=${sessionScope.People}>			    
			    	<input type="hidden" name="date" value=${sessionScope.date}>			    
			    	<input type="hidden" name="Message" value=${sessionScope.Phone}>			    
			    	<input type="submit" value="Confirm">
	</form>
	<form action="Controller">
			    	<input type="hidden" name="Name" value=${sessionScope.Name}>
			    	<input type="hidden" name="People" value=${sessionScope.People}>			    
			    	<input type="hidden" name="date" value=${sessionScope.date}>			    
			    	<input type="hidden" name="Message" value=${sessionScope.Phone}>			    
			    	<input type="hidden" name="command" value="addGuest">			    
			    	<input type="submit" value="뒤로가기">
	</form>
</body>
</html>