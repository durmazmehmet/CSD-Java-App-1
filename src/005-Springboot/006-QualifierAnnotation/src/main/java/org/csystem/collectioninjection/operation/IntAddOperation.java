package org.csystem.collectioninjection.operation;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class IntAddOperation implements IOperation {
    //...
    @Override
    public int apply(int t1, int t2)
    {
        System.out.println("IntAddOperation");
        return  t1 + t2;
    }

    @Override
    public boolean isValid(char op)
    {
        return op == '+';
    }
}
