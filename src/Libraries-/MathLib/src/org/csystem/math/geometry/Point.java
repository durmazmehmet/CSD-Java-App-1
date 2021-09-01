package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class Point {
	public int X, Y;
	
	public Point() {} 
	
	public Point(int x, int y)
	{
		X = x;
		Y = y;
	}
	
	public Point(int x)
	{
		X = x;
	}
	
	
	public static double distance(int x1, int y1, int x2, int y2)
	{
		return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	public double distance(Point p)
	{
		return distance(X, Y, p.X, p.Y);
	}
	
	public double distance(int x, int y)
	{
		return distance(X, Y, x, y);
	}
	
	public void offset(int dx, int dy)
	{
		X += dx;
		Y += dy;
	}
	
	public void offset(int dxy)
	{
		offset(dxy, dxy);
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof Point))
			return false;

		Point p = (Point)other;

		return p.X == X && p.Y == Y;
	}
	
	public String toString()
	{
		return String.format("(%d, %d)%n", X, Y);
	}
}