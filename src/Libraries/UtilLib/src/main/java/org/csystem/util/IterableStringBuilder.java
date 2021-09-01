package org.csystem.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class IterableStringBuilder implements Serializable, CharSequence, Iterable<Character> {
    private StringBuilder m_stringBuilder;

    public IterableStringBuilder()
    {
        this(16);
    }

    public IterableStringBuilder(int initialCapacity)
    {
        m_stringBuilder = new StringBuilder(initialCapacity);
    }

    public IterableStringBuilder(CharSequence seq)
    {
        m_stringBuilder = new StringBuilder(seq);
    }

    public IterableStringBuilder(String str)
    {
        m_stringBuilder = new StringBuilder(str);
    }

    @Override
    public Iterator<Character> iterator()
    {
        return new Iterator<Character>() {
            private int m_index = -1;

            @Override
            public boolean hasNext()
            {
                return m_index + 1 < m_stringBuilder.length();
            }

            @Override
            public Character next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No character");

                return m_stringBuilder.charAt(++m_index);
            }
        };
    }

    public int compareTo(StringBuilder another)
    {
        return m_stringBuilder.compareTo(another);
    }

    public StringBuilder append(Object obj)
    {
        return m_stringBuilder.append(obj);
    }

    public IterableStringBuilder append(String str)
    {
        m_stringBuilder.append(str);

        return this;
    }

    public StringBuilder append(StringBuffer sb)
    {
        return m_stringBuilder.append(sb);
    }

    public StringBuilder append(CharSequence s)
    {
        return m_stringBuilder.append(s);
    }

    public StringBuilder append(CharSequence s, int start, int end)
    {
        return m_stringBuilder.append(s, start, end);
    }

    public StringBuilder append(char[] str)
    {
        return m_stringBuilder.append(str);
    }

    public StringBuilder append(char[] str, int offset, int len)
    {
        return m_stringBuilder.append(str, offset, len);
    }

    public StringBuilder append(boolean b)
    {
        return m_stringBuilder.append(b);
    }


    public StringBuilder append(char c)
    {
        return m_stringBuilder.append(c);
    }


    public StringBuilder append(int i)
    {
        return m_stringBuilder.append(i);
    }

    public StringBuilder append(long lng)
    {
        return m_stringBuilder.append(lng);
    }

    public StringBuilder append(float f)
    {
        return m_stringBuilder.append(f);
    }

    public StringBuilder append(double d)
    {
        return m_stringBuilder.append(d);
    }

    public StringBuilder appendCodePoint(int codePoint)
    {
        return m_stringBuilder.appendCodePoint(codePoint);
    }

    public StringBuilder delete(int start, int end)
    {
        return m_stringBuilder.delete(start, end);
    }

    public StringBuilder deleteCharAt(int index)
    {
        return m_stringBuilder.deleteCharAt(index);
    }

    public StringBuilder replace(int start, int end, String str)
    {
        return m_stringBuilder.replace(start, end, str);
    }

    public StringBuilder insert(int index, char[] str, int offset, int len)
    {
        return m_stringBuilder.insert(index, str, offset, len);
    }

    public StringBuilder insert(int offset, Object obj)
    {
        return m_stringBuilder.insert(offset, obj);
    }

    public StringBuilder insert(int offset, String str)
    {
        return m_stringBuilder.insert(offset, str);
    }

    public StringBuilder insert(int offset, char[] str)
    {
        return m_stringBuilder.insert(offset, str);
    }

    public StringBuilder insert(int dstOffset, CharSequence s)
    {
        return m_stringBuilder.insert(dstOffset, s);
    }

    public StringBuilder insert(int dstOffset, CharSequence s, int start, int end)
    {
        return m_stringBuilder.insert(dstOffset, s, start, end);
    }

    public StringBuilder insert(int offset, boolean b)
    {
        return m_stringBuilder.insert(offset, b);
    }

    public StringBuilder insert(int offset, char c)
    {
        return m_stringBuilder.insert(offset, c);
    }

    public StringBuilder insert(int offset, int i)
    {
        return m_stringBuilder.insert(offset, i);
    }

    public StringBuilder insert(int offset, long l)
    {
        return m_stringBuilder.insert(offset, l);
    }

    public StringBuilder insert(int offset, float f)
    {
        return m_stringBuilder.insert(offset, f);
    }

    public StringBuilder insert(int offset, double d)
    {
        return m_stringBuilder.insert(offset, d);
    }

    public int indexOf(String str)
    {
        return m_stringBuilder.indexOf(str);
    }

    public int indexOf(String str, int fromIndex)
    {
        return m_stringBuilder.indexOf(str, fromIndex);
    }

    public int lastIndexOf(String str)
    {
        return m_stringBuilder.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex)
    {
        return m_stringBuilder.lastIndexOf(str, fromIndex);
    }

    public StringBuilder reverse()
    {
        return m_stringBuilder.reverse();
    }

    @Override
    public String toString()
    {
        return m_stringBuilder.toString();
    }

    @Override
    public int length()
    {
        return m_stringBuilder.length();
    }

    public int capacity()
    {
        return m_stringBuilder.capacity();
    }

    public void ensureCapacity(int minimumCapacity)
    {
        m_stringBuilder.ensureCapacity(minimumCapacity);
    }

    public void trimToSize()
    {
        m_stringBuilder.trimToSize();
    }

    public void setLength(int newLength)
    {
        m_stringBuilder.setLength(newLength);
    }

    @Override
    public char charAt(int index)
    {
        return m_stringBuilder.charAt(index);
    }

    public int codePointAt(int index)
    {
        return m_stringBuilder.codePointAt(index);
    }

    public int codePointBefore(int index)
    {
        return m_stringBuilder.codePointBefore(index);
    }

    public int codePointCount(int beginIndex, int endIndex)
    {
        return m_stringBuilder.codePointCount(beginIndex, endIndex);
    }

    public int offsetByCodePoints(int index, int codePointOffset)
    {
        return m_stringBuilder.offsetByCodePoints(index, codePointOffset);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
    {
        m_stringBuilder.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    public void setCharAt(int index, char ch)
    {
        m_stringBuilder.setCharAt(index, ch);
    }

    public String substring(int start)
    {
        return m_stringBuilder.substring(start);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return m_stringBuilder.subSequence(start, end);
    }

    public String substring(int start, int end)
    {
        return m_stringBuilder.substring(start, end);
    }

    @Override
    public IntStream chars()
    {
        return m_stringBuilder.chars();
    }

    @Override
    public IntStream codePoints()
    {
        return m_stringBuilder.codePoints();
    }

    public static int compare(CharSequence cs1, CharSequence cs2)
    {
        return CharSequence.compare(cs1, cs2);
    }
}
