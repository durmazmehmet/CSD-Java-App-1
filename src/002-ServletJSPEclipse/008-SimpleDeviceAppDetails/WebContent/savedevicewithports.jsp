<%@page import="org.csystem.deviceapp.jsp.DeviceAppJSP"%>
<%@page import="org.csystem.deviceapp.entity.DeviceInfo"%>
<%@page import="org.csystem.deviceapp.repository.DeviceRepository"%>
<%@page import="org.csystem.deviceapp.service.DeviceService"%>
<%@page import="org.csystem.servicelayer.ServiceException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Device Save Information</title>
</head>
<body>
	<%
		DeviceAppJSP.doWorkForSaveWithPorts(request, out);
	%>	
	<%
		if (request.getMethod().equals("POST")) {			
	%>
	<h3>All Devices</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Ip Adress</th>
		</tr>	
		<%
			DeviceService service = new DeviceService(DeviceRepository.INSTANCE);
		
			DeviceAppJSP.printDevicesWithPorts(out, service.findAll(3));
		%>	
	</table>
	<%
		}
		else 
			out.println("Access forbidden");
	%>
</body>
</html>