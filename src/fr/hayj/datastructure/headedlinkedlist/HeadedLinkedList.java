package fr.hayj.datastructure.headedlinkedlist;

public class HeadedLinkedList<T>
{
	public Node<T> head;

	public void put(T o)
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