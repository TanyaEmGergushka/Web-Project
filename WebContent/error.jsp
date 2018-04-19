<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ErrorPage</title>
</head>
<body>
<h1>Error page</h1>
  <c:catch var ="catchException">
<% out.print(request.getSession().getAttribute("name")); %>
         <% request.getSession().getAttribute("user");%>
      </c:catch>

      <c:if test = "${catchException == null}">
         <p>The exception is : ${catchException} <br />
         There is an exception: ${catchException.message}</p>
           </c:if>
</body>
</html>