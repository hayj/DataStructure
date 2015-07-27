package fr.hayj.datastructure.limitedlinkedlisttest;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.hayj.datastructure.limitedlinkedlist.LimitedLinkedList;

public class Test1
{
	@Test
	public void test()
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
}
