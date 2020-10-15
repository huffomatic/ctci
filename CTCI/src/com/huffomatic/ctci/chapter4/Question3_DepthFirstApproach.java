package com.huffomatic.ctci.chapter4;

import java.util.LinkedList;

import org.junit.Assert;

import com.huffomatic.ctci.common.tree.Node;

/**
 * List of Depths: Create a linked list of all the nodes at each depth in a binary tree.
 * 
 * Time:  O(n) where n is the number of nodes.
 * Space: O(n) where n is the number of nodes.
 * 
 * @author huffomatic
 *
 */
public class Question3_DepthFirstApproach {
	public static void main(String[] args) throws Exception {
		// [1, 2, 3, 4, 5, 6, 7]
		//           4
		//     2           6
		//  1     3     5     7
		
		Node node1 = new Node("1");
		Node node2 = new Node("2");
		Node node3 = new Node("3");
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
		
		LinkedList<Node> expectedDepthList1_1 = new LinkedList<Node>();
		expectedDepthList1_1.add(node4);
		
		LinkedList<Node> expectedDepthList1_2 = new LinkedList<Node>();
		expectedDepthList1_2.add(node2);
		expectedDepthList1_2.add(node6);
		
		LinkedList<Node> expectedDepthList1_3 = new LinkedList<Node>();
		expectedDepthList1_3.add(node1);
		expectedDepthList1_3.add(node3);
		expectedDepthList1_3.add(node5);
		expectedDepthList1_3.add(node7);
		
		LinkedList<LinkedList<Node>> expectedDepthList1 = new LinkedList<LinkedList<Node>>();
		expectedDepthList1.add(expectedDepthList1_1);
		expectedDepthList1.add(expectedDepthList1_2);
		expectedDepthList1.add(expectedDepthList1_3);
		
		LinkedList<LinkedList<Node>> actualDepthList1 = createDepthList(node4);
		
		Assert.assertTrue(compareListOfLists(expectedDepthList1, actualDepthList1));
		
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
		node7.left = null;
		node7.right = node8;

		LinkedList<Node> expectedDepthList2_1 = new LinkedList<Node>();
		expectedDepthList2_1.add(node4);
		
		LinkedList<Node> expectedDepthList2_2 = new LinkedList<Node>();
		expectedDepthList2_2.add(node2);
		expectedDepthList2_2.add(node6);
		
		LinkedList<Node> expectedDepthList2_3 = new LinkedList<Node>();
		expectedDepthList2_3.add(node1);
		expectedDepthList2_3.add(node3);
		expectedDepthList2_3.add(node5);
		expectedDepthList2_3.add(node7);
		
		LinkedList<Node> expectedDepthList2_4 = new LinkedList<Node>();
		expectedDepthList2_4.add(node8);
		
		LinkedList<LinkedList<Node>> expectedDepthList2 = new LinkedList<LinkedList<Node>>();
		expectedDepthList2.add(expectedDepthList2_1);
		expectedDepthList2.add(expectedDepthList2_2);
		expectedDepthList2.add(expectedDepthList2_3);
		expectedDepthList2.add(expectedDepthList2_4);
		
		LinkedList<LinkedList<Node>> actualDepthList2 = createDepthList(node4);
		
		Assert.assertTrue(compareListOfLists(expectedDepthList2, actualDepthList2));
	}
	
	private static LinkedList<LinkedList<Node>> createDepthList(Node root) {
		// This is a depth-first solution where we will have O(log n) levels.
		// However, the recursive space is dwarfed by the O(n) data returned.
		LinkedList<LinkedList<Node>> depthList = new LinkedList<LinkedList<Node>>();
		createDepthList(root, depthList, 0);
		return depthList;
	}
	
	private static void createDepthList(Node node, LinkedList<LinkedList<Node>> depthList, int level) {
		if (node == null) {
			return;
		}
		
		if (depthList.size() == level) {
			LinkedList<Node> currentDepthList = new LinkedList<Node>();
			depthList.add(currentDepthList);
		}
		
		LinkedList<Node> currentDepthList = depthList.get(level);
		currentDepthList.add(node);
		
		createDepthList(node.left, depthList, level + 1);
		createDepthList(node.right, depthList, level + 1);
	}
	
	private static boolean compareListOfLists(LinkedList<LinkedList<Node>> list1, LinkedList<LinkedList<Node>> list2) {
		if (list1 == list2) {
			return true;
		}
		else if (list1 == null && list2 != null) {
			return false;
		}
		else if (list1 != null && list2 == null) {
			return false;
		}
		else if (list1.size() != list2.size()) {
			return false;
		}
		
		for (int index = 0; index < list1.size(); index++) {
			if (!compareLists(list1.get(index), list2.get(index))) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean compareLists(LinkedList<Node> list1, LinkedList<Node> list2) {
		if (list1.size() != list2.size()) {
			return false;
		}
		
		for (int index = 0; index < list1.size(); index++) {
			if (list1.get(index) != list2.get(index)) {
				return false;
			}
		}
		
		return true;
	}
}
