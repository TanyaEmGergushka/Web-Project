<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<title>Register</title>
		<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	
		<body> 
			<jsp:include page="header.jsp"></jsp:include>
		
			<c:if test="${requestScope.error == null }">
			<h3> Please register an account! </h3>
			</c:if>
				
			<c:if test="${requestScope.error != null }">
			<h3> Sorry, registration unsuccessfull.   </h3>
			</c:if>
		
			<form class="content" action="register" method="post" >
				Username<input type="text" name="username" > <br>
				Password<input type="text" name="password"> <br> 
				Confirm password <input type="text" name="password2"> <br>
				Email<input	type="email" name="email"> <br> 
				Company<input type="text" name="company"> <br>
				 <input type="submit" value="Register">
			</form>
			
			<p style="background-color: activecaption; width: 300px;">
			Already have an account? Please login <a href="login.jsp"> here!</a> <br> </p>
			<jsp:include page="footer.jsp"></jsp:include>
		</body>
</html>