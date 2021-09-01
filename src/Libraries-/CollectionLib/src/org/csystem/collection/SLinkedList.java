package org.csystem.collection;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

public class SLinkedList<T> implements Iterable<T> {
	private int m_size;
	private Node m_head, m_tail;
	
	private class Node {
		T Item;	
		Node Next;
		
		public Node(T item)
		{
			Item = item;
		}
	}
	
	private class ListIterator  implements Iterator<T> {
		private Node m_curNode;
		
		public boolean hasNext()
		{			
			m_curNode = m_curNode == null ? m_head : m_curNode.Next;
			
			return m_curNode != null;
		}
 		
		public T next()
		{
			return m_curNode.Item;					
		}
	}
	
	public void addItemHead(T item)
	{
		Node node = new Node(item);
		
		if (m_head == null) //is linked list empty?
			m_head = m_tail = node;
		else {
			node.Next = m_head;
			m_head = node;
		}
		++m_size;
	}
	
	public void addItemTail(T item)
	{
		Node node = new Node(item);
		
		if (m_head == null) 
			m_head = m_tail = node;
		else {
			m_tail.Next = node;
			m_tail = node;
		}
		++m_size;
	}
	
	public void clear()
	{
		m_head = m_tail = null;		
		m_size = 0;
	}
	
	public void deleteItem(int pos)
	{
		if (pos < 0 || pos >= m_size)
			return;
		
		if (m_head == null)
			return;
		
		if (pos == 0) 
			deleteItemHead();
		else if (pos == m_size - 1)
			deleteItemTail();
		else {
			Node node = m_head;			

			for (int i = 0; i < pos - 1; node = node.Next, ++i)
				;			
			
			node.Next = node.Next.Next;			
			--m_size;
		}
	}
		
	public void deleteItemHead()
	{
		if (m_head == null)
			return;
		
		if (m_size == 1)
			m_tail = null;
		
		m_head = m_head.Next;
		--m_size;
	}	
	
	public void deleteItemTail()
	{
		if (m_head == null)
			return;
		
		if (m_size != 1) {			
			Node node = m_head;
		
			for (; node.Next.Next != null; node = node.Next)
				;		
		
			node.Next = null;
			m_tail = node;
		}
		else
			m_head = m_tail = null;
		
		--m_size;
	}
	
	public boolean empty() {return m_head == null;}
	
	public boolean insertItem(int pos, T item)
	{
		if (pos < 0 || pos > m_size)
			return false;		
		
		if (m_head != null) {
			if (pos != 0) {
				Node curNode = m_head; 
				
				for (int i = 1; i <= pos - 1; ++i) //pos dan bir önceki düğüm
					curNode = curNode.Next;
				
				Node node = new Node(item);
				
				node.Next = curNode.Next;
				curNode.Next = node;
				++m_size;
			}
			else
				addItemHead(item);
		}
		else
			addItemTail(item);
		
		return true;
	}
	
	public int indexOf(T item)
	{
		int index = 0;		
		
		if (item != null) {
			for (var node = m_head; node != null; node = node.Next, ++index)
				if (item.equals(node.Item))
					return index;
		}		
		else			
			for (Node node = m_head; node != null; node = node.Next, ++index)
				if (node.Item == null)
					return index;
		
		return -1;		
	}
	
	public Iterator<T> iterator()
	{
		return new ListIterator();						
	}
	
	public int size() {return m_size;}
	
	public Optional<T> get(int pos)
	{
		if (m_head == null || pos < 0 || pos >= m_size)
			return Optional.empty();
		
		int i = 0;
		
		Node node = m_head;
		
		for (; i < pos; node = node.Next, ++i)
			;
		
		return Optional.of(node.Item);
	}
	
	public Optional<T> getItemHead()
	{
		if (empty())
			return Optional.empty();
		
		return Optional.of(m_head.Item);
	}
	public Optional<T> getItemTail()
	{
		if (empty())
			return Optional.empty();
		
		return Optional.of(m_tail.Item);
	}
	
	public Optional<T> getReverse(int n) //Sondan n-inci elemanı bulacak
	{
		return get(m_size - n);

		/*
		//m_size tutulmamışsa (mulakat sorusu)
		Node curNode = m_head;

		for (var node = m_head; node != null; node = node.Next) {
			n--;

			if (n < 0)
				curNode = curNode.Next;
		}

		return n >= 0 ? Optional.empty() : Optional.of(curNode.Item);
		*/
	}
	
	public void walk(Consumer<T> con)
	{
		for (var node = m_head; node != null; node = node.Next) //Traverse
			con.accept(node.Item);
	}	
}