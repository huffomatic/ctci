package com.huffomatic.ctci.chapter4;

import java.util.LinkedList;

import org.junit.Assert;

import com.huffomatic.ctci.common.tree.LinkedListUtil;
import com.huffomatic.ctci.common.tree.Node;

/**
 * Binary Search Tree Sequences: Given a binary search tree with distinct values, 
 * print all possible arrays which could have created this tree.
 * 
 * Time:  O() where n is the number of nodes on a balanced binary tree.
 * Space: O() where n is the number of nodes on a balanced binary tree.
 * 
 * @author huffomatic
 *
 */
public class Question9 {
	public static void main(String[] args) throws Exception {
		// []
		LinkedList<Node> expectedBSTSequence1_1 = new LinkedList<Node>();
		
		LinkedList<LinkedList<Node>> expectedBSTSequence1 = new LinkedList<LinkedList<Node>>();
		expectedBSTSequence1.add(expectedBSTSequence1_1);
		
		Assert.assertTrue(LinkedListUtil.compareListOfLists(getBinarySearchTreeSequence(null), expectedBSTSequence1));
		
		// [1]
		Node node1 = new Node("1");
		
		LinkedList<Node> expectedBSTSequence2_1 = new LinkedList<Node>();
		expectedBSTSequence2_1.add(node1);
		
		LinkedList<LinkedList<Node>> expectedBSTSequence2 = new LinkedList<LinkedList<Node>>();
		expectedBSTSequence2.add(expectedBSTSequence2_1);
		
		LinkedList<LinkedList<Node>> actualBSTSequence2 = getBinarySearchTreeSequence(node1);
		
		Assert.assertTrue(LinkedListUtil.compareListOfLists(actualBSTSequence2, expectedBSTSequence2));
		
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
		
		LinkedList<Node> expectedBSTSequence3_1 = new LinkedList<Node>();
		expectedBSTSequence3_1.add(node2);
		expectedBSTSequence3_1.add(node1);
		expectedBSTSequence3_1.add(node3);
		
		LinkedList<Node> expectedBSTSequence3_2 = new LinkedList<Node>();
		expectedBSTSequence3_2.add(node2);
		expectedBSTSequence3_2.add(node3);
		expectedBSTSequence3_2.add(node1);
		
		LinkedList<LinkedList<Node>> expectedBSTSequence3 = new LinkedList<LinkedList<Node>>();
		expectedBSTSequence3.add(expectedBSTSequence3_1);
		expectedBSTSequence3.add(expectedBSTSequence3_2);
		
		LinkedList<LinkedList<Node>> actualBSTSequence3 = getBinarySearchTreeSequence(node2);
		
		Assert.assertTrue(LinkedListUtil.compareListOfLists(actualBSTSequence3, expectedBSTSequence3));
		
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
		
		LinkedList<LinkedList<Node>> actualBSTSequence4 = getBinarySearchTreeSequence(node4);
		
		Assert.assertTrue(actualBSTSequence4.size() == 80);
		
		// [1, 2, 3, 4, 5, 6, 7]
		//              5
		//           4        7
		//        3        6
		node5.parent = null;
		node5.left = node4;
		node5.right = node7;
		node4.parent = node5;
		node4.left = node3;
		node4.right = null;
		node3.parent = node4;
		node3.left = null;
		node3.right = null;
		node7.parent = node5;
		node7.left = node6;
		node7.right = null;
		node6.parent = node7;
		node6.left = null;
		node6.right = null;

		LinkedList<Node> expectedBSTSequence5_1 = new LinkedList<Node>();
		expectedBSTSequence5_1.add(node5);
		expectedBSTSequence5_1.add(node4);
		expectedBSTSequence5_1.add(node3);
		expectedBSTSequence5_1.add(node7);
		expectedBSTSequence5_1.add(node6);
		
		LinkedList<Node> expectedBSTSequence5_2 = new LinkedList<Node>();
		expectedBSTSequence5_2.add(node5);
		expectedBSTSequence5_2.add(node4);
		expectedBSTSequence5_2.add(node7);
		expectedBSTSequence5_2.add(node3);
		expectedBSTSequence5_2.add(node6);
		
		LinkedList<Node> expectedBSTSequence5_3 = new LinkedList<Node>();
		expectedBSTSequence5_3.add(node5);
		expectedBSTSequence5_3.add(node4);
		expectedBSTSequence5_3.add(node7);
		expectedBSTSequence5_3.add(node6);
		expectedBSTSequence5_3.add(node3);
		
		LinkedList<Node> expectedBSTSequence5_4 = new LinkedList<Node>();
		expectedBSTSequence5_4.add(node5);
		expectedBSTSequence5_4.add(node7);
		expectedBSTSequence5_4.add(node4);
		expectedBSTSequence5_4.add(node3);
		expectedBSTSequence5_4.add(node6);
		
		LinkedList<Node> expectedBSTSequence5_5 = new LinkedList<Node>();
		expectedBSTSequence5_5.add(node5);
		expectedBSTSequence5_5.add(node7);
		expectedBSTSequence5_5.add(node4);
		expectedBSTSequence5_5.add(node6);
		expectedBSTSequence5_5.add(node3);
		
		LinkedList<Node> expectedBSTSequence5_6 = new LinkedList<Node>();
		expectedBSTSequence5_6.add(node5);
		expectedBSTSequence5_6.add(node7);
		expectedBSTSequence5_6.add(node6);
		expectedBSTSequence5_6.add(node4);
		expectedBSTSequence5_6.add(node3);
		
		LinkedList<LinkedList<Node>> expectedBSTSequence5 = new LinkedList<LinkedList<Node>>();
		expectedBSTSequence5.add(expectedBSTSequence5_1);
		expectedBSTSequence5.add(expectedBSTSequence5_2);
		expectedBSTSequence5.add(expectedBSTSequence5_3);
		expectedBSTSequence5.add(expectedBSTSequence5_4);
		expectedBSTSequence5.add(expectedBSTSequence5_5);
		expectedBSTSequence5.add(expectedBSTSequence5_6);
		
		LinkedList<LinkedList<Node>> actualBSTSequence5 = getBinarySearchTreeSequence(node5);
		
		Assert.assertTrue(LinkedListUtil.compareListOfLists(actualBSTSequence5, expectedBSTSequence5));
	}
	
