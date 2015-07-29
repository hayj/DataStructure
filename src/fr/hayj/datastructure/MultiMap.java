package fr.hayj.datastructure;


import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * A map which supports multiple values per key.
 * 
 * @author hayj
 */
public class MultiMap<K, V>
{
	private final HashMap<K, LinkedList<WeakReference<V>>> map;

	public MultiMap()
	{
		map = new HashMap<K, LinkedList<WeakReference<V>>>();
	}

	public void clear()
	{
		map.clear();
	}

	@Override
	public int hashCode()
	{
		return map.hashCode();
	}

	public void put(K key, V value)
	{
		LinkedList<WeakReference<V>> list = null;
		if(!map.containsKey(key))
			map.put(key, list = new LinkedList<WeakReference<V>>());
		else
			list = map.get(key);
		list.add(new WeakReference<V>(value));
	}

	public LinkedList<WeakReference<V>> values()
	{
		LinkedList<WeakReference<V>> list = new LinkedList<WeakReference<V>>();
		for(LinkedList<WeakReference<V>> currentList : this.map.values())
			list.addAll(currentList);
		return list;
	}
}