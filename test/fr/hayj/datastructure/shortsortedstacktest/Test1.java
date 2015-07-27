package fr.hayj.datastructure.shortsortedstacktest;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.hayj.datastructure.ShortSortedStack;

public class Test1
{
	@Test
	public void test1()
	{
		ShortSortedStack<String> stack = new ShortSortedStack<String>(3);
		stack.push("ccc", 2);
		stack.push("aaa", 0);
		stack.push("bbb", 1);
		String o = (String) stack.pop();
		o = (String) stack.pop();
		o = (String) stack.pop();
		assertTrue(o.equals("ccc"));
	}
	
	@Test
	public void test2()
	{
		ShortSortedStack<String> stack = new ShortSortedStack<String>(3);
		stack.push("ccc", 2);
		stack.push("aaa", 0);
		stack.push("aaa", 0);
		stack.push("aaa", 0);
		stack.push("aaa", 0);
		stack.push("bbb", 1);
		String o = (String) stack.pop();
		o = (String) stack.pop();
		o = (String) stack.pop();
		assertTrue(o.equals("aaa"));
		o = (String) stack.pop();
		o = (String) stack.pop();
		o = (String) stack.pop();
		o = (String) stack.pop();
		o = (String) stack.pop();
		o = (String) stack.pop();
		o = (String) stack.pop();
		o = (String) stack.pop();
		assertTrue(o == null);
	}
}
