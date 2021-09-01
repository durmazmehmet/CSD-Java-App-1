<%@page import="org.csystem.deviceapp.jsp.DeviceAppJSP"%>
<%@page import="org.csystem.deviceapp.entity.DeviceInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.csystem.deviceapp.repository.DeviceRepository"%>
<%@page import="org.csystem.deviceapp.service.DeviceService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Ports</title>
</head>
<body>
	<form method="post">
		<div><input type="text" name="name"/></div>
		<div><input type="submit" value="Find"/></div>
	</form>
	
	<%
		if (request.getMethod().equals("POST")) {
			String name = request.getParameter("name");
			//validation
			DeviceService service = new DeviceService(DeviceRepository.INSTANCE);			
			Iterable<DeviceInfo> devices = service.findPortsByNameContains(name.trim());			
	%>
	<h3>Devices:</h3>
	<ul>
		<%
			DeviceAppJSP.printDevicesWithPorts(out, devices);			
		%>	
	</ul>
	<%
		}
	%>
</body>
</html>