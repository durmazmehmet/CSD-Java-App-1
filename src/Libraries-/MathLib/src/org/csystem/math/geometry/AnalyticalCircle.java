package org.csystem.math.geometry;

public class AnalyticalCircle extends Circle {
    private final Point m_center;

    public AnalyticalCircle()
    {
        this(0, 0, 0);
    }

    public AnalyticalCircle(double r)
    {
        this(r, 0, 0);
    }

    public AnalyticalCircle(int x, int y)
    {
        this(0, x, y);
    }

    public AnalyticalCircle(double r, int x, int y)
    {
        super(r);
        m_center = new Point(x, y);
    }

    public void setX(int x)
    {
        m_center.X = x;
    }
    public int getX() {return m_center.X;}

    public void setY(int y)
    {
        m_center.Y = y;
    }

    public int getY() {return m_center.Y;}

    public void setCenter(Point center)
    {
        setX(center.X);
        setY(center.Y);
    }

    public Point getCenter() {return new Point(m_center.X, m_center.Y);}

    public void offset(int dxy)
    {
        offset(dxy, dxy);
    }

    public void offset(int dx, int dy)
    {
        m_center.offset(dx, dy);
    }

    public boolean equals(Object other)
    {
        AnalyticalCircle oth = (AnalyticalCircle)other;

        return m_center.equals(oth.m_center) && getRadius() == oth.getRadius();
    }

    public String toString()
    {
        return String.format("{X = %d, Y = %d, Radius = %f}", m_center.X, m_center.Y, getRadius());
    }
}
