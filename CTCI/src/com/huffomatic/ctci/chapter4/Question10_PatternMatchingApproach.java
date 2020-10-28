package com.huffomatic.ctci.chapter4;

import org.junit.Assert;

import com.huffomatic.ctci.common.test.BinaryTreeScenario;
import com.huffomatic.ctci.common.tree.Node;

/**
 * Check Subtree: Given two binary trees, determine if T2 is a subtree of T1.
 * 
 * Time:  O(n * m) where n is the length of T1 and m is the length of T2.
 * Space: O(n + m) where n is the length of T1 and m is the length of T2.
 * 
 * @author huffomatic
 *
 */
public class Question10_PatternMatchingApproach {
	public static void main(String[] args) throws Exception {
		Assert.assertTrue(isSubtree(null, null));
		
		Assert.assertTrue(isSubtree(BinaryTreeScenario.getScenario1(), null));
		
		Assert.assertFalse(isSubtree(null, BinaryTreeScenario.getScenario1()));
		
		Assert.assertTrue(isSubtree(BinaryTreeScenario.getScenario1(), BinaryTreeScenario.getScenario1()));
		
		Assert.assertTrue(isSubtree(BinaryTreeScenario.getScenario2(), BinaryTreeScenario.getScenario2()));
		
		Assert.assertTrue(isSubtree(BinaryTreeScenario.getScenario2(), BinaryTreeScenario.getScenario6()));
		
		Assert.assertTrue(isSubtree(BinaryTreeScenario.getScenario3(), BinaryTreeScenario.getScenario4()));
		
		Assert.assertFalse(isSubtree(BinaryTreeScenario.getScenario3(), BinaryTreeScenario.getScenario5()));
		
		Assert.assertFalse(isSubtree(BinaryTreeScenario.getScenario4(), BinaryTreeScenario.getScenario5()));
	}
	
	private static boolean isSubtree(Node root1, Node root2) {
		// Gets the pre-order traversal of both root nodes.
		String preorder1 = getPreorderTraversal(root1);
		String preorder2 = getPreorderTraversal(root2);
		
		// Finds the first occurrence of root2 in root1.
		int index = preorder1.indexOf(preorder2);
		
		// Returns true is index is not -1.
		return (index != -1);
	}
	
	private static String getPreorderTraversal(Node node) {
		// Initializes the pre-order place-holder.
		StringBuilder preorder = new StringBuilder();
		
		// Initializes the pre-order traversal.
		initializePreorderTraversal(node, preorder);
		
		// Returns the pre-order traversal.
		return preorder.toString();
	}
	
	private static void initializePreorderTraversal(Node node, StringBuilder preorder) {
		if (node == null) {
			// Adds an X to designate a null character.
			preorder.append("X");
		}
		else {
			// Adds the node's value and appends an space.
			preorder.append(node.name).append(" ");
			
			// Recursively calls the left and right subtrees.
			initializePreorderTraversal(node.left, preorder);
			initializePreorderTraversal(node.right, preorder);
		}
	}
}
