package org.csystem.deviceapp.test.repository;

import org.csystem.deviceapp.entity.DeviceInfo;
import org.csystem.deviceapp.repository.DeviceRepository;
import org.csystem.repository.RepositoryException;

import java.util.Scanner;

public class SaveTestApp {
	public static void displayDevices(Iterable<? extends DeviceInfo> devices)
	{
		System.out.println("All Devices:");
		for (DeviceInfo di : devices)
			System.out.println(di);		
	}
	
	public static void main(String [] args)
	{		
		try (Scanner kb = new Scanner(System.in)) {
			for (;;) {
				DeviceRepository repo = DeviceRepository.INSTANCE;
				
				displayDevices(repo.findAll());
				
				System.out.print("Device Name:");
				String name = kb.nextLine();
				
				if (name.equals("quit"))
					break;
				
				System.out.print("IP Address:");
				String ipAddress = kb.nextLine();
				
				System.out.print("Ports(with comma):");
				String portInfo = kb.nextLine();
				
				String [] portsStr = portInfo.split("[ ,]+");
				
				int [] ports = new int[portsStr.length];
				
				for (int i = 0; i < ports.length; ++i)
					ports[i] = Integer.parseInt(portsStr[i]);
				
				DeviceInfo di = new DeviceInfo(name, ipAddress);
				
				repo.save(di, ports);
				
				System.out.printf("Device Information:%s%n", di);
				
				for (int i = 0; i < di.getNumberOfPorts(); ++i)
					System.out.printf("\t-%d%n", di.getPortByIndex(i));
			}			
			
		}
		catch (RepositoryException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
