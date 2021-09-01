package org.csystem.util;

public class MutableIntNumber {
    private int m_val;

    public MutableIntNumber()
    {}
    public MutableIntNumber(int val)
    {
        m_val = val;
    }

    public int getVal()
    {
        return m_val;
    }

    public void setVal(int val)
    {
        m_val = val;
    }

    public MutableIntNumber add(MutableIntNumber n)
    {
        return add(n.m_val);
    }

    public MutableIntNumber add(int n)
    {
        m_val += n;

        return this;
    }

    public MutableIntNumber mul(MutableIntNumber n)
    {
        return mul(n.m_val);
    }

    public MutableIntNumber mul(int n)
    {
        m_val *= n;

        return this;
    }

    public MutableIntNumber sub(MutableIntNumber n)
    {
        return sub(n.m_val);
    }

    public MutableIntNumber sub(int n)
    {
        return add(-n);
    }

    public String toString()
    {
        return m_val + "";
    }
}
