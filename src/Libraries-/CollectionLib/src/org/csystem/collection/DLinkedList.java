package org.csystem.collection;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

public class DLinkedList<T> implements Iterable<T> {
	private int m_size;
	private Node m_head, m_tail;
	
	private class Node{
		T Item;
		Node Next, Prev;
		
		public Node(T item)
		{
			Item = item;
		}
	}
	
	private class ListIterator implements Iterator<T> {
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
	
	private class ListReverseIterator implements Iterator<T> {
		private Node m_curNode;
		
		public boolean hasNext() 
		{
			m_curNode = m_curNode == null ? m_tail : m_curNode.Prev;
			
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
		
		if (m_head != null) {
			m_head.Prev = node;
			node.Next = m_head;
			m_head = node;
		}			
		else
			m_head = m_tail = node;
		
		++m_size;		
	}
	
	public void addItemTail(T item)
	{
		Node node = new Node(item);
		
		if (m_head != null) {
			m_tail.Next = node;
			node.Prev = m_tail;
			m_tail = node;
		}
		else 
			m_head = m_tail = node;
		
		++m_size;			
	}	
	
	public void clear()
	{
		if (m_head == null)
			return;

		for (var node = m_head.Next; node != null; node = node.Next)
			node.Prev = null;

		m_head = m_tail = null;

		m_size = 0;
	}
	
	public void deleteItem(int pos)
	{
		if (pos >= m_size || pos < 0 || m_head == null)
			return;
		
		if (pos == 0)
			deleteItemHead();
		else if(pos == m_size - 1)
			deleteItemTail();
		else {
			Node curNode = m_head;
			
			for(int i = 0; i < pos; i++, curNode = curNode.Next)
				;
			
			curNode.Prev.Next = curNode.Next;
			curNode.Next.Prev = curNode.Prev;
			
			--m_size;
		}
	}
	
	public void deleteItemHead()
	{
		if (m_head == null)
			return;
		
		if (m_head == m_tail) // size==1
			m_head = m_tail = null;
		else {
			m_head = m_head.Next;
			m_head.Prev = null;
		}
		
		m_size--;		
	}
	
	public void deleteItemTail()
	{
		if (m_head == null)
			return;
		
		if (m_head == m_tail) // size==1
			m_head = m_tail = null;
		else {
			m_tail = m_tail.Prev;
			m_tail.Next = null;
		}
		m_size--;
	}
	
	public boolean empty() {return m_head == null;}
	
	public Optional<T> get(int pos)
	{
		if (m_head == null || pos < 0 || pos >= m_size)
			return Optional.empty();
		
		Node curNode = m_head;
		
		for(int i = 1; i <= pos; i++, curNode = curNode.Next)
			;
		
		return Optional.of(curNode.Item);
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
	
	public int indexOf(T item)
	{
		if (m_head == null)
			return -1;

		Node curNode = m_head;	
		
		if (item != null) {
			for(int i = 0; i < m_size; curNode = curNode.Next, i++)
				if (item.equals(curNode.Item))
					return i;
		}
		else
			for(int i = 0; i < m_size; curNode = curNode.Next, i++)
				if (curNode.Item == null)
					return i;	
		
		return -1;
	}
	
	public void insertItem(int pos, T item)
	{
		if (pos > m_size || pos < 0)
			throw new IndexOutOfBoundsException("Invalid position");
		
		if (m_head != null){
			if (pos == 0)
				addItemHead(item);
			else if(pos == m_size)
				addItemTail(item);
			else {
				Node curNode = m_head;
				
				for(int i = 1; i <= pos - 1; i++, curNode = curNode.Next)
					;
				
				var node = new Node(item);
				
				node.Next = curNode.Next;
				node.Prev = curNode;
				curNode.Next = node;
				node.Next.Prev = node;				
				m_size++;
			}
		}
		else
			addItemTail(item);

	}
	
	public Iterator<T> iterator()
	{
		return new ListIterator();		
	}
	
	public Iterator<T> reverseIterator()
	{
		return new ListReverseIterator();
	}
	
	public int lastIndexOf(T item)
	{
		if(m_head == null)
			return -1;

		Node curNode = m_tail;
		
		int i = m_size - 1;
		
		for(; i >= 0; curNode = curNode.Prev, i--) {
			if (item == null && curNode.Item == null)
				return i;
			
			if(curNode.Item != null && curNode.Item.equals(item))
				return i;			
		}	
		
		return -1;
	}
	
	public int size() {return m_size;}	
	
	public void walkReverse(Consumer<T> con)
	{
		for (Node node = m_tail; node != null; node = node.Prev)
			con.accept(node.Item);
	}
	
	public void walk(Consumer<T> con)
	{
		for (var node = m_head; node != null; node = node.Next)
			con.accept(node.Item);
	}
}
