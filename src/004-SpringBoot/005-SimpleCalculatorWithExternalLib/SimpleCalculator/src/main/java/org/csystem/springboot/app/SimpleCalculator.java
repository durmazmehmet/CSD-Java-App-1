package org.csystem.springboot.app;

import org.csystem.springboot.app.operation.IOperation;

import java.util.Collection;

public class SimpleCalculator {
    private final Collection<IOperation> m_operations;

    public SimpleCalculator(Collection<IOperation> operations)
    {
        m_operations = operations;
    }

    public int calculate(int a, int b, char op)
    {
        for (var iop : m_operations) {
            if (iop.isValid(op))
                return iop.doOperation(a, b);
        }

        throw new UnsupportedOperationException("Invalid operation:" + op);
    }
}
