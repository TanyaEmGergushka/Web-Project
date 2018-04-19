<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Contacts</title>
	</head>
	<body>
	
		<jsp:include page="header.jsp"></jsp:include>
		
		
		<c:if test="${sessionScope.name == null }">
		<jsp:include page="login.jsp"></jsp:include>
		<p style="text-align: right;">
	Don't have an account yet? Please register <a href="register.jsp"> here!</a> </p> <br>
		</c:if>
	 		
		<h3> моб.тел: +359 892 700032 </h3>
		<h3> адрес: Божурище </h3>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>