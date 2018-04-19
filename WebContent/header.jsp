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
	
	<h1 style="color: BROWN; text-align: center; font-family: cursive;">
		СОФИЯ ХЛЯБ</h1>
	<h3 style="color: brown; text-align: center; font-family: cursive;">
		ЗАМРАЗЕНИ ТЕСТЕНИ ИЗДЕЛИЯ</h3>
		

  <h1>
		${sessionScope.user.username} </h1>
		 <c:if test="${sessionScope.name != null }">
			<jsp:include page="logout.jsp"></jsp:include>
				</c:if>
	
		<form class="navi" action="aboutUs.jsp"> 
			<input type="submit" value="ЗА НАС">
		</form>
		<form class="navi" action="main.jsp"> 
			<input type="submit" value="ПРОДУКТИ">
		</form>
		<form class="navi" action="shipping.jsp"> 
			<input type="submit" value="ДОСТАВКА">
		</form>
		<form class="navi" action="contacts.jsp"> 
			<input type="submit" value="КОНТАКТИ">
		</form>
	</body>
</html>