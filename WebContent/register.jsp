<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<form action="register" method="post">
		Username<input type="text" name="username"> <br>
		Password<input type="text" name="password"> <br> 
		Email<input	type="email" name="email"> <br> 
		Company<input type="text" name="company"> <br>
		 <input type="submit" value="register">

	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>