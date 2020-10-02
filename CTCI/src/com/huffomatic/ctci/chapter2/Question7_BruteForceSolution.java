package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;

/**
 * Check if a two linked lists intersect and return the intersecting node.
 * 
 * Input:  1 -> 2 -> 3 -> 4 and 5 -> 6 -> 3 -> 4
 * Output: 3
 * 
 * Input:  1 -> 2 -> 3 -> 4 and 5 -> 6 -> 7 -> 8
 * Output: null
 * 
 * Time:  O(m x n) where m is the length of list1 and n is the length of list2.
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question7_BruteForceSolution {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		
		// Initializes the first list.
		Node firstList = getFirstList(n1, n2, n3, n4, n5, n6, n7, n8);
		
		// Initializes the second list.
		Node secondList = getSecondList(n1, n2, n3, n4, n5, n6, n7, n8);
		
		Assert.assertTrue(findIntersection(firstList, secondList) == n3);
		
		// Initializes the third list.
		Node thirdList = getThirdList(n1, n2, n3, n4, n5, n6, n7, n8);
		
		Assert.assertNull(findIntersection(firstList, thirdList));
	}
	
	public static Node findIntersection(Node list1, Node list2) {
		// Iterate through the first list to see if any nodes match.  If not, then move to the second element
		// in list1 and compare it to all the nodes in list2.  Return null if no nodes match.
		while (list1 != null) {
			Node current = list2;
			while (current != null) {
				if (list1.data == current.data) {
					return current;
				}
				current = current.next;
			}
			list1 = list1.next;
		}
		
		return null;
	}
	
	private static Node getFirstList(Node n1, Node n2, Node n3, Node n4, Node n5, Node n6, Node n7, Node n8) {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		return n1;
	}
	
	private static Node getSecondList(Node n1, Node n2, Node n3, Node n4, Node n5, Node n6, Node n7, Node n8) {
		n5.next = n6;
		n6.next = n3;
		n3.next = n4;
		n4.next = null;
		
		return n5;
	}
	
	private static Node getThirdList(Node n1, Node n2, Node n3, Node n4, Node n5, Node n6, Node n7, Node n8) {
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		
		return n5;
	}
}
