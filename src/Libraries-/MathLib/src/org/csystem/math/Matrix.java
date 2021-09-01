package org.csystem.math;

public class Matrix<T extends Number> {
	private double [][] m_matrix;

	private static void doOperation(Matrix m, double [][] m1, double [][] m2, char op)
	{
		if (op == '+') {
			for (int i = 0; i < m.m_matrix.length; ++i)
				for (int j = 0; j < m.m_matrix[0].length; ++j)
					m.m_matrix[i][j] = m1[i][j] + m2[i][j];
		}
		else if (op == '-') {
			for (int i = 0; i < m.m_matrix.length; ++i)
				for (int j = 0; j < m.m_matrix[0].length; ++j)
					m.m_matrix[i][j] = m1[i][j] - m2[i][j];
		}
	}


	private static boolean equals(Matrix m1, Matrix m2)
	{
		int row1 = m1.m_matrix.length;
		int col1 = m1.m_matrix[0].length;		
		int row2 = m2.m_matrix.length;
		int col2 = m2.m_matrix[0].length;
		
		if (row1 != row2 || col1 != col2)
			return false;
		
		for (int i = 0; i < row1; ++i) 
			for (int j = 0; j < col1; ++j)
				if (m1.m_matrix[i][j] != m2.m_matrix[i][j])
					return false;
		
		return true;
	}
	
	private void copyMatrices(double [][]a)
	{
		int row = a.length;
		int col = a[0].length;
		
		for (int i = 0; i < row; ++i)
			for (int j = 0; j < col; ++j)
				m_matrix[i][j] = a[i][j];
	}

	private static boolean isMatrix(double [][] a)
	{
		int col = a[0].length;
		
		for (int i = 1; i < a.length; ++i)
			if (col != a[i].length)
				return false;
		
		return true;
	}

	public Matrix(int m, int n)
	{
		if (m <= 0 || n <= 0)
			throw new IllegalArgumentException("Invalid dimensions");

		m_matrix = new double[m][n];
	}

	public Matrix(double [][] m)
	{
		if (!isMatrix(m))
			throw new UnsupportedOperationException("m must be matrix");

		m_matrix = new double[m.length][m[0].length];
		this.copyMatrices(m);
	}


	public boolean isSquareMatrix()
	{
		return m_matrix.length == m_matrix[0].length;
	}	
	

	public double getSumOfDiagonal()
	{
		if (!isSquareMatrix()) 
			throw new UnsupportedOperationException("matrix must be square matrix");
		
		double sum = 0;
		
		for (int i = 0; i < m_matrix.length; ++i)
			sum += m_matrix[i][i];
		
		return sum;
	}
	
	public static Matrix getIdentityMatrix(int n)
	{
		Matrix m = new Matrix(n, n);
		
		for (int i = 0; i < n; ++i)
			m.m_matrix[i][i] = 1;
		
		return m;
	}	
	

	public int getRow() {return m_matrix.length;}
	public int getCol() {return m_matrix[0].length;}
	
	public void set(int i, int j, double val)
	{
		if (i < 0 || i >= m_matrix.length || j < 0 || j >= m_matrix[0].length)
			throw new IndexOutOfBoundsException("Invalid indices");	
		
		m_matrix[i][j] = val;
	}
	
	public double get(int i, int j)
	{
		if (i < 0 || i >= m_matrix.length || j < 0 || j >= m_matrix[0].length)
			throw new IndexOutOfBoundsException("Invalid indices");
		
		return m_matrix[i][j];
	}	
	
	public Matrix add(Matrix m)
	{
		if (m_matrix.length != m.m_matrix.length || m_matrix[0].length != m.m_matrix[0].length) 
			throw new UnsupportedOperationException("Matrices can not be added");			
		
		Matrix result = new Matrix(m_matrix.length, m_matrix[0].length);
		
		doOperation(result, m_matrix, m.m_matrix,'+');		
		
		return result;
	}
	
	public Matrix sub(Matrix m)
	{
		if (m_matrix.length != m.m_matrix.length || m_matrix[0].length != m.m_matrix[0].length)
			throw new UnsupportedOperationException("Matrices can not be sub");
				
		
		Matrix result = new Matrix(m_matrix.length, m_matrix[0].length);
		
		doOperation(result, m_matrix, m.m_matrix,'-');		
		
		return result;
	}
	
	public void transpose()
	{
		//TODO:
	}
	
	public boolean equals(Object obj)
	{		
		Matrix m = (Matrix)obj;
		
		return equals(this, m);				
	}
	
	public String toString()
	{
		int row = m_matrix.length;
		int col = m_matrix[0].length;
	
		String str = "";
		
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j)
				str += String.format("%.2f ", m_matrix[i][j]);
			str += "\n";
		}
		
		return str;
	}
}