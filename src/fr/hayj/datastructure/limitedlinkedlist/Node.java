package fr.hayj.datastructure.limitedlinkedlist;

public class Node<T>
{
	public Node<T> next;
	public Node<T> previous;
	public T value;

	@Override
	public String toString()
	{
		return "Node [value=" + value + "]";
	}
}