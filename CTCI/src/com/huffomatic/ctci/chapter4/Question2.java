package com.huffomatic.ctci.chapter4;

import org.junit.Assert;

import com.huffomatic.ctci.common.tree.Node;

/**
 * Minimal Tree: Create a binary search tree with minimal height given a sorted array.
 * 
 * Time:  O(n) where n is the number of nodes.
 * Space: O(n) where n is the number of nodes.
 * 
 * @author huffomatic
 *
 */
public class Question2 {
	public static void main(String[] args) throws Exception {
		// [1, 2, 3, 4, 5, 6, 7]
		//           4
		//     2           6
		//  1     3     5     7
		int[] sortedArray1 = new int[] {1, 2, 3, 4, 5, 6, 7};
		
		Node root1 = createMinimalBST(sortedArray1);
		
		Assert.assertTrue(root1.name.equals("4"));
		Assert.assertTrue(root1.left.name.equals("2"));
		Assert.assertTrue(root1.right.name.equals("6"));
		Assert.assertTrue(root1.left.left.name.equals("1"));
		Assert.assertTrue(root1.left.right.name.equals("3"));
		Assert.assertTrue(root1.right.left.name.equals("5"));
		Assert.assertTrue(root1.right.right.name.equals("7"));
		
		// [1, 2, 3, 4, 5, 6, 7, 8]
		//           4
		//     2           6
		//  1     3     5     7  
	    //                       8
		int[] sortedArray2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		
		Node root2 = createMinimalBST(sortedArray2);
		
		Assert.assertTrue(root1.name.equals("4"));
		Assert.assertTrue(root1.left.name.equals("2"));
		Assert.assertTrue(root1.right.name.equals("6"));
		Assert.assertTrue(root1.left.left.name.equals("1"));
		Assert.assertTrue(root1.left.right.name.equals("3"));
		Assert.assertTrue(root1.right.left.name.equals("5"));
		Assert.assertTrue(root1.right.right.name.equals("7"));
		Assert.assertTrue(root2.right.right.right.name.equals("8"));
	}
	
	private static Node createMinimalBST(int[] sortedArray) {
		return createMinimalBST(sortedArray, 0, sortedArray.length - 1);
	}
	
	private static Node createMinimalBST(int[] sortedArray, int startIndex, int endIndex) {
		// Previous iteration was a leaf node.
		if (startIndex > endIndex) {
			return null;
		}
		
		// Find the middle index.
		int middleIndex = (startIndex + endIndex) / 2;
		
		// Creates the middle node.
		Node middleNode = new Node(String.valueOf(sortedArray[middleIndex]));
		
		// Iterate the left subtree.
		Node leftNode = createMinimalBST(sortedArray, startIndex, middleIndex - 1);
		
		// Iterate the right subtree.
		Node rightNode = createMinimalBST(sortedArray, middleIndex + 1, endIndex);
		
		// Sets the adjacency nodes.
		if (leftNode != null && rightNode != null) {
			middleNode.left = leftNode;
			middleNode.right = rightNode;
		}
		else if (leftNode != null && rightNode == null) {
			middleNode.left = leftNode;
			middleNode.right = null;
		}
		else if (leftNode == null && rightNode != null) {
			middleNode.left = null;
			middleNode.right = rightNode;
		}
		
		return middleNode;
	}
}
