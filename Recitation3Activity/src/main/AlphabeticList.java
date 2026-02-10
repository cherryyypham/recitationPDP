package main;

public class AlphabeticList {
	
	//The goal of this list is to establish a
	//sorted and searchable data structure that
	//is organized alphabetically. It will need to
	//use the other class (AlphabeticSort) to translate
	//String input into a numeric value before adding a node
	//to a its list.
	
	//All binary trees need a "root" of the list,
	//the first element that acts as a comparison.
	//Depending on if a value compared to the head is less
	//than or greater than the head's value, an object will
	//be stored to the "left" or "right" of it.
	Node root;

    public AlphabeticList() {
        this.root = null;
    }

	public AlphabeticList(Node element) {
		this.root = element;
	}
	
	public void insert(Node node) {
		root = insertHelper(root, node);
	}
	
	//If the data on a node matches the data of an
	//existing node, then what do you do about that
	//duplication? What would be the best way to assign
	//a new value for the data? How can we ensure that the
	//information in one node is actually different from the
	//information stored on a node with a duplicate identifier?
	private Node insertHelper(Node root, Node node) {
		int data = node.getID();
		if(root == null) {
			root = node;
			return root;
		}
		else if(data < root.getID()) {
			root.left = insertHelper(root.left, node);
		}
		else {
			root.right = insertHelper(root.right, node);
		}
		return root;
	}

    // Search a node by string name
    public Node search(String target) {
        AlphabeticSort sorter = new AlphabeticSort();
        int targetVal = sorter.Sort(target);
        return searchHelper(root, targetVal, target);
    }

    private Node searchHelper(Node root, int targetVal, String target) {
        if (root == null) {
            return null;
        }

        if (targetVal == root.getID()) {
            if (root.getNodeElement().getName().equalsIgnoreCase(target)) {
                return root;
            }

            Node leftVal = searchHelper(root.left, targetVal, target);
            if (leftVal != null) return null;
            return searchHelper(root.right, targetVal, target);
        }

        else if (targetVal < root.getID()) {
            return searchHelper(root.left, targetVal, target);
        }

        else {
            return searchHelper(root.right, targetVal, target);
        }
    }
}
