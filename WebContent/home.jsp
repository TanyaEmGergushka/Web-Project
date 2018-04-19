<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SofyaBreadHome</title>
	</head>
	<body>
	<c:import url="products"></c:import>
	
		<jsp:include page="header.jsp"></jsp:include>
		<p style="text-align: right;">
	 <jsp:include page="login.jsp"></jsp:include>
		</p>
		
		
		<p style="position: relative;">
			<marquee>
				<img src="frozen.jpg" alt="AmAm" width="500" height="377"
					align="bottom">
			</marquee>
		</p>
	

	<h5 style="color: red; position: relative; font: italic;">
		<marquee> TASTE IT !</marquee>
	</h5>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>