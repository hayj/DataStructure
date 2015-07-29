package fr.hayj.datastructure;

import java.util.HashMap;

public class StringTree
{
	private Node root = new Node();

	public void insert(String[] tokens)
	{
		Node currentNode = root;
		for(int i = 0 ; i < tokens.length ; i++)
		{
			String currentToken = tokens[i];
			currentNode.addChild(currentToken);
			currentNode = currentNode.getChild(currentToken);
		}
		currentNode.setEndNode(true);
	}
	
	public void insert(String vocElement)
	{
		this.insert(vocElement, "[ ,-]");
	}
	
	public void insert(String vocElement, String separator)
	{
		this.insert(vocElement.split(separator));
	}
	
	public Node getRoot()
	{
		return this.root;
	}

	public class Node
	{
		HashMap<String, Node> children = new HashMap<String, Node>();
		private boolean endNode;

		public boolean hasChildren()
		{
			return !this.children.isEmpty();
		}

		public void addChild(String key)
		{
			if(!this.children.containsKey(key))
				this.children.put(key, new Node());
		}

		public void setEndNode(boolean endNode)
		{
			this.endNode = endNode;
		}
		public boolean isEndNode()
		{
			return this.endNode;
		}
		
		public Node getChild(String key)
		{
			return this.children.get(key);
		}
		
		public HashMap<String, Node> getChildren()
		{
			return this.children;
		}
	}
}