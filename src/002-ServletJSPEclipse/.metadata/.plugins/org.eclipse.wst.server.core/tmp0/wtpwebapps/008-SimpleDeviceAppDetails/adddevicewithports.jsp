<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Device Information</title>
</head>
<body>	
	<form action="savedevicewithports.jsp" method="post">
		<div><input type="text" name="name" placeholder="Device Name"/></div>
		<div><input type="text" name="ip_address" placeholder="Ip Address"/></div>
		<div><input type="text" name="ports" placeholder="Port(aralarına virgül koyunuz)"/></div>
		<div><input type="submit" value="Save"/><input type="reset" value="Clear"/></div>
	</form>
</body>
</html>