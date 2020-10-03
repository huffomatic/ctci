package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;

/**
 * Check if a linked list has a loop and return the node where the loop starts.
 * 
 * Input:  1 -> 2 -> 3 -> 4 -> 2
 * Output: 2
 * 
 * Input:  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
 * Output: null
 * 
 * Time:  O(n) where n is the length of the list.
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question8 {
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
		Node list1 = getFirstList(n1, n2, n3, n4, n5, n6, n7, n8);
		Assert.assertTrue(findLoop(list1) == n2);
		Assert.assertTrue(findK(list1) == 1);
		Assert.assertTrue(findLoopSize(list1) == 3);
		Assert.assertTrue(findListSize(list1) == 4);
		
		// Initializes the second list.
		Node list2 = getSecondList(n1, n2, n3, n4, n5, n6, n7, n8);
		Assert.assertNull(findLoop(list2));
		Assert.assertTrue(findK(list2) == -1);
		Assert.assertTrue(findLoopSize(list2) == -1);
		Assert.assertTrue(findListSize(list2) == -1);
		
		// Initializes the third list.
		Node list3 = getThirdList(n1, n2, n3, n4, n5, n6, n7, n8);
		Assert.assertTrue(findLoop(list3) == n4);
		Assert.assertTrue(findK(list3) == 3);
		Assert.assertTrue(findLoopSize(list3) == 5);
		Assert.assertTrue(findListSize(list3) == 8);
		
		// Initializes the fourth list.
		Node list4 = getFourthList(n1, n2, n3, n4, n5, n6, n7, n8);
		Assert.assertTrue(findLoop(list4) == n1);
		Assert.assertTrue(findK(list4) == 0);
		Assert.assertTrue(findLoopSize(list4) == 8);
		Assert.assertTrue(findListSize(list4) == 8);
		
		// Initializes the fifth list.
		Node list5 = getFifthList(n1, n2, n3, n4, n5, n6, n7, n8);
		Assert.assertTrue(findLoop(list5) == n8);
		Assert.assertTrue(findK(list5) == 7);
		Assert.assertTrue(findLoopSize(list5) == 1);
		Assert.assertTrue(findListSize(list5) == 8);
		
		// Initializes the sixth list.
		Node list6 = null;
		Assert.assertNull(findLoop(list6));
		Assert.assertTrue(findK(list6) == -1);
		Assert.assertTrue(findLoopSize(list6) == -1);
		Assert.assertTrue(findListSize(list6) == -1);
		
		// Initializes the seventh list.
		Node list7 = new Node(1);
		list7.next = null;
		Assert.assertNull(findLoop(list7));
		Assert.assertTrue(findK(list7) == -1);
		Assert.assertTrue(findLoopSize(list7) == -1);
		Assert.assertTrue(findListSize(list7) == -1);
	}
	
	public static Node findLoop(Node list) {
		// Initializes two pointers and set them to the start of the list.
		Node slow = list;
		Node fast = list;
		
		// Move fast pointer two steps for every one step slow pointer goes.  If they point to the same node, then break the loop.
		// A collision will occur LOOP_SIZE - k steps after the start of the loop or k steps before the start of the loop.
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		
		// If the fast pointer reached the end of the list without finding an overlapping node, then return null.
		if (fast == null || fast.next == null) {
			return null;
		}
		
		// Move the fast pointer back to the start of the list.
		fast = list;
		
		// Move each pointer again but now at the same speed and break when the two pointers are the same.
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		// Return the start of the list.
		return slow;
	}
	
	public static int findK(Node list) {
		// Initializes two pointers and set them to the start of the list.
		Node slow = list;
		Node fast = list;
		
		// Move fast pointer two steps for every one step slow pointer goes.  If they point to the same node, then break the loop.
		// A collision will occur LOOP_SIZE - k steps after the start of the loop or k steps before the start of the loop.
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		
		// If the fast pointer reached the end of the list without finding an overlapping node, then return -1.
		if (fast == null || fast.next == null) {
			return -1;
		}
		
		// Move the fast pointer back to the start of the list.
		fast = list;
		
		// Initializes k.
		int k = 0;
		
		// Move each pointer again but now at the same speed and break when the two pointers are the same.
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
			k++;
		}
		
		// Return k.
		return k;
	}
	
	public static int findLoopSize(Node list) {
		// Initializes two pointers and set them to the start of the list.
		Node slow = list;
		Node fast = list;
		
		// Move fast pointer two steps for every one step slow pointer goes.  If they point to the same node, then break the loop.
		// A collision will occur LOOP_SIZE - k steps after the start of the loop or k steps before the start of the loop.
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		
		// If the fast pointer reached the end of the list without finding an overlapping node, then return -1.
		if (fast == null || fast.next == null) {
			return -1;
		}
		
		// Move the fast pointer back to the start of the list.
		fast = list;
		
		// Move each pointer again but now at the same speed and break when the two pointers are the same.
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		// The slow pointer currently points to the start of list so iterate through the loop until you arrive back at the start node.
		int loopSize = 1;
		Node start = slow;
		while (slow.next != start) {
			slow = slow.next;
			loopSize++;
		}
		
		return loopSize;
	}
	
	public static int findListSize(Node list) {
		int k = findK(list);
		int loopSize = findLoopSize(list);
		
		if (k != -1 && loopSize != -1) {
			return (k + loopSize);
		}
		else {
			return -1;
		}
	}
	
	private static Node getFirstList(Node n1, Node n2, Node n3, Node n4, Node n5, Node n6, Node n7, Node n8) {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		
		return n1;
	}
	
	private static Node getSecondList(Node n1, Node n2, Node n3, Node n4, Node n5, Node n6, Node n7, Node n8) {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		
		return n1;
	}
	
	private static Node getThirdList(Node n1, Node n2, Node n3, Node n4, Node n5, Node n6, Node n7, Node n8) {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n4;
		
		return n1;
	}
	
	private static Node getFourthList(Node n1, Node n2, Node n3, Node n4, Node n5, Node n6, Node n7, Node n8) {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n1;
		
		return n1;
	}
	
	private static Node getFifthList(Node n1, Node n2, Node n3, Node n4, Node n5, Node n6, Node n7, Node n8) {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n8;
		
		return n1;
	}
}
