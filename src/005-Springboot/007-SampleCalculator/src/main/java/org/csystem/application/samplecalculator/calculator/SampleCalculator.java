package org.csystem.application.samplecalculator.calculator;

import org.csystem.application.samplecalculator.operation.IOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Scope("prototype")
public class SampleCalculator {
    private final Collection<IOperation<Integer>> m_operations;

    private void throwException()
    {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    public SampleCalculator(Collection<IOperation<Integer>> operations)
    {
        m_operations = operations;
    }

    public void calculate(int a, int b, char op)
    {
        m_operations.stream()
                .filter(iop -> iop.isValid(op))
                .findFirst()
                .ifPresentOrElse(iop -> System.out.printf("%d %c %d = %d%n", a, op, b, iop.apply(a, b)), this::throwException);
    }
}
