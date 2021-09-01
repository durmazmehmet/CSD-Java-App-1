package org.csystem.springboot.app.operation;

import org.springframework.stereotype.Component;

@Component
public class Modulus implements IOperation {
    @Override
    public int doOperation(int a, int b)
    {
        return a % b;
    }

    @Override
    public boolean isValid(char op)
    {
        return op == '%';
    }
}
