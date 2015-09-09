package fr.hayj.datastructure.headedlinkedlisttest;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.hayj.datastructure.headedlinkedlist.HeadedLinkedList;

public class Test1
{
	@Test
	public void test1()
	{
		HeadedLinkedList<Integer> list = new HeadedLinkedList<Integer>();
		assertTrue(list.size() == 0);
		list.put(15);
		assertTrue(list.size() == 1);
		list.put(20);
		assertTrue(list.size() == 2);
	}
}
