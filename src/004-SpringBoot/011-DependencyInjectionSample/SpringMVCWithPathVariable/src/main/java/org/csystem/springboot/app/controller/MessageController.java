package org.csystem.springboot.app.controller;

import ist.burak.springboot.operation.Calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final Calculator m_calculator;

    public MessageController(Calculator calculator) //dependency injection
    {
        m_calculator = calculator;
    }

    @GetMapping("/operation/{a}/{b}/{op}")
    public String doOperation(@PathVariable("a") int a, @PathVariable("b")int b, @PathVariable("op")char op)
    {
        return String.format("%d %c %d = %d", a, op, b, m_calculator.calculate(a, b, op));
    }
}
