package fr.hayj.datastructure.integerarraytest;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.hayj.datastructure.IntegerArray;

public class Test1
{
	@Test
	public void test1()
	{
		IntegerArray array = new IntegerArray();
		array.add(1);
		array.add(2);
		array.add(3);
		
		assertTrue(array.min() == 1);
		assertTrue(array.max() == 3);
		assertTrue(array.sum() == 6);
	}
	
	@Test
	public void test2()
	{
		IntegerArray array = new IntegerArray();
		array.add(1);
		
		assertTrue(array.min() == 1);
		assertTrue(array.max() == 1);
		assertTrue(array.sum() == 1);
	}
	
	@Test
	public void test3()
	{
		IntegerArray array = new IntegerArray();
		array.add(3);
		array.add(1);
		array.add(2);
		
		assertTrue(array.min() == 1);
		assertTrue(array.max() == 3);
		assertTrue(array.sum() == 6);
	}	
	@Test
	public void size()
	{
		IntegerArray array = new IntegerArray();
		assertTrue(array.size() == 0);
		array.add(3);
		assertTrue(array.size() == 1);
		array.add(1);
		array.add(2);
		assertTrue(array.size() == 3);
		assertTrue(array.min() == 1);
		assertTrue(array.max() == 3);
		assertTrue(array.sum() == 6);
	}
}
