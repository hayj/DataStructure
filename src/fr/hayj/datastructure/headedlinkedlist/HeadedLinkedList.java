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

	public int size()
	{
		if(this.isEmpty())
			return 0;
		Node currentNode = head;
		int size = 1;
		while(currentNode.next != null)
		{
			size++;
			currentNode = currentNode.next;
		}
		return size;
	}
}