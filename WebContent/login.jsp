<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	
	<body>
		<div class="login">
			 <c:if test="${sessionScope.user.username == null }">
	 
				<c:if test="${ requestScope.error == null }">
					<h3 style="text-align: right;"> Please login </h3>
				</c:if>
			
				<c:if test="${ requestScope.error != null }">
					<h3 style="color: silver;"> Sorry, username or password missmatch. Reason: ${requestScope.error}. Try again!</h3>
				</c:if>
			
				<form action="login" method="post">
						<p style="text-align: right;">
							Username <input type="text" name="user" ><br>
							<!-- Email <input type="email" name="email" ><br> -->
							Password <input type="password" name="password" ><br>
							<input type="submit" value="LOGIN">
						</p>
				</form>
					
					<p style="text-align: right; background-color: activecaption; width: 330px;" >
					Don't have an account yet? Please register <a href="register.jsp"> here!</a> <br>
					</p>
			</c:if>			
		 </div>
	</body>
</html>