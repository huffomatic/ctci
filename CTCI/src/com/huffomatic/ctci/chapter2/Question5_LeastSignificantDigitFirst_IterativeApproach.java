package com.huffomatic.ctci.chapter2;

import com.huffomatic.ctci.common.LinkedListUtil;
import com.huffomatic.ctci.common.Node;

/**
 * Sum lists where the 1's digit is head of list.
 * 
 * Input:  (7 -> 1 -> 6) + (5 -> 9 -> 2) = 617 + 295 = 912
 * Output: (2 -> 1 -> 9) = 912
 * 
 * Input:  (7 -> 1 -> 6 -> 9 -> 9 -> 9) + (5 -> 9 -> 9) = 999617 + 599 = 1000612
 * Output: (2 -> 1 -> 6 -> 0 -> 0 -> 0 -> 1) = 1000612
 * 
 * Time:  O(length of list1) + O(length of list2)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question5_LeastSignificantDigitFirst_IterativeApproach {
	public static void main(String[] args) {
		Node result1 = Question5_LeastSignificantDigitFirst_IterativeApproach.addLists(scenario1_list1(), scenario1_list2());
		LinkedListUtil.print(result1);
		
		Node result2 = Question5_LeastSignificantDigitFirst_IterativeApproach.addLists(scenario1_list2(), scenario1_list1());
		LinkedListUtil.print(result2);
		
		Node result3 = Question5_LeastSignificantDigitFirst_IterativeApproach.addLists(scenario2_list1(), scenario2_list2());
		LinkedListUtil.print(result3);
		
		Node result4 = Question5_LeastSignificantDigitFirst_IterativeApproach.addLists(scenario2_list2(), scenario2_list1());
		LinkedListUtil.print(result4);
		
		Node result5 = Question5_LeastSignificantDigitFirst_IterativeApproach.addLists(scenario1_list1(), null);
		LinkedListUtil.print(result5);
		
		Node result6 = Question5_LeastSignificantDigitFirst_IterativeApproach.addLists(null, scenario1_list1());
		LinkedListUtil.print(result6);
		
		Node result7 = Question5_LeastSignificantDigitFirst_IterativeApproach.addLists(null, null);
		LinkedListUtil.print(result7);
	}
	
	public static Node addLists(Node list1, Node list2) {
		Node p1 = list1;
		Node p2 = list2;
		Node head = null;
		Node result = null;
		int carry = 0;
		while (p1 != null || p2 != null) {
			int sum = carry;
			if (p1 != null) {
				sum = sum + p1.data;
				p1 = p1.next;
			}
			if (p2 != null) {
				sum = sum + p2.data;
				p2 = p2.next;
			}
			if (sum >= 10) {
				sum = sum - 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			Node current = new Node(sum);
			current.next = null;
			if (head == null) {
				head = current;
				result = current;
			}
			else {
				result.next = current;
				result = current;
			}
		}
		
		if (carry > 0) {
			Node carryNode = new Node(carry);
			carryNode.next = null;
			result.next = carryNode;
		}
		
		return head;
	}
	
	public static Node scenario1_list1() {
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		return n1;
	}
	
	public static Node scenario1_list2() {
		Node n4 = new Node(5);
		Node n5 = new Node(9);
		Node n6 = new Node(2);
		
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		return n4;
	}
	
	public static Node scenario2_list1() {
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(6);
		Node n4 = new Node(9);
		Node n5 = new Node(9);
		Node n6 = new Node(9);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		return n1;
	}
	
	public static Node scenario2_list2() {
		Node n1 = new Node(5);
		Node n2 = new Node(9);
		Node n3 = new Node(9);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		return n1;
	}
}
