package org.csystem.deviceapp.test.repository;

import java.util.Scanner;

import org.csystem.deviceapp.entity.DeviceInfo;
import org.csystem.deviceapp.repository.DeviceRepository;
import org.csystem.repository.RepositoryException;

public class FindPortsByNameContainsApp {
	public static void displayDevices(Iterable<DeviceInfo> devices)
	{
		for (DeviceInfo di : devices) {
			System.out.printf("Device Information:%s%n", di);
			for (int i = 0; i < di.getNumberOfPorts(); ++i)
				System.out.printf("\t-%d%n", di.getPortByIndex(i));
		}
	}
	
	public static void main(String [] args)
	{
		try (Scanner kb = new Scanner(System.in)) {
			for (;;) {
				DeviceRepository repo = DeviceRepository.INSTANCE;		
				
				System.out.print("Name:");
				String name = kb.nextLine();
				
				if (name.equals("quit"))
					break;				
				
				displayDevices(repo.findPortsByNameContains(name));
			}		
			
		}
		catch (RepositoryException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
