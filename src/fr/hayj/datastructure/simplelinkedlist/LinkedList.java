package fr.hayj.datastructure.simplelinkedlist;

import fr.hayj.datastructure.simplelinkedlist.Node;

public class LinkedList<T>
{
	public Node<T> head;

	public void insert(T o)
	{
		Node<T> n = new Node<T>();
		n.value = o;
		n.next = this.head;
		this.head = n;
	}

	public boolean isEmpty()
	{
		return this.head == null;
	}
}