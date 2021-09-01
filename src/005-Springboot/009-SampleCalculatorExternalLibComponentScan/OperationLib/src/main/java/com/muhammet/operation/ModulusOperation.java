package com.muhammet.operation;

import org.springframework.stereotype.Component;

@Component
public class ModulusOperation implements IOperation<Integer> {
    @Override
    public Integer apply(Integer t1, Integer t2)
    {
        return t1 % t2;
    }

    @Override
    public boolean isValid(char op)
    {
        return op == '%';
    }
}
