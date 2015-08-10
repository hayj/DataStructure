package fr.hayj.datastructure.limitedlinkedlisttest;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.hayj.datastructure.limitedlinkedlist.LimitedLinkedList;

public class Test1
{
	@Test
	public void test1()
	{
		LimitedLinkedList<String> list = new LimitedLinkedList<String>(3);
		list.push("");
		list.push("");
		list.push("");
		list.push("a");
		list.push("");
		list.push("test");
		String a = list.push("");
		list.removeOneFromLast("test");
		assertTrue(list.size() == 2);
		assertTrue(a.equals("a"));
	}
	
	@Test
	public void test2()
	{
		LimitedLinkedList<String> list = new LimitedLinkedList<String>(3);
		list.push("a");
		list.push("b");
		list.push("c");
		list.push("d");
		assertTrue(list.size() == 3);
		assertTrue(list.getMax() == 3);
		assertTrue(list.removeLast().equals("b"));
		assertTrue(list.size() == 2);
		assertTrue(list.getMax() == 3);
		list.setMax(1);
		assertTrue(list.removeLast().equals("d"));
		assertTrue(list.size() == 0);
		assertTrue(list.getMax() == 1);
		list.setMax(10);
		list.push("a");
		list.push("a");
		list.push("a");
		list.push("a");
		list.push("a");
		list.push("a");
		list.push("a");
		list.push("a");
		list.push("a");
		list.push("a");
		assertTrue(list.size() == 10);
		assertTrue(list.getMax() == 10);
		list.setMax(5);
		assertTrue(list.size() == 5);
		assertTrue(list.getMax() == 5);
		assertTrue(list.removeLast().equals("a"));
		assertTrue(list.removeLast().equals("a"));
		assertTrue(list.removeLast().equals("a"));
		assertTrue(list.removeLast().equals("a"));
		assertTrue(list.removeLast().equals("a"));
		assertTrue(list.removeLast() == null);
	}
}