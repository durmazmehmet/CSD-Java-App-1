package org.csystem.app.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype") //Her istendiğinde yeni nesne yaratarak ver (default değer singleton)
public class Device {
    private Device()
    {
        System.out.println("Device.Device");
    }
}
