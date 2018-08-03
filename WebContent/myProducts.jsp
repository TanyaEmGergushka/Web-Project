<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>MyProducts</title>
		</head>
		<body>
			<jsp:include page="header.jsp"></jsp:include>
			
			<c:if test="${sessionScope.user != null }">
			
				<h2> Вашите любими продукти са: </h2>
				
				<c:forEach items= "${sessionScope.user.orders}" var="order"> 
					<h4>  ${order.datetime} </h4>
					<table border="1">
				<c:forEach items="${order.basket}" var="productEntry"> 
					<tr>
					<td> <a href="main.jsp">${productEntry}</a>  </td>
						</tr>
					</c:forEach>
				</table>
				<hr>
				</c:forEach>
			</c:if>
		
			<jsp:include page="footer.jsp"></jsp:include>
		</body>
</html>

