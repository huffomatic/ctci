package com.huffomatic.ctci.chapter4;

import java.util.Random;

import org.junit.Assert;

import com.huffomatic.ctci.common.tree.BinarySearchTree;

/**
 * Random Node: Implement a binary search tree with operations insert, find, delete,
 * and getRandomNode(), a method which returns a random node from the tree.  All nodes
 * should be equally likely to be chosen.
 * 
 * Time:  O(log(n)) where n is the number of nodes.
 * Space: O(n) where n is the number of nodes.
 * 
 * @author huffomatic
 *
 */
public class Question11 {
	public static void main(String[] args) throws Exception {
		BinarySearchTree node4 = new BinarySearchTree(4);
		node4.insert(2);
		node4.insert(1);
		node4.insert(3);
		node4.insert(6);
		node4.insert(5);
		node4.insert(7);
		
		Assert.assertTrue(node4.getIthNode(0) == node4.find(1));
		Assert.assertTrue(node4.getIthNode(1) == node4.find(2));
		Assert.assertTrue(node4.getIthNode(2) == node4.find(3));
		Assert.assertTrue(node4.getIthNode(3) == node4.find(4));
		Assert.assertTrue(node4.getIthNode(4) == node4.find(5));
		Assert.assertTrue(node4.getIthNode(5) == node4.find(6));
		Assert.assertTrue(node4.getIthNode(6) == node4.find(7));
		
		Assert.assertNull(getRandomNode(null));
		Assert.assertNotNull(getRandomNode(node4));
	}
	
	public static BinarySearchTree getRandomNode(BinarySearchTree root) {
		// Validates the input.
		if (root == null) {
			return null;
		}
		
		// Picks a random number from 1 to root size.
		Random random = new Random();
		int index = random.nextInt(root.getSize());
		
		// Finds the ith node in binary search tree.
		return root.getIthNode(index);
	}
}
