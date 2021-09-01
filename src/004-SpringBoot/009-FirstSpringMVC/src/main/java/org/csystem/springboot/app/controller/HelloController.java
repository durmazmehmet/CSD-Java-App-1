package org.csystem.springboot.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping
    public String displayHelloMessage1()
    {
        return "Hello Spring Boot Web";
    }

    @RequestMapping(value = "/hello1", method =  RequestMethod.GET)
    public String displayHelloMessage2()
    {
        return "Hello1 Spring Boot Web";
    }

    @GetMapping("/hello2")
    public String displayHelloMessage3()
    {
        return "Hello2 Spring Boot Web";
    }
}
