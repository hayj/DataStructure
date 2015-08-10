package fr.hayj.datastructure.limitedlinkedlist;

public class LimitedLinkedList<T>
{
	Node<T> first;
	Node<T> last;
	private int max;
	private int size = 0;

	public LimitedLinkedList(int max)
	{
		this.max = max;
	}

	/**
	 * Return add remove the last element if the list is full
	 * 
	 * @param object
	 * @return
	 */
	public T push(T object)
	{
		this.addFirst(object);
		if(this.size > this.max)
			return this.removeLast();
		return null;
	}

	private void addFirst(T object)
	{
		Node<T> toAdd = new Node<T>();
		toAdd.value = object;
		if(this.size > 1)
		{
			toAdd.next = this.first;
			this.first.previous = toAdd;
			this.first = toAdd;
		}
		else if(this.size == 1)
		{
			toAdd.next = this.first;
			this.first.previous = toAdd;
			this.first = toAdd;
			this.last = toAdd.next;
		}
		else
		{
			this.first = toAdd;
		}
		size++;
	}

	public T removeLast()
	{
		T removedValue;
		if(this.size > 1)
		{
			Node<T> oldLast = this.last;
			this.last = oldLast.previous;
			this.last.next = null;
			removedValue = oldLast.value;
		}
		else if(this.size == 1)
		{
			Node<T> oldLast = this.first;
			this.first = null;
			removedValue = oldLast.value;
		}
		else
		{
			removedValue = null;
		}
		size--;
		return removedValue;
	}

	public boolean isEmpty()
	{
		return this.size == 0;
	}

	public void removeOneFromLast(T value)
	{
		if(this.size == 1)
		{
			if(this.first.value.equals(value))
			{
				this.size = 0;
				this.first = null;
			}
		}
		else if(this.size == 2)
		{
			if(this.last.value.equals(value))
			{
				this.first.next = null;
			}
			else if(this.first.value.equals(value))
			{
				this.last.previous = null;
				this.first = this.last;
				this.last = null;
			}
			this.size--;
		}
		else if(this.size > 2)
		{
			Node<T> currentNode = this.last;
			do
			{
				if(currentNode.value.equals(value))
				{
					if(currentNode.equals(this.last))
					{
						Node<T> oldLast = this.last;
						this.last = oldLast.previous;
						this.last.next = null;
					}
					else if(currentNode.equals(this.first))
					{
						this.first = this.first.next;
						this.first.previous = null;
					}
					else
					{
						Node<T> previous = currentNode.previous;
						Node<T> next = currentNode.next;
						previous.next = next;
						next.previous = previous;
					}
					this.size--;
					break;
				}
			} while((currentNode = currentNode.previous) != null);
		}
	}

	public int size()
	{
		return this.size;
	}

	public String toString()
	{
		if(this.size == 0)
			return "Empty list";
		String str = "";
		str += "First : " + this.first.toString();

		if(this.last != null)
		{
			str += "\n";
			str += "Last : " + this.last.toString();
		}
		if(this.size > 2)
		{
			str += "\n";
			Node<T> currentNode = this.first;
			str += "Nodes : ";
			while(currentNode != null)
			{
				str += currentNode.value.toString() + ", ";
				currentNode = currentNode.next;
			}
			str = str.substring(0, str.length() - 2);
		}
		return str + "\n";
	}

	public void setMax(int max)
	{
		if(max > 0)
		{
			while(this.size() > max)
				this.removeLast();
			this.max = max;
		}
	}

	public int getMax()
	{
		return this.max;
	}
}