package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.Result;
import com.huffomatic.ctci.common.test.Scenario;
import com.huffomatic.ctci.common.util.LinkedListUtil;

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
		Node result1 = addLists(Scenario.scenario3_list1(), Scenario.scenario3_list2());
		Assert.assertTrue(LinkedListUtil.compareLists(result1, Result.result3()));
		
		Node result2 = addLists(Scenario.scenario3_list2(), Scenario.scenario3_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result2, Result.result3()));
		
		Node result3 = addLists(Scenario.scenario4_list1(), Scenario.scenario4_list2());
		Assert.assertTrue(LinkedListUtil.compareLists(result3, Result.result4()));
		
		Node result4 = addLists(Scenario.scenario4_list2(), Scenario.scenario4_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result4, Result.result4()));
		
		Node result5 = addLists(Scenario.scenario3_list1(), null);
		Assert.assertTrue(LinkedListUtil.compareLists(result5, Scenario.scenario3_list1()));
		
		Node result6 = addLists(null, Scenario.scenario3_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result6, Scenario.scenario3_list1()));
		
		Node result7 = addLists(null, null);
		Assert.assertNull(result7);
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
		// 1 -> 2 -> 3 -> null
		// current = 1, head = 1, prev = null, next = 2 => current.next = null, prev = 1, current = 2, head = 1
		// current = 2, head = 2, prev = 1, next = 3 => current.next = 1, prev = 2, current = 3, head = 2
		// current = 3, head = 3, prev = 2, next = null => current.next = 2, prev = 3, current = null, head = 3
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
}
