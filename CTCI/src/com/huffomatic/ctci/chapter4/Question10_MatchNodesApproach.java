package com.huffomatic.ctci.chapter4;

import org.junit.Assert;

import com.huffomatic.ctci.common.test.TreeScenario;
import com.huffomatic.ctci.common.tree.Node;

/**
 * Check Subtree: Given two binary trees, determine if T2 is a subtree of T1.
 * 
 * Balanced trees:
 * 
 * Time:  O(n + k*m) where n is the length of T1, m is the length of T2, and k is 
 *        the number of occurrences of T2's root in T1.
 * Space: O(log(n) + log(m)) where n is the length of T1 and m is the length of T2.
 * 
 * Unbalanced trees:
 * 
 * Time:  O(n * m) where n is the length of T1 and m is the length of T2.
 * Space: O(n + m) where n is the length of T1 and m is the length of T2.
 * 
 * @author huffomatic
 *
 */
public class Question10_MatchNodesApproach {
	public static void main(String[] args) throws Exception {
		Assert.assertTrue(isSubtree(null, null));
		
		Assert.assertTrue(isSubtree(TreeScenario.getScenario1(), null));
		
		Assert.assertFalse(isSubtree(null, TreeScenario.getScenario1()));
		
		Assert.assertTrue(isSubtree(TreeScenario.getScenario1(), TreeScenario.getScenario1()));
		
		Assert.assertTrue(isSubtree(TreeScenario.getScenario2(), TreeScenario.getScenario2()));
		
		Assert.assertTrue(isSubtree(TreeScenario.getScenario2(), TreeScenario.getScenario6()));
		
		Assert.assertTrue(isSubtree(TreeScenario.getScenario3(), TreeScenario.getScenario4()));
		
		Assert.assertFalse(isSubtree(TreeScenario.getScenario3(), TreeScenario.getScenario5()));
		
		Assert.assertFalse(isSubtree(TreeScenario.getScenario4(), TreeScenario.getScenario5()));
	}
	
	private static boolean isSubtree(Node root1, Node root2) {
		// Return false if root1 is null but root2 is not null as no other tree can match it.
		// Return true if root2 is null as it can match any non-null tree.
		// Matches the nodes if the roots are the same.
		// Searches the left and right subtrees in order to find matches.
		if (root1 == null && root2 != null) {
			return false;
		}
		else if (root2 == null) {
			return true;
		}
		else if (root1.name.equals(root2.name) && isMatch(root1, root2)) {
			return true;
		}
		else {
			return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
		}
	}
	
	private static boolean isMatch(Node node1, Node node2) {
		// If both nodes are null, then return true as null nodes are equal.
		// If one of the nodes is null, then return false as they aren't equal.
		// If the node's match, then traversal both the left and right subtrees for matches.
		// Else, return false.
		if (node1 == null && node2 == null) {
			return true;
		}
		else if (node1 == null || node2 == null) {
			return false;
		}
		else if (node1.name.equals(node2.name)) {
			return isMatch(node1.left, node2.left) && isMatch(node1.right, node2.right);
		}
		else {
			return false;
		}
	}
}
