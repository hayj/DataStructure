package fr.hayj.datastructure;

import java.util.ArrayList;

import fr.hayj.datastructure.headedlinkedlist.HeadedLinkedList;
import fr.hayj.datastructure.headedlinkedlist.Node;

/**
 * This stack can store objects sorted according to an order. The order must be
 * short (1 to 100) and not function of the data bulk. For each order, a
 * LinkedList allows a O(1) pop and a O(1) put. Each pop return the shortest
 * order (and latest put element).
 * 
 * @author hayj
 */
public class ShortSortedStack<T> implements Comparable<T>
{
	ArrayList<HeadedLinkedList<T>> list;
	private int max;

	public ShortSortedStack(int max)
	{
		if(max < 1)
			max = 1;
		this.max = max;
		list = new ArrayList<HeadedLinkedList<T>>();
		for(int i = 0 ; i < this.max ; i++)
			list.add(new HeadedLinkedList<T>());
	}

	/**
	 * @return return the first element in the min order
	 */
	public T pop()
	{
		for(int i = 0 ; i < this.list.size() ; i++)
		{
			HeadedLinkedList<T> currentList = this.list.get(i);
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
		for(HeadedLinkedList<T> currentList : list)
		{
			if(!currentList.isEmpty())
				return false;
		}
		return true;
	}

	/**
	 * Insert an object according to an order
	 * @param o
	 * @param order
	 */
	public void push(T o, int order)
	{
		// if(order > max)
		// throw....
		this.list.get(order).put(o);
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

	/**
	 * @return return the current min order.
	 */
	public int getMin()
	{
		for(int min = 0 ; min < this.list.size() ; min++)
		{
			if(!this.list.get(min).isEmpty())
				return min;
		}
		return Integer.MAX_VALUE;
	}

	public T peek()
	{
		for(int i = 0 ; i < this.list.size() ; i++)
		{
			HeadedLinkedList<T> currentList = this.list.get(i);
			if(!currentList.isEmpty())
			{
				Node<T> head = currentList.head;
				return head.value;
			}
		}
		return null;
	}

	/**
	 * @return return all elements which match with the min order.
	 */
	public java.util.LinkedList<T> toLinkedListMin()
	{
		return toLinkedList(this.getMin());
	}	

/**
 * @return return all elements which match with the specified order.
 */
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

/**
 * @return return all elements which match with the specified order.
 */
	public java.util.LinkedList<T> toLinkedList()
	{
		java.util.LinkedList<T> concat = new java.util.LinkedList<T>();
		for(int i = 0 ; i < this.list.size() ; i++)
		{
			concat.addAll(toLinkedList(i));
		}
		return concat;
	}
}
