package org.csystem.math.geometry;

import static java.lang.Math.*;

public class Circle {
    private double m_r;

    public Circle()
    {}

    public Circle(double radius)
    {
        setRadius(radius);
    }

    public void setRadius(double radius)
    {
        m_r = abs(radius);
    }

    public double getRadius() {return m_r;}

    public void setArea(double area)
    {
        m_r = sqrt(area / PI);
    }

    public double getArea() {return PI * m_r * m_r;}

    public double getCircumference() {return 2 * PI * m_r;}

    public void setCircumference(double circumference)
    {
        m_r = circumference / (2 * PI);
    }
}
