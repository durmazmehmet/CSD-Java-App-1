package org.csystem.util;

import java.util.HashSet;
import java.util.Random;

public class StringUtil {



    private static String getRandomText(Random r, String chars, int n)
    {
        StringBuilder sb  = new StringBuilder(n);

        for (int i = 0; i < n; ++i)
            sb.append(chars.charAt(r.nextInt(chars.length())));

        return sb.toString();
    }

    private static String getRandomUnrepeatedText(Random r, String chars, int n)
    {
        if (n <= 0 || n > chars.length())
            throw new IllegalArgumentException("Invalid n n value");

        StringBuilder sb  = new StringBuilder(n);
        StringBuilder status = new StringBuilder(chars.length());

        status.setLength(chars.length());
        int index;
        char ch;

        for (int i = 0; i < n; ++i) {
            for (;;) {
                index = r.nextInt(chars.length());
                ch = chars.charAt(index);

                if (status.charAt(index) == '\0')
                    break;
            }
            sb.append(ch);
            status.setCharAt(index, ch);
        }

        return sb.toString();
    }

    private StringUtil() {}

    public static boolean areCharactersDistinct(String str)
    {
        int len = str.length();

        var characterHashSet = new HashSet<Character>();

        for (int i = 0; i < len; ++i)
            characterHashSet.add(str.charAt(i));

        return len == characterHashSet.size();
    }

    public static String capitalize(String s)
    {
        s = s.trim();
        if (s.isEmpty())
            return s;

        var sb = new StringBuilder(s.length());

        sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase());

        return sb.toString();
    }

    public static String changeCase(String str)
    {
        var sb = new StringBuilder(str);
        int len = sb.length();


        for (int i = 0; i < len; ++i) {
            char ch = sb.charAt(i);

            if (!Character.isLetter(ch))
                continue;

            sb.setCharAt(i, Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch));
        }

        return sb.toString();
    }

    public static String delete(String str, int begin, int end)
    {
        return new StringBuilder(str).delete(begin, end).toString();
    }

    public static int getCount(String s1, String s2)
    {
        int count = 0;

        for (int index = 0; (index = s1.indexOf(s2, index)) != -1; ++index, ++count)
            ;

        return count;
    }

    public static int getCountIgnoreCase(String s1, String s2)
    {
        return getCount(s1.toLowerCase(), s2.toLowerCase());
    }

    public static String getRandomPassword(Random r, int n)
    {
        if (n < 1)
            return "";

        StringBuilder sb = new StringBuilder(n);
        String delims = "_-?:";

        for (int i = 0; i < n; ++i) {
            int val = r.nextInt(4);
            switch (val) {
                case 0:
                    sb.append((char)(r.nextInt(26) + 'A'));
                    break;
                case 1:
                    sb.append((char)(r.nextInt(26) + 'a'));
                    break;
                case 2:
                    sb.append((char)(r.nextInt(10) + '0'));
                    break;
                case 3:
                    sb.append(delims.charAt(r.nextInt(delims.length())));
                    break;
            }

        }

        return sb.toString();
    }

    public static String getRandomPassword(int n)
    {
        return getRandomPassword(new Random(), n);
    }

    public static String getRandomTextDE(Random r, int n)
    {
        if (n < 1)
            return "";

        String chars = "AaBbCcDdEeFfGgHhiIJjKkLlMmNnOoÖöPpRrSsTtUuÜüVvWwYyZz\u00E4\u00C4\u00DF";

        return getRandomText(r, chars, n);
    }

    public static String getRandomTextDE(int n)
    {
        return getRandomTextDE(new Random(), n);
    }

    public static String getRandomTextEN(Random r, int n)
    {
        if (n < 1)
            return "";

        StringBuilder sb = new StringBuilder(n);

        while (n-- > 0) {
            boolean capital = r.nextBoolean();
            int index = r.nextInt(26);

            sb.append(capital ? (char)(index + 'A') : (char)(index + 'a'));
        }

        return sb.toString();
    }

    public static String getRandomTextEN(int n)
    {
        return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n)
    {
        if (n < 1)
            return "";


        String chars = "AaBbCcÇçDdEeFfGgĞğHhıIİiJjKkLlMmNnOoÖöPpRrSsŞşTtUuÜüVvYyZz";

        return getRandomText(r, chars, n);
    }

    public static String getRandomTextTR(int n)
    {
        return getRandomTextTR(new Random(), n);
    }

    public static String getString(int n, char ch)
    {
        StringBuilder sb = new StringBuilder(n);

        while (n-- > 0)
            sb.append(ch);

        return sb.toString();
    }

    public static String getRandomUnrepeatedTextEN(int n)
    {
        return getRandomUnrepeatedTextEN(new Random(), n);
    }

    public static String getRandomUnrepeatedTextEN(Random r, int n)
    {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        return getRandomUnrepeatedText(r, chars, n);
    }

    public static String getRandomUnrepeatedTextTR(int n)
    {
        return getRandomUnrepeatedTextTR(new Random(), n);
    }

    public static String getRandomUnrepeatedTextTR(Random r, int n)
    {
        String chars = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZabcçdefgğhıijklmnoöprsştuüvyz";

        return getRandomUnrepeatedText(r, chars, n);
    }

    public static boolean isPalindrome(String s)
    {
        return reverse(s).equals(s);
    }

    public static boolean isPangramTR(String str)
    {
        String chars = "abcçdefgğhıijklmnoöprsştuüvyz";

        int len = chars.length();

        str = str.toLowerCase();

        for (int i = 0; i < len; ++i)
            if (!str.contains(chars.charAt(i) + ""))
                return false;

        return true;
    }

    public static String padRight(String s, int n, char ch)
    {
        if (n <= s.length())
            return s;

        return s + getString(n - s.length(), ch);
    }

    public static String padRight(String s, int n)
    {
        return padRight(s, n, ' ');
    }

    public static String padLeft(String s, int n, char ch)
    {
        if (n <= s.length())
            return s;

        return getString(n - s.length(), ch) + s;
    }

    public static String padLeft(String s, int n)
    {
        return padLeft(s, n, ' ');
    }

    public static String removeWS(String s)
    {
        StringBuilder sb = new StringBuilder(s.length());
        int len = s.length();

        for (int i = 0; i < len; ++i) {
            char ch = s.charAt(i);

            if (!Character.isWhitespace(ch))
                sb.append(ch);
        }

        return sb.toString();
    }
    
    public static String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }

    public static String trimEnd(String s)
    {
        int i;

        for (i = s.length() - 1; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
            ;

        return s.substring(0, i + 1);
    }

    public static String trimStart(String s)
    {
        int i;
        int len = s.length();

        for (i = 0; i < len && Character.isWhitespace(s.charAt(i)); ++i)
            ;

        return s.substring(i);
    }
}
