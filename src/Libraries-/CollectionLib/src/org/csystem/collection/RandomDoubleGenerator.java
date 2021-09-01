package org.csystem.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomDoubleGenerator implements Iterable<Double> {
    private int m_count;
    private double m_min, m_max; //[min, max)
    private Random m_random;

    public RandomDoubleGenerator(int count, double min, double max, Random random)
    {
        if (count <= 0 || min >= max)
            throw new IllegalArgumentException("Invalid arguments");

        m_count = count;
        m_min = min;
        m_max = max;
        m_random = random == null ? new Random() : random;
    }

    public RandomDoubleGenerator(int count, double min, double max)
    {
        this(count, min, max, new Random());
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<Double>() {
            private int m_counter;

            @Override
            public boolean hasNext()
            {
                return m_counter + 1 <= m_count;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No element");

                ++m_counter;

                return m_random.nextDouble() * (m_max - m_min) + m_min;
            }
        };
    }
}
