<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C ve Sistem Programcıları Derneği</title>
</head>
<body>
	<h2>JSP Uygulaması</h2>
	
	<%
		String msg = "JSP";
	
		out.println(String.format("<h3>Merhaba %s</h3>", msg));
	%>
	
	<%
		LocalDateTime now = LocalDateTime.now();
		
		out.println(String.format("%02d/%02d/%04d %02d:%02d:%02d", 
				now.getDayOfMonth(), now.getMonthValue(), now.getYear(), now.getHour(), now.getMinute(), now.getSecond()));	
	%>
	
		
	
</body>
</html>