package fr.hayj.datastructure.stringtreetest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.junit.Test;

import fr.hayj.datastructure.StringTree;
import fr.hayj.datastructure.StringTree.Node;

public class Test1
{
	@Test
	public void test1()
	{
		String separator = "[ -,]";
		ArrayList<String> vocArray = new ArrayList<String>();
		vocArray.add("a b");
		vocArray.add("b");
		vocArray.add("a c");
		vocArray.add("c");
		vocArray.add("c d e");

		// Make a tree from the dictionary :
		StringTree stringTree = new StringTree();
		for(String vocElement : vocArray)
		{
			String[] tokens = vocElement.split(separator);
			stringTree.insert(tokens);
		}

		assertTrue(stringTree.getRoot().getChild("b").getChildren().isEmpty());
		assertTrue(!stringTree.getRoot().getChild("a").getChildren().isEmpty());
		String rootString = "";
		for(Entry<String, Node> entry : stringTree.getRoot().getChildren().entrySet())
			rootString += entry.getKey() + " ";
		assertTrue(rootString.equals("a b c "));
		assertTrue(stringTree.getRoot().getChild("c").getChild("d").getChild("e").isEndNode());
		assertTrue(!stringTree.getRoot().getChild("a").isEndNode());
		assertTrue(stringTree.getRoot().getChild("c").isEndNode());
	}

	@Test
	public void test2()
	{
		String separator = "[ -,]";
		ArrayList<String> vocArray = new ArrayList<String>();
		vocArray.add("c");
		vocArray.add("c");
		vocArray.add("c");
		vocArray.add("c");
		vocArray.add("c ");

		// Make a tree from the dictionary :
		StringTree stringTree = new StringTree();
		for(String vocElement : vocArray)
			stringTree.insert(vocElement, separator);
		
		assertTrue(stringTree.getRoot().getChild("c").isEndNode());
		assertTrue(stringTree.getRoot().getChild("c").getChildren().size() == 0);
		assertTrue(stringTree.getRoot().getChildren().size() == 1);
	}
}
