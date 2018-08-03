
<%@page import="java.util.HashSet"%>

<%@page import="model.db.DBManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Products</title>
	</head>
	<body >
		<jsp:include page="header.jsp"></jsp:include>
		<c:import url="products"></c:import>
		
		<h3 style="color: brown; text-align: left; font-family: cursive;">
			ПРОДУКТИ
		</h3>
		
		<table border="1">
		<tr> 
			<th> Id </th>
			<th> Name </th>
			<th> Description </th>
			<th> Price </th>
			<th> Quantity </th>
		</tr>
	
		<!-- scriplets -->
		<!--	<%// for (Product p : products) { %> -->
			<!--	<tr>-->
			<!--	    <td> <%//= p.getId() %> </td>-->
			<!--		<td> <%//= p.getName() %> </td>-->
			<!--		<td> <%//= p.getDescription() %> </td>-->
		<!--		<td> <% // out.print(p.getPrice()); %> лв </td> -->
		<!--		<td> <% // out.print(p.getQuantity()); %> бр </td>-->
			<!--	 </tr>-->
		<% // }	%>
		
		
		
		<!-- // jstl  -->
		<c:forEach  items="${applicationScope.products}" var="product"> 
		<tr>
				 <td> <c:out value="${product.id}"></c:out> </td> 
				<td>  <c:out value="${product.name}"></c:out></td>
				<td>  <c:out value="${product.description}"></c:out> </td>
				<td>  <c:out value="${product.price} лв "></c:out> </td>
				<td>  <c:out value="${product.quantity}  бр"> Not available</c:out> </td>
			 </tr>
		</c:forEach>
	
		</table>
	
		<jsp:include page="footer.jsp"></jsp:include>
		
	</body>
</html>