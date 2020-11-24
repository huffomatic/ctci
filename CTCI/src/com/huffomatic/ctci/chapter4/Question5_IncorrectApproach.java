package com.huffomatic.ctci.chapter4;

import org.junit.Assert;

import com.huffomatic.ctci.common.tree.Node;

/**
 * Validate BST: Check if a binary tree is a binary search tree.
 * A binary search tree is a binary tree where all the left nodes of the current node
 * are less than or equal to the current node and all the right nodes are greater than
 * the current node.
 * 
 * Time:  O(n) where n is the number of nodes.
 * Space: O(H) where H is the height of the tree (not necessarily balanced).
 * 
 * @author huffomatic
 *
 */
public class Question5_IncorrectApproach {
	public static void main(String[] args) throws Exception {
		// []
		Assert.assertTrue(isBinarySearchTree(null));
		
		// [1]
		Node node1 = new Node("1");
		
		Assert.assertTrue(isBinarySearchTree(node1));
		
		// [1, 2, 3]
		//     2
		//  1     3
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		
		node2.left = node1;
		node2.right = node3;
		
		Assert.assertTrue(isBinarySearchTree(node2));
		
		// [1, 2, 3, 4, 5, 6, 7]
		//           4
		//     2           6
		//  1     3     5     7
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		
		node4.left = node2;
		node4.right = node6;
		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		
		Assert.assertTrue(isBinarySearchTree(node4));
		
		// [1, 2, 3, 4, 5, 6, 7, 8]
		//           4
		//     2           6
		//  1     3     5     7  
	    //                       8
		Node node8 = new Node("8");
		
		node4.left = node2;
		node4.right = node6;
		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		node7.right = node8;

		Assert.assertTrue(isBinarySearchTree(node4));
		
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		//           4
		//     2           6
		//  1     3     5           7  
	    //                       8
		//                    9
		Node node9 = new Node("9");
		
		node4.left = node2;
		node4.right = node6;
		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		node7.left = node8;
		node7.right = null;
		node8.left = node9;
		node8.right = null;

		Assert.assertFalse(isBinarySearchTree(node4));
		
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		//              5
		//           4              6
		//        3              7
		//     2              8
		//  1              9
		node5.left = node4;
		node5.right = node6;
		node4.left = node3;
		node4.right = null;
		node3.left = node2;
		node3.right = null;
		node2.left = node1;
		node2.right = null;
		node6.left = node7;
		node6.right = null;
		node7.left = node8;
		node7.right = null;
		node8.left = node9;
		node8.right = null;

		Assert.assertFalse(isBinarySearchTree(node5));
		
		// [1, 2, 3, 4, 5, 5]
		//                 5
		//              5
		//        3
		//     2     4
		//  1
		Node node5a = new Node("5");
		
		node5.left = node5a;
		node5.right = null;
		node5a.left = node3;
		node5a.right = null;
		node3.left = node2;
		node3.right = node4;
		node2.left = node1;
		node2.right = null;
		node4.left = null;
		node4.right = null;

		Assert.assertTrue(isBinarySearchTree(node5));
		
		// [1, 2, 3, 6, 5, 5]
		//                 5
		//              5
		//        3
		//     2     6
		//  1
		node5.left = node5a;
		node5.right = null;
		node5a.left = node3;
		node5a.right = null;
		node3.left = node2;
		node3.right = node6;
		node2.left = node1;
		node2.right = null;
		node6.left = null;
		node6.right = null;

		Assert.assertFalse(isBinarySearchTree(node5));
	}
	
	// This implementation doesn't work for the last test case above
	// but might be a first solution someone might provide.
	private static boolean isBinarySearchTree(Node node) {
		// If the node is null, then return true.
		if (node == null) {
			return true;
		}
		
		// Recursively checks to see if the left and right nodes are binary search trees.
		boolean leftResult = isBinarySearchTree(node.left);
		boolean rightResult = isBinarySearchTree(node.right);
		
		// If either the left or right nodes are not binary search trees, then the rest of the tree
		// is not a binary search tree so return false.
		if (!leftResult || !rightResult) {
			return false;
		}
		
		// Since the left and right nodes are binary search trees, then check to see if the current
		// value makes the tree a binary search tree.
		int current = Integer.parseInt(node.name);
		if (node.left != null && node.right != null) {
			int left = Integer.parseInt(node.left.name);
			int right = Integer.parseInt(node.right.name);
			
			return (left <= current && current < right);
		}
		else if (node.left != null && node.right == null) {
			int left = Integer.parseInt(node.left.name);
			
			return (left <= current);
		}
		else if (node.left == null && node.right != null) {
			int right = Integer.parseInt(node.right.name);
			
			return (current < right);
		}
		else {
			return true;
		}
	}
}
