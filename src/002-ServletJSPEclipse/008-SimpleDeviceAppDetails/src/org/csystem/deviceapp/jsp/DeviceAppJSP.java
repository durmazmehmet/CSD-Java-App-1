package org.csystem.deviceapp.jsp;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.csystem.deviceapp.entity.DeviceInfo;
import org.csystem.deviceapp.repository.DeviceRepository;
import org.csystem.deviceapp.service.DeviceService;
import org.csystem.servicelayer.ServiceException;

public class DeviceAppJSP {	
	private static void printDeviceDetails(DeviceInfo di, JspWriter out) throws IOException
	{
		out.println("<h3>Device Information</h3>");			
		out.println(String.format("<h4>Id:%s</h4>", di.getId()));
		out.println(String.format("<h4>Name:%s</h4>", di.getName()));
		out.println(String.format("<h4>IpAddress:%s</h4>", di.getIpAddress()));
	}
	
	private static int [] convertStringArrayToIntArray(String [] s) // Bu işlem Stream API ile daha kolay yapılabilir
	{
		int [] ints = new int[s.length];
		
		for (int i = 0; i < s.length; ++i)
			ints[i] = Integer.parseInt(s[i]);
		
		return ints;
	}
	
	private DeviceAppJSP() {}
	
	
	public static void printDevicesWithPorts(JspWriter out, Iterable<? extends DeviceInfo> devices) throws IOException
	{
		try {			
			for (DeviceInfo di : devices) {
				out.println(String.format("<li>%s", di));
				
				out.println("<ul>");
				for (int i = 0; i < di.getNumberOfPorts(); ++i) 
					out.println(String.format("<li>%d</li>", di.getPortByIndex(i)));					
				out.println("</ul>");
				
				out.println("</li>");
			}			
		}
		catch (ServiceException ex) {
			out.println("Error in page:" + ex.getMessage());
		}				
	}
	
	
	public static void printDevicesAsTable(JspWriter out, Iterable<? extends DeviceInfo> devices) throws IOException
	{
		try {			
			for (DeviceInfo di : devices) {
				out.println("<tr>");
				out.println(String.format("<td>%d</td>", di.getId()));				
				out.println(String.format("<td>%s</td>", di.getName()));
				out.println(String.format("<td>%s</td>", di.getIpAddress()));
				out.println("</tr>");
			}			
		}
		catch (ServiceException ex) {
			out.println("Error in page:" + ex.getMessage());
		}				
	}
	
	public static void doWorkForSave(HttpServletRequest request, JspWriter out) throws IOException
	{
		try {
			if (request.getMethod().equals("POST")) {
				String name = request.getParameter("name");
				String ipAddress = request.getParameter("ip_address");
				
				//validation
				DeviceService service = new DeviceService(DeviceRepository.INSTANCE);				 
				DeviceInfo di = new DeviceInfo(name.trim(), ipAddress.trim());				
				
				service.save(di);
				printDeviceDetails(di, out);
			}
			else 
				out.println("Access forbidden");
		}
		catch (ServiceException ex) {
			out.println("Error in page:" + ex.getMessage());
		}		
	}
	
	public static void doWorkForSaveWithPorts(HttpServletRequest request, JspWriter out) throws IOException
	{
		try {
			if (request.getMethod().equals("POST")) {
				String name = request.getParameter("name");
				String ipAddress = request.getParameter("ip_address");
				String portsData = request.getParameter("ports");
				
				//validation
				DeviceService service = new DeviceService(DeviceRepository.INSTANCE);				 
				DeviceInfo di = new DeviceInfo(name.trim(), ipAddress.trim());				
				
				int [] ports = convertStringArrayToIntArray(portsData.split("[, ]+"));
				
				service.save(di, ports);				
			}
			else 
				out.println("Access forbidden");
		}
		catch (ServiceException ex) {
			out.println("Error in page:" + ex.getMessage());
		}		
	}
}
