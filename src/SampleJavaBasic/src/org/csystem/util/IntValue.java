/*----------------------------------------------------------------------------------------------------------------------
    IntValue sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public class IntValue {
    private static final IntValue [] CACHE;

    static {
        CACHE = new IntValue[256];
        ZERO = of(0);
        ONE = of(1);
        TEN = of(10);
    }

    private final int m_val;

    private IntValue(int val)
    {
        m_val = val;
    }

    public static final IntValue ZERO;
    public static final IntValue ONE;
    public static final IntValue TEN;

    public static IntValue of(int val)
    {
        if (val < -128  || val > 127)
            return new IntValue(val);

        if (CACHE[val + 128] == null)
            CACHE[val + 128] = new IntValue(val);

        return CACHE[val + 128];
    }

    public int getVal()
    {
        return m_val;
    }

    public IntValue add(int val)
    {
        return IntValue.of(m_val + val);
    }

    public IntValue add(IntValue intValue)
    {
        return add(intValue.m_val);
    }

    public IntValue multiply(int val)
    {
        return IntValue.of(m_val * val);
    }

    public IntValue multiply(IntValue intValue)
    {
        return multiply(intValue.m_val);
    }

    public IntValue subtract(int val)
    {
        return add(-val);
    }

    public IntValue subtract(IntValue intValue)
    {
        return subtract(intValue.m_val);
    }

    public int compareTo(IntValue other)
    {
        return m_val - other.m_val;
    }

    public IntValue increment()
    {
        return add(1);
    }

    public IntValue decrement()
    {
        return subtract(1);
    }


    public String toString()
    {
        return m_val + "";
    }
}
