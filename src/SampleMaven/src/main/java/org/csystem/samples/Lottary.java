package org.csystem.samples;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lottary {
    private Random m_random;

    public Lottary()
    {
        m_random = new Random();
    }

    public int [] getColumn()
    {
        int [] column = new int[6];

        Set<Integer> set = new TreeSet<>();

        while (set.size() != 6)
            set.add(m_random.nextInt(49) + 1);

        int index = 0;

        for (int val : set)
            column[index++] = val;

        return column;
    }

    public int [][] getColumns(int n)
    {
        int[][] columns = new int[n][];

        for (int i = 0; i < n; ++i)
            columns[i] = getColumn();

        return columns;
    }
}
