package org.csystem.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class App {

	public static void main(String[] args)
	{
		var context = SpringApplication.run(App.class, args);

		DeviceInfo di = context.getBean(DeviceInfo.class);

		di.setName("test");
		di.setProductDate(LocalDate.now());

		System.out.println(di);

		di = new DeviceInfo("mest", LocalDate.now());

		System.out.println(di);

		var a = 10;

		System.out.printf("a=%d%n", a);
	}
}
