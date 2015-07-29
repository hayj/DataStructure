package fr.hayj.datastructure.trie;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import fr.hayj.datastructure.trie.Trie.Tokenizable;

public class Node
{
	private LinkedHashMap<Character, Node> children = new LinkedHashMap<Character, Node>();
	private Tokenizable tokenizable = null;
	private Trie subTrie;

	public Trie getSubTrie()
	{
		return subTrie;
	}

	public void setSubTrie(Trie subTrie)
	{
		this.subTrie = subTrie;
	}

	public boolean isEndToken()
	{
		if(this.subTrie != null || this.tokenizable != null)
			return true;
		return false;
	}

	public boolean hasSubTrie()
	{
		return this.subTrie != null;
	}

	public boolean isEndTokenizable()
	{
		if(this.tokenizable != null)
			return true;
		return false;
	}

	public Node getChild(char c)
	{
		return this.children.get(c);
	}

	public LinkedHashMap<Character, Node> getChildren()
	{
		return children;
	}

	public Tokenizable getWordable()
	{
		return tokenizable;
	}

	public void setWordable(Tokenizable tokenizable)
	{
		this.tokenizable = tokenizable;
	}

	public String getWord()
	{
		if(this.tokenizable == null)
			return null;
		else
			return this.tokenizable.getText();
	}

	public Node insert(String token)
	{
		// We get the curent char to insert :
		char c = token.charAt(0);
		// We get the node :
		Node node;
		if(this.children.containsKey(c))
			node = this.children.get(c);
		else
			node = new Node();
		// We insert the node at the current char :
		this.children.put(c, node);
		// We update the trie recursively :
		if(token.length() == 1)
			return this.children.get(c);
		else
			return this.children.get(c).insert(token.substring(1));
	}

	public int childrenSize()
	{
		return this.children.size();
	}
	
	public String toString()
	{
		String str = "";
		for(Entry<Character, Node> entry : this.children.entrySet())
			str += entry.getKey() + " (" + entry.getValue().toString() + ")" + " ";
		return str;
	}
}
