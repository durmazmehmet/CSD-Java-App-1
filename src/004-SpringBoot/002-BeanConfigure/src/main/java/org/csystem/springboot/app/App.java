package org.csystem.springboot.app;

import org.csystem.springboot.app.bean.Sample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class App {
    public static void main(String[] args)
    {
        var context = SpringApplication.run(App.class, args);
        Sample s = context.getBean(Sample.class, 4);

        s.display();


        Sample k = context.getBean(Sample.class, 10);

        k.display();

        System.out.println(s == k);

    }
}
