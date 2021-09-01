package org.csystem.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomIntGenerator implements Iterable<Integer> {
    private int m_count;
    private int m_min, m_max; //[min, max)
    private Random m_random;

    public RandomIntGenerator(int count, int min, int max, Random random)
    {
        if (count <= 0 || min >= max)
            throw new IllegalArgumentException("Invalid arguments");

        m_count = count;
        m_min = min;
        m_max = max;
        m_random = random == null ? new Random() : random;
    }

    public RandomIntGenerator(int count, int min, int max)
    {
        this(count, min, max, new Random());
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>() {
            private int m_counter;

            @Override
            public boolean hasNext()
            {
                return m_counter + 1 <= m_count;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No element");

                ++m_counter;

                return m_random.nextInt(m_max - m_min) + m_min;
            }
        };
    }
}
