<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome</title>
	</head>
	<body style="background-color: YELLOW;"
	>
		
		<c:import url="products"></c:import>
		
		<div >
				<h1 class= "top" style="color: BROWN;  font-family: cursive;">
					СОФИЯ ХЛЯБ
				</h1>  
				<br>
				
				<img class="navi" id = "avatar" src="avatar">
				
					
				<div class="logout">
				 	<h3> ${sessionScope.user.username} 
						 <c:if test="${sessionScope.user.username != null }">
							<jsp:include page="logout.jsp"></jsp:include>
						 </c:if> 	
					</h3>
            	</div>		
            	
				<h4 class="top" style="color: brown; position: relative; font-family: cursive;">
					<marquee> ЗАМРАЗЕНИ ТЕСТЕНИ ИЗДЕЛИЯ</marquee>
				</h4> 
		</div>
		
		<div class="welcomemenu">
			<a class= "navi" href="aboutUs.jsp"> ЗА НАС </a>
			<a href ="main.jsp"> ПРОДУКТИ</a>
			<a href ="shipping.jsp">ДОСТАВКА</a>
			<a href ="myProducts.jsp">ЛЮБИМИ</a>
			<a href ="contacts.jsp">КОНТАКТИ</a>
		</div>
		
				<img src="frozen.jpg" alt="AmAm" width="400" height="277"
					align="right" >
					
		<div >
			<c:if test="${sessionScope.user == null }">
					<p style="text-align: right;">
					<jsp:include page="login.jsp"></jsp:include>
					</p>
			</c:if>
		</div>
		
		 		
		
	</body>
</html>