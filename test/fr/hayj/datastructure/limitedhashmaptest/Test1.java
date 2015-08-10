package fr.hayj.datastructure.limitedhashmaptest;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.hayj.datastructure.LimitedHashMap;
import fr.hayj.datastructure.limitedlinkedlist.LimitedLinkedList;

public class Test1
{
	@Test
	public void test()
	{
		LimitedHashMap<String, String> map = new LimitedHashMap<String, String>(3);
		map.put("a", "1");
		assertTrue(map.historySize() == 1);
		assertTrue(map.size() == 1);
		map.put("b", "2");
		assertTrue(map.get("c") == null);
		assertTrue(map.get("a") != null);
		assertTrue(map.historySize() == 2);
		map.put("b", "3");
		assertTrue(map.historySize() == 2);
		assertTrue(map.size() == 2);
		map.put("c", "3");
		map.put("d", "4");
		map.put("e", "5");
		assertTrue(map.get("a") == null);
		assertTrue(map.get("c").equals("3"));
		map.put("f", "6");
		map.put("g", "7");
		assertTrue(map.get("g").equals("7"));
		map.put("g", "7");
		map.put("g", "8");
		assertTrue(map.get("d") == null);
		assertTrue(map.get("g").equals("8"));
		assertTrue(map.get("e").equals("5"));
		assertTrue(map.historySize() == 3);
		assertTrue(map.size() == 3);
		map.put("f", "6");
		map.put("g", "7");
		assertTrue(map.get("e").equals("5"));
		assertTrue(map.historySize() == 3);
		assertTrue(map.size() == 3);
		assertTrue(map.get("d") == null);
	}

	@Test
	public void test2()
	{
		LimitedHashMap<String, Integer> list = new LimitedHashMap<String, Integer>(3);
		list.put("a", 1);
		list.put("b", 2);
		list.put("c", 3);
		list.put("d", 4);
		assertTrue(list.size() == 3);
		assertTrue(list.getMax() == 3);
		assertTrue(list.get("b") == 2);
		list.setMax(1);
		assertTrue(list.get("d") == 4);
		assertTrue(list.size() == 1);
		assertTrue(list.getMax() == 1);
		list.setMax(10);
		list.put("a", 1);
		list.put("b", 1);
		list.put("c", 1);
		list.put("d", 1);
		list.put("e", 1);
		list.put("f", 1);
		list.put("g", 1);
		list.put("h", 1);
		list.put("i", 1);
		list.put("a", 1);
		assertTrue(list.size() == 9);
		assertTrue(list.getMax() == 10);
		list.setMax(5);
		assertTrue(list.size() == 5);
		assertTrue(list.getMax() == 5);
		assertTrue(list.get("a") == 1);
		assertTrue(list.get("i") == 1);
		assertTrue(list.get("b") == null);
	}
}
