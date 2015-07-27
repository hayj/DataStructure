package fr.hayj.datastructure;

import java.util.ArrayList;

import fr.hayj.datastructure.simplelinkedlist.LinkedList;
import fr.hayj.datastructure.simplelinkedlist.Node;

/**
 * This stack can handle a 
 * @author julien
 *
 * @param <T>
 */
public class ShortSortedStack<T> implements Comparable<T>
{
	ArrayList<LinkedList<T>> list;
	private int max;

	public ShortSortedStack(int max)
	{
		if(max < 1)
			max = 1;
		this.max = max;
		list = new ArrayList<LinkedList<T>>();
		for(int i = 0 ; i < this.max ; i++)
			list.add(new LinkedList<T>());
	}

	public T pop()
	{
		for(int i = 0 ; i < this.list.size() ; i++)
		{
			LinkedList<T> currentList = this.list.get(i);
			if(!currentList.isEmpty())
			{
				Node<T> head = currentList.head;
				currentList.head = head.next;
				return head.value;
			}
		}
		return null;
	}

	public boolean isEmpty()
	{
		for(LinkedList<T> currentList : list)
		{
			if(!currentList.isEmpty())
				return false;
		}
		return true;
	}

	public void push(T o, int order)
	{
		// if(order > max)
		// throw....
		this.list.get(order).insert(o);
	}

	@Override
	public int compareTo(Object o)
	{
		ShortSortedStack<?> stack = (ShortSortedStack<?>) o;
		int currentMin = this.getMin();
		int otherMin = stack.getMin();
		if(currentMin == otherMin)
			return 0;
		else if(currentMin < otherMin)
			return -1;
		else
			return 1;
	}

	public int getMin()
	{
		for(int min = 0 ; min < this.list.size() ; min++)
		{
			if(!this.list.get(min).isEmpty())
				return min;
		}
		return Integer.MAX_VALUE;
	}

	public T pick()
	{
		for(int i = 0 ; i < this.list.size() ; i++)
		{
			LinkedList<T> currentList = this.list.get(i);
			if(!currentList.isEmpty())
			{
				Node<T> head = currentList.head;
				return head.value;
			}
		}
		return null;
	}

	public java.util.LinkedList<T> toLinkedList(int order)
	{
		java.util.LinkedList<T> concat = new java.util.LinkedList<T>();
		Node<T> currentNode = this.list.get(order).head;
		while(currentNode != null)
		{
			concat.add(currentNode.value);
			currentNode = currentNode.next;
		}
		return concat;
	}
	
	public java.util.LinkedList<T> toLinkedList()
	{
		java.util.LinkedList<T> concat = new java.util.LinkedList<T>();
		for(int i = 0 ; i < this.list.size(); i++)
		{
			concat.addAll(toLinkedList(i));
		}
		return concat;
	}
}
