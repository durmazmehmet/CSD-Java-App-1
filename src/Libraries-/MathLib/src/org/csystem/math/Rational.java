package org.csystem.math;

import java.util.Random;

public class Rational implements Comparable<Rational>{
    private int m_a, m_b;
    private boolean m_simplified;

    private static void control(int a, int b)
    {
        if (b == 0) {
            if (a == 0)
                throw new RationalException("Belirsiz", RationalStatus.INDEFINITE);

            throw new RationalException("Tanımsız", RationalStatus.UNDEFINED);
        }
    }

    private void set(int a, int b)
    {
        m_a = a;
        m_b = m_a == 0 ? 1 : b;

        if (m_b < 0) {
            m_a = -m_a;
            m_b = -m_b;
        }
        if (m_simplified)
            this.simplify();
    }

    private static Rational add(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * b2 + a2 * b1, b1 * b2, true);
    }

    private static Rational sub(int a1, int b1, int a2, int b2)
    {
        return add(a1, b1, -a2, b2);
    }

    private static Rational mul(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * a2, b1 * b2, true);
    }

    private static Rational div(int a1, int b1, int a2, int b2)
    {
        return mul(a1, b1, b2, a2);
    }

    public static Rational getRandomRational()
    {
        return getRandomRational(new Random());

    }

    public static Rational getRandomRational(Random r)
    {
        return new Rational(r.nextInt(), r.nextInt());
    }

    public static Rational getRandomRational(int min, int max) //[min, max)
    {
        return getRandomRational(new Random(), min, max, false);
    }

    public static Rational getRandomRational(Random r, int min, int max) //[min, max)
    {
        return getRandomRational(r, min,  max, true);
    }

    public static Rational getRandomRational(int min, int max, boolean simplified) //[min, max)
    {
        return getRandomRational(new Random(), min, max, simplified);
    }

    public static Rational getRandomRational(Random r, int min, int max, boolean simplified) //[min, max)
    {
        int a = r.nextInt(max - min) + min;
        int b = r.nextInt(max - min) + min;

        return new Rational(a, b, simplified);
    }

    public Rational()
    {
        //this(0, 1);
        m_b = 1; //performans için
    }

    public Rational(boolean simplified)
    {
        this(0, 1, simplified);
    }

    public Rational(int a)
    {
        this(a, 1);
    }

    public Rational(int a, boolean simplified)
    {
        this(a, 1, simplified);
    }

    public Rational(int a, int b)
    {
        this(a, b, false);
    }

    public Rational(int a, int b, boolean simplified)
    {
        control(a, b);
        m_simplified = simplified;
        this.set(a, b);
    }

    public void simplify()
    {
        int a = Math.abs(m_a);
        int b = Math.abs(m_b);
        int min = a < b ? a : b;

        for (int i = min; i >= 2; --i) {
            if (m_a % i == 0 && m_b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
        }
    }

    public int getNumerator() {return  m_a;}

    public void setNumerator(int a)
    {
        if (m_a == a)
            return;

        set(a, m_b);
    }

    public int getDenominator() {return  m_b;}

    public void setDenominator(int b)
    {
        if (m_b == b)
            return;

        control(m_a, b);
        this.set(m_a, b);
    }

    public double getRealValue() {return (double)m_a / m_b;}

    public void setSimplified(boolean simplified)
    {
        m_simplified = simplified;
        if (m_simplified)
            this.simplify();
    }

    public boolean isSimplified() {return m_simplified;}

    public Rational getSimplifiedRational()
    {
        return new Rational(m_a, m_b, true);
    }


    public static Rational add(int val, Rational r)
    {
        return r.add(val);
    }

    public Rational add(Rational r)
    {
        return add(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational add(int val)
    {
        return add(m_a, m_b, val, 1);
    }

    public static Rational sub(int val, Rational r)
    {
        return sub(val, 1, r.m_a, r.m_b);
    }

    public Rational sub(Rational r)
    {
        return sub(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational sub(int val)
    {
        return sub(m_a, m_b, val, 1);
    }


    public static Rational mul(int val, Rational r)
    {
        return r.mul(val);
    }

    public Rational mul(Rational r)
    {
        return mul(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational mul(int val)
    {
        return mul(m_a, m_b, val, 1);
    }

    public static Rational div(int val, Rational r)
    {
        return div(val, 1, r.m_a, r.m_b);
    }

    public Rational div(Rational r)
    {
        return div(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational div(int val)
    {
        return div(m_a, m_b, val, 1);
    }

    public void inc()
    {
        m_a += m_b;
    }

    public void dec()
    {
        m_a -= m_b;
    }

    public Rational neg()
    {
        return new Rational(-m_a, m_b, m_simplified);
    }

    public static boolean equals(Rational r1, Rational r2)
    {
        return r1.equals(r2);
    }

    public int compareTo(Rational r)
    {
        return m_a * r.m_b - r.m_a * m_b;
    }

    public boolean equals(Object other)
    {
        Rational r1 = getSimplifiedRational();
        Rational r2 = ((Rational)other).getSimplifiedRational();

        return r1.m_a == r2.m_a && r1.m_b == r2.m_b;
    }

    public String toString()
    {
        return String.format("%d / %d = %f", m_a, m_b, getRealValue());
    }
}
