package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.Result;
import com.huffomatic.ctci.common.test.LinkedListScenario;
import com.huffomatic.ctci.common.list.LinkedListUtil;

/**
 * Partition a linked list around a value x.
 * The left partition is less than x.
 * The right partition is greater than or equal to x.
 * No guarantee of stable elements.
 * 
 * Input:  (3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1), x = 5
 * Output: (1 -> 2 -> 3 -> 5 -> 8 -> 5 -> 10)
 * 
 * Time:  O(length of list)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question4_NotStable {
	public static void main(String[] argv) {
		Node result1 = partition(LinkedListScenario.scenario5_list1(), 5);
		Assert.assertTrue(LinkedListUtil.compareLists(result1, Result.result13()));
		
		Node result2 = partition(LinkedListScenario.scenario5_list1(), 3);
		Assert.assertTrue(LinkedListUtil.compareLists(result2, Result.result13()));
		
		Node result3 = partition(LinkedListScenario.scenario5_list1(), 8);
		Assert.assertTrue(LinkedListUtil.compareLists(result3, Result.result14()));
		
		Node result4 = partition(LinkedListScenario.scenario5_list1(), 1);
		Assert.assertTrue(LinkedListUtil.compareLists(result4, LinkedListScenario.scenario5_list1()));
		
		Node result5 = partition(LinkedListScenario.scenario5_list1(), 11);
		Assert.assertTrue(LinkedListUtil.compareLists(result5, Result.result15()));
	}
	
	public static Node partition(Node head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		
		// Elements smaller than x will go to the head of the result list.
		// Elements larger than or equal to x will go to the end of the result list.
		Node start = head;
		Node end = head;
		Node current = head;
		while (current != null) {
			Node next = current.next;
			if (current.data < x) {
				current.next = start;
				start = current;
			}
			else {
				current.next = null;
				end.next = current;
				end = end.next;
			}
			current = next;
		}
		
		return start;
	}
}
