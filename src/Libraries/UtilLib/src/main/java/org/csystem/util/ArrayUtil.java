package org.csystem.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayUtil {
    private ArrayUtil() {}

    private static IntStream getRange(int min, int max)
    {
        return IntStream.range(min, max);
    }

    public static BigDecimal average(BigDecimal [] decimals)
    {
        return average(decimals, 0, RoundingMode.HALF_UP);
    }

    public static BigDecimal average(BigDecimal [] decimals, RoundingMode roundingMode)
    {
        return average(decimals, 0, roundingMode);
    }

    public static BigDecimal average(BigDecimal [] decimals, int scale, RoundingMode roundingMode)
    {
        return sum(decimals).divide(BigDecimal.valueOf(decimals.length), scale, roundingMode);
    }

	public static double average(int [] a)
	{
		return (double)sum(a) / a.length;
	}


	public static int[] copy(int [] src, int [] dest, int count)
    {
        for (int i = 0; i < count; ++i)
            dest[i] = src[i];

        return dest;
    }

    public static String []copy(String[] src, String[] dest)
    {
        return copy(src, dest, src.length);
    }

    public static String[] copy(String[] src, String[] dest, int count)
    {
        for (int i = 0; i < count; ++i)
            dest[i] = src[i];

        return dest;
    }

    public static int []copy(int [] src, int [] dest)
    {
        return copy(src, dest, src.length);
    }

	public static void display(int [][] a, int n)
    {
        String fmt = String.format("%%0%dd ", n);

        IntStream.range(0, a.length).forEach(i -> {
            IntStream.range(0, a[i].length).forEach(j -> System.out.printf(fmt, a[i][j]));
            System.out.println();
        });
    }

	public static void display(int [] a, int n)
	{
		String fmt = String.format("%%0%dd ", n);

		IntStream.of(a).forEach(val -> System.out.printf(fmt, val));
		
		System.out.println();
	}
	
	public static void display(int [] a)
	{
		display(a, 1);
	}
	
	public static void display(boolean [] a)
	{
        IntStream.range(0, a.length).mapToObj(index->a[index]).forEach(b -> System.out.printf("%b ", b));
		
		System.out.println();
	}

	public static <T> void display(T [] a)
    {
        Stream.of(a).forEach(t -> System.out.printf("%s ", t));
        System.out.println();
    }
	
	public static void drawHistogram(int [] hist, int maxChar, char ch)
	{
		int max = max(hist);

        getRange(0, hist.length).forEach(val -> {
            int n = (int)Math.round(val * maxChar / (double)max);

            IntStream.range(0, n).forEach(r -> System.out.printf("%c ", ch));

            System.out.println();
        });
	}
	
	public static int [] fill(int [] a, int val)
	{
	    IntStream.range(0, a.length).forEach(index -> a[index] = val);

		return a;
	}

    public static int [] getHistogram(int [] a, int n) //[0, n]
    {
        int [] hist = new int[n + 1];

        IntStream.of(a).forEach(val -> hist[val]++);

        return hist;
    }


	public static int [] getRandomArray(int n, int min, int max) //[min, max)
	{		
		return getRandomArray(new Random(), n, min, max).get();
	}
	
	public static Optional<int []> getRandomArray(Random r, int n, int min, int max) //[min, max)
	{
		if (n < 0 || min > max)
			throw new IllegalArgumentException("Invalid Arguments");

		if (r == null)
		    return Optional.empty();

		int [] a = new int[n];

		getRange(0, n).forEach(i -> a[i] = r.nextInt(max - min) + min);
		
		return Optional.of(a);
	}

    public static BigDecimal [] getRandomBigDecimalArray(int n, double min, double max) //[min, max)
    {
        return getRandomBigDecimalArray(new Random(), n, min, max);
    }

	public static BigDecimal [] getRandomBigDecimalArray(Random r, int n, double min, double max) //[min, max)
    {
        if (n < 0 || min > max)
            throw new IllegalArgumentException("Invalid Arguments");

        if (r == null)
            r = new Random();

        BigDecimal [] decimals = new BigDecimal[n];

        for (int i = 0; i < n; ++i)
            decimals[i] = BigDecimal.valueOf(r.nextDouble() * (max - min) + min);

        return decimals;
    }


    public static int [][] getRandomMatrix(int m, int n, int min, int max) // [min, max)
    {
        return getRandomMatrix(new Random(), m, n, min, max);
    }

	public static int [][] getRandomMatrix(Random r, int m, int n, int min, int max) //[min, max)
    {
        int [][] a = new int[m][];

        for (int i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max).get();

        return a;
    }

    public static int [][] getRandomSquareMatrix(int n, int min, int max) // [min, max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int [][] getRandomSquareMatrix(Random r, int n, int min, int max) // [min, max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static int[][] getTranspose(int [][] a)
    {
        if (!isMatrix(a))
            throw new IllegalArgumentException("Invalid Matrix");

        int [][] t = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                t[j][i] = a[i][j];

        return t;
    }
	
	public static boolean isEmpty(int [] a)
	{
		return a.length == 0;
	}

	public static boolean isMatrix(int [][] a)
    {
        int len = a[0].length;

        for (int i = 1; i < a.length; ++i)
            if (len != a[i].length)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static String join(ArrayList list, String delim)
    {
        String str = "";

        for (Object o : list) {
            if (!str.isEmpty())
                str += delim;

            str += (String)o;
        }

        return str;
    }

    public static String join(ArrayList list, char delim)
    {
        return join(list, delim + "");
    }

    public static String join(String [] s, String delim)
    {
        String str = "";

        for (String sval: s)
            str += sval + delim;

        return str.isEmpty() ? "" : str.substring(0, str.length() - delim.length());
    }

    public static String join(String [] s, char delim)
    {
        return join(s, delim + "");
    }

	public static int max(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            if (result < a[i])
                result = a[i];

        return result;
    }

    public static BigDecimal max(BigDecimal [] decimals)
    {
        BigDecimal result = decimals[0];

        for (int i = 1; i < decimals.length; ++i)
            result = result.max(decimals[i]);

        return result;
    }

    public static int []merge(int [] a, int...b)
    {
        int [] c = new int[a.length + b.length];

        int index = 0;

        for (int val : a)
            c[index++] = val;

        for (int val : b)
            c[index++] = val;

        return c;
    }

    public static BigDecimal min(BigDecimal [] decimals)
    {
        BigDecimal result = decimals[0];

        for (int i = 1; i < decimals.length; ++i)
            result = result.min(decimals[i]);

        return result;
    }
	
	public static Optional<Integer> min(int [] a)
	{
	    if (a.length == 0)
	        return Optional.empty();

		int result = a[0];
		
		for (int i = 1; i < a.length; ++i)
			if (result > a[i])
				result = a[i];
		
		return Optional.of(result);
	}

	public static <T> T min(T [] a, Comparator<T> cmp)
    {
        T result = a[0];

        for (int i = 1; i < a.length; ++i)
            if (cmp.compare(result, a[i]) > 0)
                result = a[i];

        return result;
    }

	public static int [] resize(int [] a, int len)
    {
        if (len <= a.length)
            return a;

        int [] newArray = new int[len];

        return copy(a, newArray);
    }

    public static String [] resize(String [] a, int len)
    {
        if (len <= a.length)
            return a;

        String [] newArray = new String[len];

        return copy(a, newArray);
    }

	public static int [] reverse(int [] a)
	{
		int halfLen = a.length / 2;

		for (int i = 0; i < halfLen; ++i) {
            int temp = a[i];

            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }

        return a;
	}

    public static char [] reverse(char [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i) {
            char temp = a[i];

            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }

        return a;
    }

    public static int sum(int initVal, int...a)
    {
        return IntStream.of(a).reduce(initVal, (r, e)->r + e);
    }

    public static int sum(int [][] a)
    {
        int result = 0;

        for (int [] array : a)
            result += sum(array);

        return result;
    }

	public static int sum(int[]a)
	{
		return sum(0, a);
	}

	public static BigDecimal sum(BigDecimal[] decimals)
    {
        BigDecimal result = BigDecimal.ZERO;

        for (BigDecimal bd : decimals)
            result = result.add(bd);

        return result;
    }

	public static int sumDiagonal(int [][] a)
    {
        if (!isSquareMatrix(a))
            throw new IllegalArgumentException("Invalid Matrix");


        int result = 0;

        for (int i = 0; i < a.length; ++i)
            result += a[i][i];

        return result;
    }
}
