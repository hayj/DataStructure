package fr.hayj.datastructure;

import java.util.HashMap;

import fr.hayj.datastructure.limitedlinkedlist.LimitedLinkedList;

/**
 * A HashMap which store a specified max number of values.
 * @author hayj
 *
 * @param <K>
 * @param <V>
 */
public class LimitedHashMap<K, V>
{
	private HashMap<K, V> map = new HashMap<K, V>();
	private int max;
	private LimitedLinkedList<K> list;
	private static final int DEFAULT_MAX = 10000;

	public LimitedHashMap()
	{
		this.init(DEFAULT_MAX); // Defaults
	}

	public LimitedHashMap(int max)
	{
		this.init(max);
	}

	private void init(int max)
	{
		this.max = max;
		this.list = new LimitedLinkedList<K>(this.max);
	}

	public synchronized V put(K key, V value)
	{
		// Put the new value :
		V replacedValue = this.map.put(key, value);
		if(replacedValue != null)
		{
			this.list.removeOneFromLast(key);
		}

		// Remove history according to max :
		K toRemoveHistory = this.list.push(key);
		if(toRemoveHistory != null)
			this.map.remove(toRemoveHistory);

		return replacedValue;
	}

	public synchronized V get(K key)
	{
		return this.map.get(key);
	}

	public int size()
	{
		return this.map.size();
	}

	public int historySize()
	{
		return this.list.size();
	}
	
	public String toString()
	{
		return this.list.toString();
	}
}
