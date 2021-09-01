package org.csystem.application.samplecalculator.operation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MultiplyOperation implements IOperation<Integer> {
    @Value("${multiply.extra}")
    private int m_extra;

    @Override
    public Integer apply(Integer t1, Integer t2)
    {
        return t1 * t2 + m_extra;
    }

    @Override
    public boolean isValid(char op)
    {
        return op == '*';
    }
}
