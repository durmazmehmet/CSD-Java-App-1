package org.csystem.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class App {
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
        System.out.println("Merhaba Spring Boot");
    }
}
