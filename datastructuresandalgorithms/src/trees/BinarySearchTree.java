//package trees;
//
//public class BinarySearchTree <T extends Comparable<T>> {
//	
//	// Tracks the number of nodes in this BST
//	private int nodeCount = 0;
//	
//	// This BST is a rooted tree so we maintain a handle on the root node
//	private Node root = null;
//	
//	// Internal node containing node references
//	// and the actual node data
//	private class Node {
//		T data;
//		Node left, right;
//		public Node (Node left, Node right, T elem) {
//			this.data = elem;
//			this.left = left;
//			this.right = right;
//		}
//	}
//	
//	// Check if this binary tree is empty
//	public boolean isEmpty() {
//		return size() == 0;
//	}
//	
//	// Get the number of nodes in this binary tree
//	public int size() {
//		return nodeCount;
//	}
//	
//	// Add an element to this binary tree. Returns true
//	// if we successfully perform an insertion
//	public boolean add(T elem) {
//		
//		// Check if the value already exists in this
//		// binary tree, if it does ignore adding it
//		if (contains(elem)) {
//			return false;
//			
//		// Otherwise add this element to the binary tree
//		} else {
//			root = add(root, elem);
//			nodeCount++;
//			return true;
//		}
//	}
//	
//	// Private method to recursively add a value in the binary tree
//	private Node add(Node node, T elem) {
//		
//		// Base case: found a leaf node
//		if (node == null) {
//			node = new Node(null, null, elem);
//		} else {
//			// Place lower element values in left subtree
//			if (elem.compareTo(node.data) < 0) {
//				node.left = add(node.left, elem);
//			} else {
//				node.right = add(node.right, elem);
//			}
//		}
//	
//		return node;
//	}
//	
//	// Remove a value from this binary tree, if it exists
//	public boolean remove(T elem) {
//		
//		// Make sure the node we want to remove
//		// actually exists before we remove it
//		if (contains(elem)) {
//			root = remove(root, elem);
//			nodeCount--;
//			return true;
//		}
//		return false;		
//	}
//	
//	private Node remove(Node node, T elem) {
//		
//		if (node == null) return null;
//		
//		int cmp = elem.compareTo(node.data);
//		
//		// Dig into left subtree, the value we're looking
//		// for is smaller than the current value
//		if (cmp < 0) {
//			node.left = remove(node.left, elem);
//		
//		// Dig into right subtree, the value we're looking
//		// for is greater than the current value
//		} else if (cmp > 0) {
//			node.right = remove(node.right, elem);
//		
//		// Found the node we wish to remove
//		} else {
//			
//			// This is the case with only a right subtree or
//			// no subtree at all. In this situation just
//			// swap node we wish to remove with its right child.
//			if (node.left == null) {
//				
//				Node rightChild = node.right;
//				
//				node.data = null;
//				node = null;
//				
//				return rightChild;
//				
//			// This is the case with only a left subtree or
//			// no subtree at all. In this situation just
//			// swap the node we wish to remove with its left child				
//			} else if (node.right == null) {
//				
//				Node leftChild = node.left;
//				
//				node.data = null;
//				node = null;
//				
//				return rightChild;
//				
//			// This is the case with only a left subtree or
//			// no subtree at all. In this situation just
//			// swap the node we wish to remove with its left child.
//			} else if (node.right == null) {
//				
//				Node leftChild = node.left;
//				
//				node.data = null;
//				node = null;
//				
//				return leftChild;
//				
//			// When removing a node from a binary tree with two links the
//			// successor of the node being removed can either be the largest
//			// value in the left substree or the smallest value in the right
//			// subtree. In this implementation I have decided to find the
//			// smallest value in the right subtree which can be found by
//			// traversing as far left as possible in the right subtree.
//			} else {
//				
//				// Find the leftmost node in the right subtree
//				Node tmp = digLeft(node.right);
//				
//				// Swap the data
//				node.data = tmp.data;
//				
//				// Go into the right subtree and remove the leftmost node we
//				// found and swapped data with. This prevents us from having
//				// two nodes in our tree with the same value.
//				node.right = remove(node.right, tmp.data);
//				
//				// If instead we wanted to find the largest node in the left
//				// subtree as opposed to smallest node in the right subtree
//				// here is what we would do:
//				// Node tmp = digRight(node.left);
//				// node.data = tmp.data;
//				// node.left = remove(node.left, tmp.data);			
//				
//			}	
//		}
//		
//		return node;		
//	}
//	
//	// Helper method to find the leftmost node
//	private Node digLeft(Node node) {
//		Node cur = node;
//		while(cur.left != null)
//			cur = cur.left;
//		return cur;
//	}
//	
//	// Helper method to find the rightmost node
//	private Node digLeft(Node node) {
//		Node cur = node;
//		while(cur.left != null)
//			cur = cur.left;
//		return cur;
//	}
//	
//	// Helper method to find the rightmost node
//	private Node digRight(Node node) {
//		Node cur = node;
//		while(cur.right != null)
//			cur = cur.right;
//		return cur;
//	}
//	
//	// returns true is the element exists in the tree
//	public boolean contrains(T leme) {
//		return contains(root, elem);
//	}
//	
//	// private recursive method to find an element in the tree
//	private boolean contains(Node node, T elem) {
//		
//		// Base case: reached bottom, value not found
//		if (node == null) return false;
//		
//		int cmp = elem.compareTo(node.data);
//		
//		// Dig into the left subtree because the value we're
//		// looking for is smaller than the current value
//		if (cmp < 0) return contains(node.left, elem);
//		
//		// Dig into the right subtree because the value we're
//		// looking for is greater than the current value
//		else if (cmp > 0) return contains(node.right, elem);
//		
//		// We found the value we were looking for
//		else return true;
//	}
//	
//	// Compute the height of the tree, O(n)
//	public int height() {
//		return height(root);
//	}
//	
//	// Recursive helper method to compute the height of the tree
//	private int height(Node node) {
//		if (node == null) return 0;
//		return Math.max( height(node.left), height(node.right) ) + 1;
//	}
//	
//	// This method returns an iterator for a given TreeTraversalOrder.
//	// The ways in which you can traverse the tree are in four different ways:
//	// preorder, inorder, postorder and leveloder.
//	public java.util.Iterator <T> traverse(TreeTraversalOrder order) {
//		switch (order) {
//			case PRE_ORDER: return preOrderTraversal();
//			case IN_ORDER: return inOrderTravesal();
//			case POST_ORDER: return postOrderTraversal();
//			case LEVEL_ORDER: return levelOrderTraversal();
//			default: return null;
//		}
//	}
//	
//	// Returns an iterator to traverse the tree in pre order
//	private java.util.Iterator <T> preOrderTraversal() {
//		
//	}
//	
//	// Returns as iterator to traverse the tree in order
//	private java.util.Iterator <T> inOrderTraversal() {
//		
//		
//	}
//	
//	// Returns as iterator to traverse the tree in post order
//	private java.util.Iterator <T> postOrderTraversal() {
//		
//	}
//	
//}
