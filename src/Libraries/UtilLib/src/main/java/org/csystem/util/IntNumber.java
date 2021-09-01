package org.csystem.util;

public class IntNumber {
    private final int m_val;
    private final static IntNumber[] ms_cache = new IntNumber[256]; //[-128, 127]

    private static boolean contains(int val)
    {
        return ms_cache[val + 128] != null;
    }

    private IntNumber(int val)
    {
        m_val = val;
    }

    public static final IntNumber ZERO;
    public static final IntNumber ONE;
    public static final IntNumber TEN;

    static {
        ms_cache[128] = ZERO = new IntNumber(0);
        ms_cache[1 + 128] = ONE = new IntNumber(1);
        ms_cache[10 + 128] = TEN = new IntNumber(10);
    }

    public static IntNumber valueOf(int val)
    {
        if (val < -128 || val > 127)
            return new IntNumber(val);

        if (!contains(val))
            ms_cache[val + 128] = new IntNumber(val);

        return ms_cache[val + 128];
    }

    public double doubleValue() {return m_val;}
    public short shortValue() {return (short)m_val;}
    public int getVal() {return m_val;}

    public IntNumber add(IntNumber n)
    {
        return add(n.m_val);
    }

    public IntNumber add(int val)
    {
        return IntNumber.valueOf(m_val + val);
    }

    public IntNumber mul(IntNumber n)
    {
        return mul(n.m_val);
    }

    public IntNumber mul(int val)
    {
        return IntNumber.valueOf(m_val * val);
    }

    public IntNumber sub(IntNumber n)
    {
        return sub(n.m_val);
    }

    public IntNumber sub(int val)
    {
        return add(-val);
    }

    public boolean equals(Object other)
    {
        return ((IntNumber)other).m_val == m_val;
    }

    public String toString() {return m_val + "";}
}
