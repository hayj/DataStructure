package fr.hayj.datastructure.trietest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import fr.hayj.datastructure.trie.Trie;
import fr.hayj.datastructure.trie.Node;
import fr.hayj.datastructure.trie.Trie.Tokenizable;

public class Test1
{
	@Test
	public void test1()
	{
		String[] texts = { "aa", "bb", "ab", "aa t", "a t" };
		Trie trie = this.getTokArray(texts);
		Node node = trie.getRoot();
		node = node.getChild('a');
		assertTrue(node.childrenSize() == 2);
		assertTrue(node.isEndToken() == true);
		assertTrue(node.isEndTokenizable() == false);
		node = node.getChild('a');
		assertTrue(node.childrenSize() == 0);
		assertTrue(node.isEndToken() == true);
		assertTrue(node.isEndTokenizable() == true);
	}

	@Test
	public void test2()
	{
		String[] texts = { "aa", "bb", "bb a", "aa a", "aa a c", "aa b c", "aa a d", "ac", "ab", "cc" };
		Trie trie = this.getTokArray(texts);

		// From root :
		Node node = trie.getRoot();
		assertTrue(node.childrenSize() == 3);
		assertTrue(node.isEndToken() == false);
		assertTrue(node.isEndTokenizable() == false);
		node = node.getChild('b');
		assertTrue(node.childrenSize() == 1);
		assertTrue(node.isEndToken() == false);
		assertTrue(node.isEndTokenizable() == false);
		node = node.getChild('b');
		assertTrue(node.childrenSize() == 0);
		assertTrue(node.isEndToken() == true);
		assertTrue(node.isEndTokenizable() == true);

		// New trie :
		node = node.getSubTrie().getRoot();
		assertTrue(node.childrenSize() == 1);
		assertTrue(node.isEndToken() == false);
		assertTrue(node.isEndTokenizable() == false);
		assertTrue(node.getChild('b') == null);
		node = node.getChild('a');
		assertTrue(node.childrenSize() == 0);
		assertTrue(node.isEndToken() == true);
		assertTrue(node.isEndTokenizable() == true);

		// From root :
		node = trie.getRoot().getChild('a');
		assertTrue(node.childrenSize() == 3);
		assertTrue(node.isEndToken() == false);
		assertTrue(node.isEndTokenizable() == false);
		node = node.getChild('a');
		assertTrue(node.childrenSize() == 0);
		assertTrue(node.isEndToken() == true);
		assertTrue(node.isEndTokenizable() == true);
		assertTrue(node.hasSubTrie() == true);
		
		// New trie :
		node = node.getSubTrie().getRoot();
		assertTrue(node.childrenSize() == 2);
		assertTrue(node.isEndToken() == false);
		assertTrue(node.isEndTokenizable() == false);
		assertTrue(node.hasSubTrie() == false);
		node = node.getChild('a');
		assertTrue(node.childrenSize() == 0);
		assertTrue(node.isEndToken() == true);
		assertTrue(node.isEndTokenizable() == true);
		assertTrue(node.hasSubTrie() == true);
		
		// New trie :
		node = node.getSubTrie().getRoot();
		assertTrue(node.childrenSize() == 2);
		assertTrue(node.isEndToken() == false);
		assertTrue(node.isEndTokenizable() == false);
		assertTrue(node.hasSubTrie() == false);
		node = node.getChild('d');
		assertTrue(node.childrenSize() == 0);
		assertTrue(node.isEndToken() == true);
		assertTrue(node.isEndTokenizable() == true);
		assertTrue(node.hasSubTrie() == false);

		// From root :
		node = trie.getRoot().getChild('c').getChild('c');
		assertTrue(node.childrenSize() == 0);
		assertTrue(node.isEndToken() == true);
		assertTrue(node.isEndTokenizable() == true);
	}
	
	@Test
	public void testTrieSize()
	{
		String[] texts = { "aa", "bb", "bb a", "aa a", "aa a c", "aa b c", "aa a d", "ac", "ab", "cc", "cc r" };
		Trie trie = this.getTokArray(texts);
		
		assertTrue(trie.size() == texts.length);
		assertTrue(trie.getRoot().size() == texts.length);
		assertTrue(trie.getRoot().getChild('a').size() == 7);
		assertTrue(trie.getRoot().getChild('a').getChild('a').getSubTrie().size() == 4);
		assertTrue(trie.getRoot().getChild('a').getChild('c').hasSubTrie() == false);
		assertTrue(trie.getRoot().getChild('c').getChild('c').getSubTrie().size() == 1);
		
		
		assertTrue(trie.getTokenizables().size() == texts.length);
		assertTrue(trie.getRoot().getChild('a').getChild('a').getLeaves().size() == 1);
		assertTrue(trie.getRoot().getChild('a').getChild('a').getSubTrie().getTokenizables().size() == 4);
		assertTrue(trie.getRoot().getChild('c').getChild('c').getSubTrie().getRoot().getChild('r').getLeaves().size() == 1);
		assertTrue(trie.getRoot().getChild('c').getChild('c').getSubTrie().getRoot().getChild('r').getLeaves().size() == 1);
		assertTrue(trie.getRoot().getChild('c').getChild('c').getSubTrie().getRoot().getChild('r').getLeaves().get(0).getFirstTokenizable().getText().equals("cc r"));
	}

	private Trie getTokArray(String[] texts)
	{
		ArrayList<Tokenizable> tArray = new ArrayList<Tokenizable>();
		for(int i = 0 ; i < texts.length ; i++)
			tArray.add(new TokenizableTest(texts[i], i));
		Trie trie = new Trie();
		trie.insert(tArray);
		return trie;
	}

	public class TokenizableTest implements Tokenizable
	{
		String text;
		String[] tokens;
		int value;

		public TokenizableTest(String text, int value)
		{
			super();
			this.text = text;
			this.tokens = this.text.split("[ ,-]");
			this.value = value;
		}

		@Override
		public String getText()
		{
			return text;
		}

		@Override
		public String[] getTokens()
		{
			return tokens;
		}
	}
}
