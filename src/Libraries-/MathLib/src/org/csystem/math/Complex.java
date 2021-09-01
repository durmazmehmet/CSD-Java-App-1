package org.csystem.math;

import static java.lang.Math.sqrt;

public class Complex {
	private static Complex add(double re1, double im1, double re2, double im2)
	{
		return new Complex(re1 + re2, im1 + im2);
	}

	private static Complex sub(double re1, double im1, double re2, double im2)
	{
		return add(re1, im1, -re2, -im2);
	}

	private static Complex mul(double re1, double im1, double re2, double im2)
	{
		//TODO:
		return new Complex();
	}

	public double Re, Im;

	
	public Complex() {}
	
	public Complex(double re, double im)
	{
		Re = re;
		Im = im;
	}
	
	public Complex(double re)
	{
		this(re, 0);
	}
	
	public static Complex add(double val, Complex z)
	{
		return add(val, 0, z.Re, z.Im);
	}
	
	public Complex add(Complex z)
	{
		return add(Re, Im, z.Re, z.Im);						
	}
	
	public Complex add(double val)
	{
		return add(Re, Im, val, 0);				
	}	
	
	//sub
	public static Complex sub(double val, Complex z)
	{
		return sub(val, 0, z.Re, z.Im);								
	}
	
	public Complex sub(Complex z)
	{
		return sub(Re, Im, z.Re, z.Im);						
	}
	
	public Complex sub(double val)
	{
		return sub(Re, Im, val, 0);				
	}
	
	//mul
	public Complex getConjugate()
	{
		return new Complex(Re, -Im);		
	}
	
	public double getNorm() 
	{
		return sqrt(Re * Re + Im * Im);		
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof Complex))
			return false;

		Complex z = (Complex) other;

		return z.Re == Re && z.Im == Im;
	}
	
	public String toString()
	{
		return String.format("|%.2f + %.2fi|=%.2f", Re, Im, getNorm());
	}
}