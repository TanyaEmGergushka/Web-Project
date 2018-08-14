<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Logout</title>
		<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<body>
		<c:if test="${ sessionScope.user.username != null }">
			 <form  class="navi" action="logout" method="post">
					<input  type="submit" value="Изход" style="color: #CD5C5C; border-color: gray; height: 30px; width: 80px; font-size: 14px;"/>
			</form>
		</c:if>
	</body>
</html>