package main;

public class Node {
	
	/**
	 * Identifier
	 */
	Element e;
	int identifier;
	
	/**
	 * Because this collection is a tree,
	 * we need each node to contain pointers to a 
	 * "left" and "right" element, searchable using
	 * "greater than" and "less than" comparisons.
	 * 
	 * Left and right node pointers are initialized as "null"
	 * and then replaced with other values as needed.
	 */
	Node left = null;
	Node right = null;
	
	/**
	 * Default constructor.
	 * Allows to construct an empty (or null) node.
	 */
	public Node() {}
	 
	/**
	 * Base constructor for constructing a node
	 * pointing to a single element in a list.
	 * @param e Element in the list, containing whatever data is defined 
	 * in the Element class.
	 * Note that we store a numerical value, the identifier, when we
	 * generate a new node and its elements.
	 */
	public Node(Element e) {
		this.e = e;
		this.identifier = e.getIdentifier();
	}
	
	public Element getNodeElement() {
		return this.e;
	}
	public int getID() {
		return this.identifier;
	}

}
