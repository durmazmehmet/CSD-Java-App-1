package org.csystem.springboot.app;

import org.csystem.springboot.app.calculator.SimpleCalculator;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}

	@Bean
	public ApplicationRunner runOperations1(SimpleCalculator calculator)
	{
		System.out.println("runOperations1");

		return args -> {
			System.out.println(calculator.calculate(30, 50, '+'));
		};
	}
	@Bean
	public ApplicationRunner runOperations2(SimpleCalculator calculator)
	{
		System.out.println("runOperations2");

		return args -> {
			System.out.printf("result=%d%n", calculator.calculate(10, 20, '+'));
			System.out.printf("result=%d%n", calculator.calculate(10, 20, '-'));
			System.out.printf("result=%d%n", calculator.calculate(10, 20, '*'));
			System.out.printf("result=%d%n", calculator.calculate(10, 20, '%'));
		};
	}
}
