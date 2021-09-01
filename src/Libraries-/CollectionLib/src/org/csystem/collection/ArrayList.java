package org.csystem.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements Iterable<T> {
    private static final boolean DEBUG = false;

    private static final int DEFAULT_CAPACITY = 10;
    private T [] m_elems;
    private int m_index;

    private void allocateCapacity(int capacity)
    {
        if (DEBUG) {
            assert capacity > m_elems.length: "Invalid capacity value";
        }

        @SuppressWarnings("unchecked")
        T [] temp = (T[])new Object[capacity];

        for (int i = 0; i < m_index; ++i)
            temp[i] = m_elems[i];

        m_elems = temp;
    }

    public ArrayList()
    {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity)
    {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Invalid capacity");

        m_elems = (T[])new Object[initialCapacity == 0 ? DEFAULT_CAPACITY : initialCapacity]; //uyarı görmezden gelinecek
    }

    public int capacity() {return m_elems.length;}
    public int size() {return m_index;}

    public void add(T elem)
    {
        if (m_index == m_elems.length)
            this.allocateCapacity(m_elems.length * 2);

        m_elems[m_index++] = elem;
    }

    public void add(int index, Object elem)
    {
        //TODO:Ellerinizden öper
    }

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public int indexOf(T elem)
    {
        if (elem != null) {
            for (int i = 0; i < m_index; ++i)
                if (m_elems[i].equals(elem))
                    return i;
        }
        else {
            for (int i = 0; i < m_index; ++i)
                if (m_elems[i] == null)
                    return i;
        }

        return -1;
    }

    public T get(int index)
    {
        if (index < 0 || index >= m_index)
            throw new IndexOutOfBoundsException("index < 0 || index >= size()");

        return m_elems[index];
    }

    public Object remove(int index)
    {
        //TODO:Ellerinizden öper

        return null;
    }

    public Object set(int index, T elem)
    {
        if (index < 0 || index >= m_index)
            throw new IndexOutOfBoundsException("index < 0 || index >= size()");

        Object oldElem = m_elems[index];

        m_elems[index] = elem;

        return oldElem;
    }

    public void trimToSize()
    {
        this.allocateCapacity(m_index == 0 ? DEFAULT_CAPACITY : m_index);
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>() {
            private int m_curIndex = -1;
            @Override
            public boolean hasNext()
            {
                return m_curIndex + 1 < m_index;
            }

            @Override
            public T next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No element");

                return m_elems[++m_curIndex];
            }
        };
    }
}
