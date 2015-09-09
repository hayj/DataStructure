package fr.hayj.datastructure.trie;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import fr.hayj.datastructure.trie.Trie.Tokenizable;

public class Node
{
	private LinkedHashMap<Character, Node> children = new LinkedHashMap<Character, Node>();
	private ArrayList<Tokenizable> tokenizables = new ArrayList<Tokenizable>();
	private Trie subTrie;

	public Trie getSubTrie()
	{
		return this.subTrie;
	}

	public void setSubTrie(Trie subTrie)
	{
		this.subTrie = subTrie;
	}

	public boolean isEndToken()
	{
		if(this.subTrie != null || isEndTokenizable())
			return true;
		return false;
	}

	public boolean hasSubTrie()
	{
		return this.subTrie != null;
	}

	public boolean isEndTokenizable()
	{
		if(this.hasTokenizables() && this.tokenizables.size() != 0)
			return true;
		return false;
	}

	public Node getChild(char c)
	{
		return this.children.get(c);
	}

	public LinkedHashMap<Character, Node> getChildren()
	{
		return this.children;
	}

	@Deprecated
	public Tokenizable getTokenizable()
	{
		return this.getFirstTokenizable();
	}
	
	public Tokenizable getFirstTokenizable()
	{
		if(!this.hasTokenizables() || this.tokenizables.size() == 0)
			return null;
		return this.tokenizables.get(0);
	}
	
	public ArrayList<Tokenizable> getTokenizables()
	{
		return this.tokenizables;
	}

	@Deprecated
	public void setTokenizable(Tokenizable tokenizable)
	{
		this.addTokenizable(tokenizable);
	}
	
	public void addTokenizable(Tokenizable tokenizable)
	{
		if(this.hasTokenizables())
			this.tokenizables.add(tokenizable);
	}

	private boolean hasTokenizables()
	{
		return this.tokenizables != null;
	}

	public Node insert(String token)
	{
		// We get the current char to insert :
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

	//TODO test
	public int size()
	{
		int size = 0;
		if(this.subTrie != null)
		  size += this.subTrie.size();
		if(this.isEndTokenizable())
			size += 1;
		if(this.childrenSize() > 0)
		{
			for(Entry<Character, Node> child : this.children.entrySet())
				size += child.getValue().size();
		}
		return size;
	}

	public ArrayList<Node> getLeaves()
	{
		ArrayList<Node> leaves = new ArrayList<Node>();
		if(this.isEndToken())
			leaves.add(this);
		for(Entry<Character, Node> child : this.children.entrySet())
			leaves.addAll(child.getValue().getLeaves());
		return leaves;
	}
}
