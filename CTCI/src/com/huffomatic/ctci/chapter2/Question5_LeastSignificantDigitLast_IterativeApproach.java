package com.huffomatic.ctci.chapter2;

import com.huffomatic.ctci.common.LinkedListUtil;
import com.huffomatic.ctci.common.Node;

/**
 * Sum lists where the 1's digit is head of list.
 * 
 * Input:  (6 -> 1 -> 7) + (2 -> 9 -> 5) = 617 + 295 = 912
 * Output: (9 -> 1 -> 2) = 912
 * 
 * Input:  (9 -> 9 -> 9 -> 6 -> 1 -> 7) + (9 -> 9 -> 5) = 999617 + 995 = 1000612
 * Output: (1 -> 0 -> 0 -> 0 -> 6 -> 1 -> 2) = 1000612
 * 
 * Time:  O(length of list1) + O(length of list2)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question5_LeastSignificantDigitLast_IterativeApproach {
	public static void main(String[] args) {
		Node result1 = Question5_LeastSignificantDigitLast_IterativeApproach.addLists(scenario1_list1(), scenario1_list2());
		LinkedListUtil.print(result1);
		
		Node result2 = Question5_LeastSignificantDigitLast_IterativeApproach.addLists(scenario1_list2(), scenario1_list1());
		LinkedListUtil.print(result2);
		
		Node result3 = Question5_LeastSignificantDigitLast_IterativeApproach.addLists(scenario2_list1(), scenario2_list2());
		LinkedListUtil.print(result3);
		
		Node result4 = Question5_LeastSignificantDigitLast_IterativeApproach.addLists(scenario2_list2(), scenario2_list1());
		LinkedListUtil.print(result4);
		
		Node result5 = Question5_LeastSignificantDigitLast_IterativeApproach.addLists(scenario2_list1(), null);
		LinkedListUtil.print(result5);
		
		Node result6 = Question5_LeastSignificantDigitLast_IterativeApproach.addLists(null, scenario2_list1());
		LinkedListUtil.print(result6);
		
		Node result7 = Question5_LeastSignificantDigitLast_IterativeApproach.addLists(null, null);
		LinkedListUtil.print(result7);
	}
	
	public static Node addLists(Node list1, Node list2) {
		// Compare lengths, find difference in lengths, and swap pointers so p1 is the longer list.
		Node p1 = list1;
		Node p2 = list2;
		int length1 = LinkedListUtil.getLength(list1);
		int length2 = LinkedListUtil.getLength(list2);
		int diff = 0;
		if (length1 < length2) {
			p1 = list2;
			p2 = list1;
			diff = length2 - length1;
		}
		else {
			diff = length1 - length2;
		}
		
		// Add the first diff nodes from p1 to result.
		Node head = null;
		for (int i = 1; i <= diff; i++) {
			Node current = new Node(p1.data);
			if (head == null) {
				current.next = null;
				head = current;
			}
			else {
				current.next = head;
				head = current;
			}
			p1 = p1.next;
		}
		
		// Iterate through p1 and p2 by finding sum, keeping overflow in node, then add current node to result and reverse list.
		while (p1 != null && p2 != null) {
			int sum = p1.data + p2.data;
			p1 = p1.next;
			p2 = p2.next;
			Node current = new Node(sum);
			if (head == null) {
				current.next = null;
				head = current;
			}
			else {
				current.next = head;
				head = current;
			}
		}
		
		// Normalize the result list by starting at least significant digit and carry overflow and reversing result list.
		Node prev = null;
		Node current = head;
		int carry = 0;
		while (current != null) {
			int sum = current.data + carry;
			if (sum >= 10) {
				sum = sum - 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			current.data = sum;
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			head = prev;
		}
		
		// If carry is greater than zero, then add carry node to head of result list.
		if (carry > 0) {
			Node carryNode = new Node(carry);
			carryNode.next = head;
			head = carryNode;
		}
		
		return head;
	}
	
	public static Node scenario1_list1() {
		Node n1 = new Node(6);
		Node n2 = new Node(1);
		Node n3 = new Node(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		return n1;
	}
	
	public static Node scenario1_list2() {
		Node n1 = new Node(2);
		Node n2 = new Node(9);
		Node n3 = new Node(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		return n1;
	}
	
	public static Node scenario2_list1() {
		Node n1 = new Node(9);
		Node n2 = new Node(9);
		Node n3 = new Node(9);
		Node n4 = new Node(6);
		Node n5 = new Node(1);
		Node n6 = new Node(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		return n1;
	}
	
	public static Node scenario2_list2() {
		Node n1 = new Node(9);
		Node n2 = new Node(9);
		Node n3 = new Node(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		return n1;
	}
}
