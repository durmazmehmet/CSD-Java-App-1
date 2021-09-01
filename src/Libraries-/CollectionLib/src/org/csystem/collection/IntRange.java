package org.csystem.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public class IntRange implements Iterable<Integer> {
    private int m_min, m_max;
    private IntUnaryOperator m_unaryOperator;

    public IntRange(int min, int max, IntUnaryOperator unaryOperator)
    {
        if (min > max)
            throw new IllegalArgumentException("min must be less or equal than max");

        m_min = min;
        m_max = max;
        m_unaryOperator = unaryOperator;
    }

    public IntRange(int min, int max)
    {
        this(min, max, 1);
    }

    public IntRange(int min, int max, int inc)
    {
        m_min = min;
        m_max = max;
        m_unaryOperator = (inc <= 0) ? (val -> val + 1) : (val -> val +  inc);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>() {
            private int m_curElem = m_min;

            @Override
            public boolean hasNext()
            {
                return m_curElem <= m_max;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No element");

                int result = m_curElem;

                m_curElem = m_unaryOperator.applyAsInt(m_curElem);

                return result;
            }
        };
    }
}
