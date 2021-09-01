package org.csystem.app.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Worker extends Employee{
    @Override
    @PostConstruct

    public void calculate()
    {
        System.out.println("Worker.calculate");
    }
}
