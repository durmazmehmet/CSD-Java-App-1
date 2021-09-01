package org.csystem.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"ist.burak.springboot.operation", "org.csystem"})
@SpringBootApplication
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}
}
