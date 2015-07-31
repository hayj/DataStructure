package fr.hayj.datastructure;

import fr.hayj.datastructure.headedlinkedlist.HeadedLinkedList;
import fr.hayj.datastructure.headedlinkedlist.Node;

public class IntegerArray implements Cloneable
{
	HeadedLinkedList<Integer> list = new HeadedLinkedList<Integer>();
	
	public void add(int value)
	{
		list.put(value);
	}
	
	public int sum()
	{
		int sum = 0;
		Node<Integer> currentNode = this.list.head;
		while(currentNode != null)
		{
			sum += currentNode.value;
			currentNode = currentNode.next;
		}
		return sum;
	}
	
	
	public Integer min()
	{
		Integer min = null;
		if(this.list.isEmpty())
			return min;
		min = this.list.head.value;
		Node<Integer> currentNode = this.list.head.next;
		while(currentNode != null)
		{
			if(currentNode.value < min)
				min = currentNode.value;
			currentNode = currentNode.next;
		}
		return min;
	}
	
	public Integer max()
	{
		Integer max = null;
		if(this.list.isEmpty())
			return max;
		max = this.list.head.value;
		Node<Integer> currentNode = this.list.head.next;
		while(currentNode != null)
		{
			if(currentNode.value > max)
				max = currentNode.value;
			currentNode = currentNode.next;
		}
		return max;
	}
	
	@Override
	public Object clone()
	{
		IntegerArray clone = new IntegerArray();
		Node<Integer> currentNode = this.list.head;
		while(currentNode != null)
		{
			clone.add(currentNode.value);
			currentNode = currentNode.next;
		}
		return clone;
	}
}
