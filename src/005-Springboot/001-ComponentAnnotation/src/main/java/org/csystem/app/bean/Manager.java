package org.csystem.app.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Manager extends Employee{
    @Override
    @PostConstruct
    public void calculate()
    {
        System.out.println("Manager.calculate");
    }
}
