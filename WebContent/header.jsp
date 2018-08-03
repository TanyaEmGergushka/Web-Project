<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	
	<body  style="background-color: YELLOW;">
	
		<div class="top">
			<h1 style="color: BROWN;  font-family: cursive;">
				СОФИЯ ХЛЯБ</h1> 
			<h3 style="color: brown;  font-family: cursive;">
				ЗАМРАЗЕНИ ТЕСТЕНИ ИЗДЕЛИЯ</h3> 
		</div>
		
			
		<div class="logout">
		 	 <h3 class="navi"> ${sessionScope.user.username} 
			 <c:if test="${sessionScope.user.username != null }">
				<jsp:include page="logout.jsp"></jsp:include>
			 </c:if> 	</h3>
		</div>

		<div class= "header">
			<form class="navi"  action="aboutUs.jsp"> 
				<input type="submit" value="ЗА НАС">
			</form>
			<form class="navi" action="main.jsp"> 
				<input type="submit" value="ПРОДУКТИ">
			</form>
			<form class="navi" action="shipping.jsp"> 
				<input type="submit" value="ДОСТАВКА">
			</form>
			<form class="navi" action="myProducts.jsp"> 
				<input type="submit" value="ЛЮБИМИ">
			</form>
			<form class="navi" action="contacts.jsp"> 
				<input type="submit" value="КОНТАКТИ">
			</form>
		</div>
		
		<c:if test="${sessionScope.user == null }">
				<p style="text-align: right;">
				<jsp:include page="login.jsp"></jsp:include>
				</p>
			</c:if>
	</body>
</html>