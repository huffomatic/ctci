package com.huffomatic.ctci.chapter4;

import org.junit.Assert;

import com.huffomatic.ctci.common.tree.Node;

/**
 * Successor: Find the next node of a given node in a binary search tree.
 * 
 * Predecessor: Find the previous node of a given node in a binary search tree.
 * 
 * Time:  O(H) where H is the height of the binary search tree.
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question6 {	
	public static void main(String[] args) throws Exception {
		testSuccessors();
		testPredecessors();
	}
	
	private static void testSuccessors() {
		// []
		Assert.assertTrue(getSuccessor(null) == null);
		
		// [1]
		Node node1 = new Node("1");
		node1.parent = null;
		node1.left = null;
		node1.right = null;
		
		Assert.assertTrue(getSuccessor(node1) == null);
		
		// [1, 2, 3]
		//     2
		//  1     3
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		
		node2.parent = null;
		node2.left = node1;
		node2.right = node3;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node3.parent = node2;
		node3.left = null;
		node3.right = null;
		
		Assert.assertTrue(getSuccessor(node1) == node2);
		Assert.assertTrue(getSuccessor(node2) == node3);
		Assert.assertTrue(getSuccessor(node3) == null);
		
		// [1, 2, 3, 4, 5, 6, 7]
		//           4
		//     2           6
		//  1     3     5     7
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		
		node4.parent = null;
		node4.left = node2;
		node4.right = node6;
		node2.parent = node4;
		node2.left = node1;
		node2.right = node3;
		node6.parent = node4;
		node6.left = node5;
		node6.right = node7;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node3.parent = node2;
		node3.left = null;
		node3.right = null;
		node5.parent = node6;
		node5.left = null;
		node5.right = null;
		node7.parent = node6;
		node7.left = null;
		node7.right = null;
		
		Assert.assertTrue(getSuccessor(node1) == node2);
		Assert.assertTrue(getSuccessor(node2) == node3);
		Assert.assertTrue(getSuccessor(node3) == node4);
		Assert.assertTrue(getSuccessor(node4) == node5);
		Assert.assertTrue(getSuccessor(node5) == node6);
		Assert.assertTrue(getSuccessor(node6) == node7);
		Assert.assertTrue(getSuccessor(node7) == null);
		
		// [1, 2, 3, 4, 5, 6, 7, 8]
		//           4
		//     2           6
		//  1     3     5     7  
	    //                       8
		Node node8 = new Node("8");
		
		node4.parent = null;
		node4.left = node2;
		node4.right = node6;
		node2.parent = node4;
		node2.left = node1;
		node2.right = node3;
		node6.parent = node4;
		node6.left = node5;
		node6.right = node7;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node3.parent = node2;
		node3.left = null;
		node3.right = null;
		node5.parent = node6;
		node5.left = null;
		node5.right = null;
		node7.parent = node6;
		node7.left = null;
		node7.right = node8;
		node8.parent = node7;
		node8.left = null;
		node8.right = null;

		Assert.assertTrue(getSuccessor(node1) == node2);
		Assert.assertTrue(getSuccessor(node2) == node3);
		Assert.assertTrue(getSuccessor(node3) == node4);
		Assert.assertTrue(getSuccessor(node4) == node5);
		Assert.assertTrue(getSuccessor(node5) == node6);
		Assert.assertTrue(getSuccessor(node6) == node7);
		Assert.assertTrue(getSuccessor(node7) == node8);
		Assert.assertTrue(getSuccessor(node8) == null);
		
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		//              5
		//           4              9
		//        3              8
		//     2              7
		//  1              6
		Node node9 = new Node("9");
		
		node5.parent = null;
		node5.left = node4;
		node5.right = node9;
		node4.parent = node5;
		node4.left = node3;
		node4.right = null;
		node3.parent = node4;
		node3.left = node2;
		node3.right = null;
		node2.parent = node3;
		node2.left = node1;
		node2.right = null;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node9.parent = node5;
		node9.left = node8;
		node9.right = null;
		node8.parent = node9;
		node8.left = node7;
		node8.right = null;
		node7.parent = node8;
		node7.left = node6;
		node7.right = null;
		node6.parent = node7;
		node6.left = null;
		node6.right = null;

		Assert.assertTrue(getSuccessor(node1) == node2);
		Assert.assertTrue(getSuccessor(node2) == node3);
		Assert.assertTrue(getSuccessor(node3) == node4);
		Assert.assertTrue(getSuccessor(node4) == node5);
		Assert.assertTrue(getSuccessor(node5) == node6);
		Assert.assertTrue(getSuccessor(node6) == node7);
		Assert.assertTrue(getSuccessor(node7) == node8);
		Assert.assertTrue(getSuccessor(node8) == node9);
		Assert.assertTrue(getSuccessor(node9) == null);
		
		// [1, 2, 3, 4, 5, 5]
		//                 5
		//              5
		//        3
		//     2     4
		//  1
		Node node5a = new Node("5");
		
		node5.parent = null;
		node5.left = node5a;
		node5.right = null;
		node5a.parent = node5;
		node5a.left = node3;
		node5a.right = null;
		node3.parent = node5a;
		node3.left = node2;
		node3.right = node4;
		node2.parent = node3;
		node2.left = node1;
		node2.right = null;
		node4.parent = node3;
		node4.left = null;
		node4.right = null;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;

		Assert.assertTrue(getSuccessor(node1) == node2);
		Assert.assertTrue(getSuccessor(node2) == node3);
		Assert.assertTrue(getSuccessor(node3) == node4);
		Assert.assertTrue(getSuccessor(node4) == node5a);
		Assert.assertTrue(getSuccessor(node5a) == node5);
		Assert.assertTrue(getSuccessor(node5) == null);
		
		// [5, 5]
		//     5
		//  5
		node5.parent = null;
		node5.left = node5a;
		node5.right = null;
		node5a.parent = node5;
		node5a.left = null;
		node5a.right = null;

		Assert.assertTrue(getSuccessor(node5a) == node5);
		Assert.assertTrue(getSuccessor(node5) == null);
	}
	
	private static void testPredecessors() {
		// []
		Assert.assertTrue(getPredecessor(null) == null);
		
		// [1]
		Node node1 = new Node("1");
		node1.parent = null;
		node1.left = null;
		node1.right = null;
		
		Assert.assertTrue(getPredecessor(node1) == null);
		
		// [1, 2, 3]
		//     2
		//  1     3
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		
		node2.parent = null;
		node2.left = node1;
		node2.right = node3;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node3.parent = node2;
		node3.left = null;
		node3.right = null;
		
		Assert.assertTrue(getPredecessor(node1) == null);
		Assert.assertTrue(getPredecessor(node2) == node1);
		Assert.assertTrue(getPredecessor(node3) == node2);
		
		// [1, 2, 3, 4, 5, 6, 7]
		//           4
		//     2           6
		//  1     3     5     7
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		
		node4.parent = null;
		node4.left = node2;
		node4.right = node6;
		node2.parent = node4;
		node2.left = node1;
		node2.right = node3;
		node6.parent = node4;
		node6.left = node5;
		node6.right = node7;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node3.parent = node2;
		node3.left = null;
		node3.right = null;
		node5.parent = node6;
		node5.left = null;
		node5.right = null;
		node7.parent = node6;
		node7.left = null;
		node7.right = null;
		
		Assert.assertTrue(getPredecessor(node1) == null);
		Assert.assertTrue(getPredecessor(node2) == node1);
		Assert.assertTrue(getPredecessor(node3) == node2);
		Assert.assertTrue(getPredecessor(node4) == node3);
		Assert.assertTrue(getPredecessor(node5) == node4);
		Assert.assertTrue(getPredecessor(node6) == node5);
		Assert.assertTrue(getPredecessor(node7) == node6);
		
		// [1, 2, 3, 4, 5, 6, 7, 8]
		//           4
		//     2           6
		//  1     3     5     7  
	    //                       8
		Node node8 = new Node("8");
		
		node4.parent = null;
		node4.left = node2;
		node4.right = node6;
		node2.parent = node4;
		node2.left = node1;
		node2.right = node3;
		node6.parent = node4;
		node6.left = node5;
		node6.right = node7;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node3.parent = node2;
		node3.left = null;
		node3.right = null;
		node5.parent = node6;
		node5.left = null;
		node5.right = null;
		node7.parent = node6;
		node7.left = null;
		node7.right = node8;
		node8.parent = node7;
		node8.left = null;
		node8.right = null;

		Assert.assertTrue(getPredecessor(node1) == null);
		Assert.assertTrue(getPredecessor(node2) == node1);
		Assert.assertTrue(getPredecessor(node3) == node2);
		Assert.assertTrue(getPredecessor(node4) == node3);
		Assert.assertTrue(getPredecessor(node5) == node4);
		Assert.assertTrue(getPredecessor(node6) == node5);
		Assert.assertTrue(getPredecessor(node7) == node6);
		Assert.assertTrue(getPredecessor(node8) == node7);
		
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		//              5
		//           4              9
		//        3              8
		//     2              7
		//  1              6
		Node node9 = new Node("9");
		
		node5.parent = null;
		node5.left = node4;
		node5.right = node9;
		node4.parent = node5;
		node4.left = node3;
		node4.right = null;
		node3.parent = node4;
		node3.left = node2;
		node3.right = null;
		node2.parent = node3;
		node2.left = node1;
		node2.right = null;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node9.parent = node5;
		node9.left = node8;
		node9.right = null;
		node8.parent = node9;
		node8.left = node7;
		node8.right = null;
		node7.parent = node8;
		node7.left = node6;
		node7.right = null;
		node6.parent = node7;
		node6.left = null;
		node6.right = null;

		Assert.assertTrue(getPredecessor(node1) == null);
		Assert.assertTrue(getPredecessor(node2) == node1);
		Assert.assertTrue(getPredecessor(node3) == node2);
		Assert.assertTrue(getPredecessor(node4) == node3);
		Assert.assertTrue(getPredecessor(node5) == node4);
		Assert.assertTrue(getPredecessor(node6) == node5);
		Assert.assertTrue(getPredecessor(node7) == node6);
		Assert.assertTrue(getPredecessor(node8) == node7);
		Assert.assertTrue(getPredecessor(node9) == node8);
		
		// [1, 2, 3, 4, 5, 5]
		//                 5
		//              5
		//        3
		//     2     4
		//  1
		Node node5a = new Node("5");
		
		node5.parent = null;
		node5.left = node5a;
		node5.right = null;
		node5a.parent = node5;
		node5a.left = node3;
		node5a.right = null;
		node3.parent = node5a;
		node3.left = node2;
		node3.right = node4;
		node2.parent = node3;
		node2.left = node1;
		node2.right = null;
		node4.parent = node3;
		node4.left = null;
		node4.right = null;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;

		Assert.assertTrue(getPredecessor(node1) == null);
		Assert.assertTrue(getPredecessor(node2) == node1);
		Assert.assertTrue(getPredecessor(node3) == node2);
		Assert.assertTrue(getPredecessor(node4) == node3);
		Assert.assertTrue(getPredecessor(node5a) == node4);
		Assert.assertTrue(getPredecessor(node5) == node5a);
		
		// [5, 5]
		//     5
		//  5
		node5.parent = null;
		node5.left = node5a;
		node5.right = null;
		node5a.parent = node5;
		node5a.left = null;
		node5a.right = null;

		Assert.assertTrue(getPredecessor(node5a) == null);
		Assert.assertTrue(getPredecessor(node5) == node5a);
	}
	
	private static Node getSuccessor(Node node) {
		// In-order traversal first traverses the left sub-tree, then the current node, and then the right-subtree.
		// If the current node has a right child, then the successor node is the left-most node in the right subtree.
		// If the current node does not have a right child, then the successor node is the first parent node which has
		// a left child of the last node we just visited.
		if (node == null) {
			return null;
		}
		else if (node.right != null) {
			Node current = node.right;
			while (current.left != null) {
				current = current.left;
			}
			return current;
		}
		else if (node.parent != null) {
			Node current = node;
			Node parent = node.parent;
			while ((parent != null) && (current == parent.right)) {
				current = parent;
				parent = parent.parent;
			}
			return parent;
		}
		else {
			return null;
		}
	}
	
	private static Node getPredecessor(Node node) {
		// In-order traversal first traverses the left sub-tree, then the current node, and then the right-subtree.
		// If the current node has a left child, then the successor node is the right-most node in the left subtree.
		// If the current node does not have a left child, then the successor node is the first parent node which has
		// a right child of the last node we just visited.
		if (node == null) {
			return null;
		}
		else if (node.left != null) {
			Node current = node.left;
			while (current.right != null) {
				current = current.right;
			}
			return current;
		}
		else if (node.parent != null) {
			Node current = node;
			Node parent = current.parent;
			while ((parent != null) && (current == parent.left)) {
				current = parent;
				parent = parent.parent;
			}
			return parent;
		}
		else {
			return null;
		}
	}
}
