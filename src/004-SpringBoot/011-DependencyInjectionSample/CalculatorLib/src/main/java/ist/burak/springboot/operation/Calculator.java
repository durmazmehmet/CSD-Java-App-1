package ist.burak.springboot.operation;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Calculator {
    private final Collection<IOperation> m_operations;

    public Calculator(Collection<IOperation> operations)
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
