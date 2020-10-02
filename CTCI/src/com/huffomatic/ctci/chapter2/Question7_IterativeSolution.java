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
 * Time:  O(m + n) where m is the length of list1 and n is the length of list2.
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question7_IterativeSolution {
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
		if (list1 == null || list2 == null) {
			return null;
		}
		
		// Calculate the length of list1.
		int length1 = 0;
		Node current1 = list1;
		Node tail1 = list1;
		while (current1 != null) {
			length1++;
			tail1 = current1;
			current1 = current1.next;
		}
		
		// Calculate the length of list2.
		int length2 = 0;
		Node current2 = list2;
		Node tail2 = list2;
		while (current2 != null) {
			length2++;
			tail2 = current2;
			current2 = current2.next;
		}
		
		// If the tails are equal, then there is an intersecting node.  Else, return null.
		if (tail1 == tail2) {
			current1 = list1;
			current2 = list2;
			
			// Skip the first diff number of elements of the longer list.
			if (length1 > length2) {
				int diff = length1 - length2;
				for (int i = 1; i <= diff; i++) {
					current1 = current1.next;
				}
			}
			else {
				int diff = length2 - length1;
				for (int i = 1; i <= diff; i++) {
					current2 = current2.next;
				}
			}
			
			// Iterate through the lists to find the intersection element.
			while (current1 != null && current2 != null) {
				if (current1 != current2) {
					current1 = current1.next;
					current2 = current2.next;
				}
				else {
					return current1;
				}
			}
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
