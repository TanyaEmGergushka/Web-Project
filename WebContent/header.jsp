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
	
	<body bgcolor="linen">
				
				<div class="row">
 					 <div class="column" >
						<img src="logo.jpg"  width="370" height="120"	 style="border-style:dashed; border-radius: 40px;" alt="logo">  
			 		 </div>
			 		
				 	 <div class="column" align="center" style="padding-top:40px;">	
				 			<i class="float"  style="font-size:28px;"> <a  style="color: #CD5C5C;" href ="contacts.jsp"> <img   id="home" src="19-512.png" >  0892 700 032 </a> </i> 
							<i class="float"  style="font-size:28px;"> <a  style="color: #CD5C5C;" href ="shipping.jsp"> <img  id="home" src="Wall_Clock-512.png" > 8 - 20 ч </a> </i>  <br><br>
					</div>	
					
					<div class="column" align="right" style="padding-top: 20px;" >	
						<form   action="search">
						    <input type="search" name="search" placeholder=Търсене... onfocus="this.value=''" style="border-color: gray;">
							<i> <button style="background-color: white;border-style:solid; border-color: gray; border-radius: 5px; display: inline-block;" type="submit">
									<img id="next" src="search_icon.png"></button> </i>
						</form>  
						<br>	
						<p class="float">	
							<c:if test="${sessionScope.user.username == null }">
									<i style="font-size:22px;"> <a href="login.jsp"> Вход </a>  </i> 
									<i style="font-size:22px;"> / </i>
									<i style="font-size:22px;"> <a href="register.jsp"> Регистрация </a> </i> 
							</c:if> 	
						</p>
					</div>
  		  		</div>
			
				<c:if test="${sessionScope.user.username != null }">
						<img class="navi" id = "avatar" src="avatar">
				</c:if> 
				
				<div class="logout">
				 	<h3 class="float"> ${sessionScope.user.username} 
						 <c:if test="${sessionScope.user.username != null }">
							<jsp:include page="logout.jsp"></jsp:include>
						 </c:if> 	
					</h3>
            	</div>		
            	
				<h4 class="top" style="color: brown; position: relative; font-family: cursive;">
					<marquee> ЗАМРАЗЕНИ ТЕСТЕНИ ИЗДЕЛИЯ</marquee>
				</h4> 
			<br><br>
	
		
		<div class="navmenu">
			<a class= "navi" href="aboutUs.jsp"> ЗА НАС </a>
			<a href ="main.jsp"> ПРОДУКТИ</a>
			<a href ="shipping.jsp">ДОСТАВКА</a>
			<a href ="myProducts.jsp">ЛЮБИМИ</a>
			<a href ="contacts.jsp">КОНТАКТИ</a>
		</div>
		
				 <!-- old navigation menu
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
				-->
		
	</body>
</html>