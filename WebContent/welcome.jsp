<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome</title>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		
		<c:import url="products"></c:import>
		
		 <h1> Welcome, ${sessionScope.user.username} !		 </h1>
		 		 
		<jsp:include page="logout.jsp"></jsp:include>
	</body>
</html>