	private static LinkedList<LinkedList<Node>> getBinarySearchTreeSequence(Node node) {
		// Initializes the results list.
		LinkedList<LinkedList<Node>> results = new LinkedList<LinkedList<Node>>();
		
		// If node is null, this means we reached the end of the binary search tree.
		if (node == null) {
			results.add(new LinkedList<Node>());
			return results;
		}
		
		// Recursively returns the left and right binary search tree sequences.
		LinkedList<LinkedList<Node>> leftBSTSequence = getBinarySearchTreeSequence(node.left);
		LinkedList<LinkedList<Node>> rightBSTSequence = getBinarySearchTreeSequence(node.right);
		
		// Initializes the prefix list.
		LinkedList<Node> prefix = new LinkedList<Node>();
		prefix.add(node);
		
		// Iterates through left and right binary search tree sequences and weaves the current node as the prefix.
		for (LinkedList<Node> left : leftBSTSequence) {
			for (LinkedList<Node> right : rightBSTSequence) {
				// Initializes a weaved list.
				LinkedList<LinkedList<Node>> weaved = new LinkedList<LinkedList<Node>>();
				
				// Weaves the left and right binary search tree sequences after the prefix list.
				weaveList(left, right, prefix, weaved);
				
				// Adds the weaved lists to the results list.
				results.addAll(weaved);
			}
		}
		
		return results;
	}
	
	// This method will weave two lists in all possible ways by keeping elements.
	@SuppressWarnings("unchecked")
	private static void weaveList(LinkedList<Node> first, LinkedList<Node> second, LinkedList<Node> prefix, LinkedList<LinkedList<Node>> results) {
		// If the first list is empty, then add the rest of the elements from second into prefix.
		if (first.isEmpty()) {
			LinkedList<Node> weave = (LinkedList<Node>) prefix.clone();
			weave.addAll(second);
			results.add(weave);
			return;
		}
		else if (second.isEmpty()) {
			LinkedList<Node> weave = (LinkedList<Node>) prefix.clone();
			weave.addAll(first);
			results.add(weave);
			return;
		}
		
		// Removes the first element from first and adds it to the end of prefix.
		Node firstNode = first.removeFirst();
		prefix.addLast(firstNode);
		weaveList(first, second, prefix, results);
		prefix.removeLast();
		first.addFirst(firstNode);
		
		// Removes the first element from second and adds it to the end of prefix.
		Node secondNode = second.removeFirst();
		prefix.addLast(secondNode);
		weaveList(first, second, prefix, results);
		prefix.removeLast();
		second.addFirst(secondNode);
	}
}
