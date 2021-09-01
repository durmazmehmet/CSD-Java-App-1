package org.csystem.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleRange implements Iterable<Double> {
    private double m_min, m_max, m_inc;

    public DoubleRange(double min, double max, double inc)
    {
        if (min > max)
            throw new IllegalArgumentException("min must be less or equal than max");

        m_min = min;
        m_max = max;

        m_inc = inc <= 0 ? 1. : inc;
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            private int m_index = -1;

            @Override
            public boolean hasNext()
            {
                return m_min + (m_index + 1) * m_inc <= m_max;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No element");

                return m_min + ++m_index * m_inc ;
            }
        };
    }
}
