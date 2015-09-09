package fr.hayj.datastructure.trie;

import java.util.ArrayList;
import java.util.List;

import fr.hayj.datastructure.trie.Trie.Tokenizable;

/**
 * This data structure is a Trie which can store any object which implements
 * Trie.Tokenizable. It can also store a sub-trie at all leaf to handle
 * multi-word dictionary.
 * 
 * @author hayj
 *
 */
public class Trie
{
	public interface Tokenizable extends Cloneable 
	{
		public abstract String getText();

		public abstract String[] getTokens();
	}

	private Node root;

	public void insert(List<Tokenizable> tokenizables)
	{
		//Init of the root :
		if(this.root == null)
			this.root = new Node();
		// For all wordables :
		for(Tokenizable tokenizable : tokenizables)
		{
			// We insert the first token :
			String[] tokens = tokenizable.getTokens();
			Node currentNode = this.root;
			currentNode = currentNode.insert(tokens[0]);
			// For all other tokens :
			for(int i = 1 ; i < tokens.length ; i++)
			{
				// We get the sub-trie :
				String token = tokens[i];
				Trie subTrie = currentNode.getSubTrie();
				// If the sub-trie is null, we create it :
				if(subTrie == null)
				{
					subTrie = new Trie();
					currentNode.setSubTrie(subTrie);
				}
				// We insert the current token to the new sub trie :
				currentNode = subTrie.insert(token);
			}
			// If it's the last trie, we insert the current wordable at the last
			// node :
			currentNode.addTokenizable(tokenizable);
		}
	}

	private Node insert(String token)
	{
		if(this.root == null)
			this.root = new Node();
		return this.root.insert(token);
	}

	public Node getRoot()
	{
		return this.root;
	}

	public int size()
	{
		return this.root.size();
	}

	public ArrayList<Tokenizable> getTokenizables()
	{
		ArrayList<Node> leaves = this.getRoot().getLeaves();
		ArrayList<Tokenizable> tokenizables = new ArrayList<Tokenizable>();
		for(Node leaf : leaves)
		{
			if(leaf.isEndTokenizable())
				tokenizables.addAll(leaf.getTokenizables());
			if(leaf.hasSubTrie())
				tokenizables.addAll(leaf.getSubTrie().getTokenizables());
		}
		return tokenizables;
	}
}
