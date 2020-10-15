package com.huffomatic.ctci.chapter4;

import org.junit.Assert;

import com.huffomatic.ctci.common.tree.Node;

/**
 * Check Balanced: Check if a binary tree is balanced.
 * Balanced binary tree means the heights of any two 
 * subtrees differ in height by no more than one.
 * 
 * Time:  O(n) where n is the number of nodes.
 * Space: O(H) where H is the height of the tree (not necessarily balanced).
 * 
 * @author huffomatic
 *
 */
public class Question4 {
	public static void main(String[] args) throws Exception {
		// []
		Assert.assertTrue(isBalanced(null));
		
		// [1]
		Node node1 = new Node("1");
		
		Assert.assertTrue(isBalanced(node1));
		
		// [1, 2, 3]
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		
		node2.left = node1;
		node2.right = node3;
		
		Assert.assertTrue(isBalanced(node2));
		
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
		
		Assert.assertTrue(isBalanced(node4));
		
		// [1, 2, 3, 4, 5, 6, 7, 8]
		//           4
		//     2           6
		//  1     3     5        7  
	    //                    8
		Node node8 = new Node("8");
		
		node4.left = node2;
		node4.right = node6;
		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		node7.left = node8;

		Assert.assertTrue(isBalanced(node4));
		
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

		Assert.assertFalse(isBalanced(node4));
		
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

		Assert.assertFalse(isBalanced(node5));
	}
	
	private static boolean isBalanced(Node root) {
		// Gets the height of the root node.
		int height = getHeight(root);
		
		// Return true if the height is non-negative.
		return (height >= 0);
	}
	
	private static int getHeight(Node node) {
		// We are at a leaf node so return a height of 0;
		if (node == null) {
			return 0;
		}
		
		// Gets the left and right node heights.
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		
		// If either one of the heights is -1, then return -1 so we short-circuit height calculations.
		// If the left height is greater than or equal to the right height, then calculate the height
		// difference and return the left height + 1 if the difference is no more than 1.
		// Else, calculate the height difference and return the right height + 1 if the difference is
		// no more than 1.
		if ((leftHeight == -1) || (rightHeight == -1)) {
			return -1;
		}
		else if (leftHeight >= rightHeight) {
			return ((leftHeight - rightHeight) <= 1) ? (leftHeight + 1) : -1;
		}
		else {
			return ((rightHeight - leftHeight) <= 1) ? (rightHeight + 1) : -1;
		}
	}
}
