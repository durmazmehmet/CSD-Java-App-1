package org.csystem.springboot.app;

import org.csystem.springboot.app.operation.IOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
public class App {
	public static void main(String[] args)
	{
		var context = SpringApplication.run(App.class, args);

		SimpleCalculator calculator = context.getBean(SimpleCalculator.class);

		System.out.println(calculator.calculate(10, 20, '+'));
		System.out.println(calculator.calculate(10, 20, '*'));
		System.out.println(calculator.calculate(10, 20, '-'));
		System.out.println(calculator.calculate(10, 20, '%'));
	}

	@Bean
	public SimpleCalculator prepareCalculator(Collection<IOperation> operations)
	{
		return new SimpleCalculator(operations);
	}
}
