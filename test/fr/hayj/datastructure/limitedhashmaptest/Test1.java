package fr.hayj.datastructure.limitedhashmaptest;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.hayj.datastructure.LimitedHashMap;

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
}
