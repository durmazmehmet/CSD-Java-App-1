package org.csystem.springboot.app.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Sample {
    private int m_val;

    public Sample()
    {
        System.out.println("Sample.Sample()");
    }

    public Sample(int val)
    {
        m_val = val;
        System.out.println("Sample.Sample(int)");
    }

    public void display()
    {
        System.out.printf("m_val:%d%n", m_val);
        System.out.println("Sample.foo");
    }
}
