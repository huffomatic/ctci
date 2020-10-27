package com.huffomatic.ctci.common.test;

import com.huffomatic.ctci.common.tree.Node;

public class BinaryTreeScenario {
	public static Node getScenario1() {
		// [1, 2, 3]
		//     2
		//  1     3
		Node node1 = new Node("1");
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
		
		return node2;
	}
	
	public static Node getScenario2() {
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
		
		return node4;
	}
	
	public static Node getScenario3() {
		// [3, 4, 5, 6, 7]
		//        5
		//     4        7
		//  3        6
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		
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
		
		return node5;
	}
	
	public static Node getScenario4() {
		// [3, 4]
		//     4
		//  3
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		
		node4.parent = null;
		node4.left = node3;
		node4.right = null;
		node3.parent = node4;
		node3.left = null;
		node3.right = null;
		
		return node4;
	}
	
	public static Node getScenario5() {
		// [3, 4]
		//  3
		//     4
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		
		node3.parent = null;
		node3.left = null;
		node3.right = node4;
		node4.parent = node3;
		node4.left = null;
		node4.right = null;
		
		return node3;
	}
	
	public static Node getScenario6() {
		// [5, 6, 7]
		//     6
		//  5     7
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		
		node6.parent = null;
		node6.left = node5;
		node6.right = node7;
		node5.parent = node6;
		node5.left = null;
		node5.right = null;
		node7.parent = node6;
		node7.left = null;
		node7.right = null;
		
		return node6;
	}
}
