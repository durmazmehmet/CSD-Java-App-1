package org.csystem.util;

import java.math.BigInteger;

public class NumberUtil {
	private static final BigInteger THREE = BigInteger.valueOf(3);
	private static final BigInteger FIVE = BigInteger.valueOf(5);
	private static final BigInteger SEVEN = BigInteger.valueOf(7);
	private static final BigInteger ELEVEN = BigInteger.valueOf(11);

	private NumberUtil() {}

	public static long factorial(int n)
	{
		if (n < 0)
			return -1;
		
		long result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}

	public static int [] getDigits(int val)
	{
		int n = getDigitsCount(val);
		val = Math.abs(val);
		int [] digits = new int[n];
		
		int index = n - 1;
		
		while (val != 0) {
			digits[index--] = val % 10;
			val /= 10;
		}		
		
		return digits;
	}

	public static int [] get3Digits(int val)
    {
        if (val == 0)
            return new int[1];

        val = Math.abs(val);
        int [] digits = new int[(int)Math.log10(val) / 3 + 1];

        int index = digits.length - 1;

        while (val != 0) {
            digits[index--] = val % 1000;
            val /= 1000;
        }

        return digits;
    }

	public static int getDigitsCount(BigInteger bi)
	{
		return bi.toString().length();
	}

	public static int getDigitsCount(int val)
	{
	    if (val == 0)
	        return 1;

	    val = Math.abs(val);
		int count = 0;
		
		return (int)Math.log10(val) + 1;
	}
	
	public static int getDigitsSum(int val)
	{		
		int sum = 0;
		
		while (val != 0) {
			sum += val % 10;
			val /= 10;
		}
		
		return Math.abs(sum);
	}

	public static int [] getPrimes(int n)
    {
        int [] primes = new int[n];

        primes[0] = 2;

        int count = 1;
        int i = 3;

        for (; count < n; ++i)
            if (isPrime(i))
                primes[count++] = i;

        return primes;
    }
	
	public static int getPrime(int n)
	{
		if (n <= 0)
			return -1;
		
		if (n == 1)
			return 2;
		
		int count = 0;
		int i = 1;			
		
		for (; count < n; ++i)
			if (isPrime(i))
				++count;
		
		return i - 1;
	}

	public static int getFibonacci(int n)
	{
		if (n < 1)
			return -1;
		
		int prev1 = 0, prev2 = 1, result = 0;
		
		for (int i = 2; i <= n; ++i) {
			result = prev1 + prev2;			
			prev2 = prev1;
			prev1 = result;
		}
		
		return result;
				
	}
	
	public static double getE()
	{
		double e = 2;
		
		for (int i = 2; i < 15; ++i)
			e += 1. / factorial(i);
		
		return e;		
	}
	
	public static int getReverse(int val)
	{		
		int result = 0;
		
		while (val != 0) {
			result = result * 10 + val % 10;
			val /= 10;
		}
		
		return result;
	}
	public static boolean isEven(int val)
	{
		return val % 2 == 0;
	}
	
	public static boolean isPalindrome(int val)
	{
		return getReverse(val) == val;
	}
	
	public static boolean isArmstrong3Digits(int val)
	{
		if (val < 0 || val < 100 || val > 999)
			return false;
		
		int a = val / 100;
		int b =  val / 10 % 10;
		int c = val % 10;
		
		return a * a * a + b * b * b + c * c * c == val;
	}
	
	public static boolean isArmstrong(int val)
	{
		if (val < 0)
			return false;
		
		int count = getDigitsCount(val);
		int temp = val;
		int sum = 0;
		
		while (temp != 0) {
			sum += pow(temp % 10, count);
			temp /= 10;
		}
		
		return val == sum;
	}
	
	public static boolean isPrime(int val)
	{
		if (val <= 1)
			return false;
		
		if (val % 2 == 0)
			return val == 2;
		
		if (val % 3 == 0)
			return val == 3;
		
		if (val % 5 == 0)
			return val == 5;
		
		if (val % 7 == 0)
			return val == 7;
		
		if (val % 11 == 0)
			return val == 11; 
		
		for (int i = 13; i * i <= val; i += 2)
			if (val % i == 0)
				return false;
		
		return true;		
	}

	public static boolean isPrime(BigInteger val)
	{
		if (val.compareTo(BigInteger.ONE) <= 0)
			return false;

		if (val.mod(BigInteger.TWO).equals(BigInteger.ZERO))
			return val.equals(BigInteger.TWO);

		if (val.mod(THREE).equals(BigInteger.ZERO))
			return val.equals(THREE);

		if (val.mod(FIVE).equals(BigInteger.ZERO))
			return val.equals(FIVE);

		if (val.mod(SEVEN).equals(BigInteger.ZERO))
			return val.equals(SEVEN);

		BigInteger sqrtVal = val.sqrt();

		for (BigInteger i = ELEVEN; i.compareTo(sqrtVal) <= 0; i = i.add(BigInteger.TWO))
			if (val.mod(i).equals(BigInteger.ZERO))
				return false;

		return true;
	}


	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}

	public static String numberToStr3digitsTR(int val)
    {
        if (getDigitsCount(val) > 3)
            return "";

        if (val == 0)
            return "sıfır";

        String [] ones = {"", "bir", "iki", "üç", "dört", "beş","altı", "yedi", "sekiz", "dokuz"};
        String [] tens= {"", "on", "yirmi", "otuz", "kırk", "elli","altmış", "yetmiş", "seksen", "doksan"};

        String str = val > 0 ? "" : "eksi";

        val = Math.abs(val);

        int a = val / 100;
        int b = val / 10 % 10;
        int c = val % 10;

        if (a != 0) {
            if (a != 1)
                str += ones[a];

            str += "yüz";
        }

        if (b != 0)
            str += tens[b];

        if (c != 0)
            str += ones[c];

        return str;
    }
	
	public static int pow(int a, int b)
	{
		b = Math.abs(b);
		
		int result = 1;
		
		while (b-- > 0)
			result *= a;			
		
		return result;
	}

}
