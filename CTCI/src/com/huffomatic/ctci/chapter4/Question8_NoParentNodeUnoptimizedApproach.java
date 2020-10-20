package com.huffomatic.ctci.chapter4;

import org.junit.Assert;

import com.huffomatic.ctci.common.tree.Node;

/**
 * First Common Ancestor: Find the first common ancestor of two nodes in a binary tree.
 * 
 * Time:  O(n) where n is the number of nodes on a balanced binary tree.
 * Space: O(log n) where n is the number of nodes on a balanced binary tree.
 * 
 * @author huffomatic
 *
 */
public class Question8_NoParentNodeUnoptimizedApproach {
	public static void main(String[] args) throws Exception {
		// []
		Assert.assertTrue(getFirstCommonAncestor(null, null, null) == null);
		
		// [1]
		Node node1 = new Node("1");
		
		Assert.assertTrue(getFirstCommonAncestor(node1, node1, node1) == node1);
		
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
		
		Assert.assertTrue(getFirstCommonAncestor(node2, node1, node3) == node2);
		Assert.assertTrue(getFirstCommonAncestor(node2, node2, node2) == node2);
		Assert.assertTrue(getFirstCommonAncestor(node2, node1, node2) == node2);
		Assert.assertTrue(getFirstCommonAncestor(node2, node2, node3) == node2);
		
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
		
		Assert.assertTrue(getFirstCommonAncestor(node4, node1, node7) == node4);
		Assert.assertTrue(getFirstCommonAncestor(node4, node2, node7) == node4);
		Assert.assertTrue(getFirstCommonAncestor(node4, node3, node5) == node4);
		
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
		node7.parent = node6;
		node7.left = null;
		node7.right = node8;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node3.parent = node2;
		node3.left = null;
		node3.right = null;
		node5.parent = node6;
		node5.left = null;
		node5.right = null;
		node8.parent = node7;
		node8.left = null;
		node8.right = null;

		Assert.assertTrue(getFirstCommonAncestor(node4, node3, node8) == node4);
		
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		//           4
		//     2           6
		//  1     3     5           7  
	    //                       8
		//                    9
		Node node9 = new Node("9");
		
		node4.parent = null;
		node4.left = node2;
		node4.right = node6;
		node2.parent = node4;
		node2.left = node1;
		node2.right = node3;
		node6.parent = node4;
		node6.left = node5;
		node6.right = node7;
		node7.parent = node6;
		node7.left = node8;
		node7.right = null;
		node8.parent = node7;
		node8.left = node9;
		node8.right = null;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;
		node3.parent = node2;
		node3.left = null;
		node3.right = null;
		node5.parent = node6;
		node5.left = null;
		node5.right = null;
		node9.parent = node8;
		node9.left = null;
		node9.right = null;
		
		Assert.assertTrue(getFirstCommonAncestor(node4, node3, node9) == node4);
		
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		//              5
		//           4              6
		//        3              7
		//     2              8
		//  1              9
		node5.parent = null;
		node5.left = node4;
		node5.right = node6;
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
		node6.parent = node5;
		node6.left = node7;
		node6.right = null;
		node7.parent = node6;
		node7.left = node8;
		node7.right = null;
		node8.parent = node7;
		node8.left = node9;
		node8.right = null;
		node9.parent = node8;
		node9.left = null;
		node9.right = null;
		
		Assert.assertTrue(getFirstCommonAncestor(node5, node3, node9) == node5);
		
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		//              5
		//           4              9
		//        3              8
		//     2              7
		//  1              6
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

		Assert.assertTrue(getFirstCommonAncestor(node5, node1, node6) == node5);
		
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

		Assert.assertTrue(getFirstCommonAncestor(node5, node1, node4) == node3);

		// [2, 1, 3, 4, 5, 5]
		//                 5
		//              5
		//        3
		//     1     4
		//  2		
		node5.parent = null;
		node5.left = node5a;
		node5.right = null;
		node5a.parent = node5;
		node5a.left = node3;
		node5a.right = null;
		node3.parent = node5a;
		node3.left = node1;
		node3.right = node4;
		node1.parent = node3;
		node1.left = node2;
		node1.right = null;
		node4.parent = node3;
		node4.left = null;
		node4.right = null;
		node2.parent = node1;
		node2.left = null;
		node2.right = null;

		Assert.assertTrue(getFirstCommonAncestor(node5, node2, node4) == node3);
		
		// [1, 2, 3, 6, 5, 5]
		//                 5
		//              5
		//        3
		//     2     6
		//  1
		node5.parent = null;
		node5.left = node5a;
		node5.right = null;
		node5a.parent = node5;
		node5a.left = node3;
		node5a.right = null;
		node3.parent = node5a;
		node3.left = node2;
		node3.right = node6;
		node2.parent = node3;
		node2.left = node1;
		node2.right = null;
		node6.parent = node3;
		node6.left = null;
		node6.right = null;
		node1.parent = node2;
		node1.left = null;
		node1.right = null;

		Assert.assertTrue(getFirstCommonAncestor(node5, node5, node1) == node5);
		
		// [5, 5]
		//     5
		//  5
		node5.parent = null;
		node5.left = node5a;
		node5.right = null;
		node5a.parent = node5;
		node5a.left = null;
		node5a.right = null;

		Assert.assertTrue(getFirstCommonAncestor(node5, node5, node5a) == node5);
		
		// [5, 5]
		//  5
		//     5
		node5.parent = null;
		node5.left = null;
		node5.right = node5a;
		node5a.parent = node5;
		node5a.left = null;
		node5a.right = null;

		Assert.assertTrue(getFirstCommonAncestor(node5, node5, node5a) == node5);
	}
	
	private static Node getFirstCommonAncestor(Node root, Node first, Node second) {
		// Validates the first and second nodes are actually in the binary tree.
		if (!covers(root, first) || !covers(root, second)) {
			return null;
		}
		
		// Find the first common ancestor knowing now both first and second nodes exist
		// in the binary tree.
		return getFirstCommonAncestorHelper(root, first, second);
	}
	
	private static Node getFirstCommonAncestorHelper(Node current, Node first, Node second) {
		// If current is null, current equals first node, or current equals second node, then return current.
		// These checks are required in case first and second are not at the same level.
		if ((current == null) || (current == first) || (current == second)) {
			return current;
		}
		
		// Checks to see if the first and second nodes appear on the left child.
		boolean leftCoversFirst = covers(current.left, first);
		boolean leftCoversSecond = covers(current.left, second);
		
		// We have found the first common ancestor when first and second nodes are on
		// opposite sides of the current node.
		if (leftCoversFirst != leftCoversSecond) {
			return current;
		}
		
		// If both nodes are on the same side, then keep searching on that same side.
		Node child = leftCoversFirst ? current.left : current.right;
		
		// Returns the first common ancestor on the other child.
		return getFirstCommonAncestorHelper(child, first, second);
	}
	
	private static boolean covers(Node current, Node node) {
		// If current is null, then we didn't find node.
		// Else if current equals node, then we found node.
		// Else, search the left and right sub-trees for node.
		if (current == null) {
			return false;
		}
		else if (current == node) {
			return true;
		}
		else {
			return covers(current.left, node) || covers(current.right, node);
		}
	}
}
