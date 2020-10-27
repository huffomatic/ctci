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
 * The value x can appear anywhere in the right partition.
 * 
 * Input:  (3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1)
 * Output: (3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8)
 * 
 * Time:  O(length of list)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question4_MostlyStable {
	public static void main(String[] argv) {
		Node result1 = partition(LinkedListScenario.scenario5_list1(), 5);
		Assert.assertTrue(LinkedListUtil.compareLists(result1, Result.result5()));
		
		Node result2 = partition(LinkedListScenario.scenario5_list1(), 3);
		Assert.assertTrue(LinkedListUtil.compareLists(result2, Result.result6()));
		
		Node result3 = partition(LinkedListScenario.scenario5_list1(), 8);
		Assert.assertTrue(LinkedListUtil.compareLists(result3, Result.result7()));
		
		Node result4 = partition(LinkedListScenario.scenario5_list1(), 1);
		Assert.assertTrue(LinkedListUtil.compareLists(result4, LinkedListScenario.scenario5_list1()));
		
		Node result5 = partition(LinkedListScenario.scenario5_list1(), 11);
		Assert.assertTrue(LinkedListUtil.compareLists(result5, LinkedListScenario.scenario5_list1()));
	}
	
	public static Node partition(Node head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node runner = head;
		Node smallerStart = null;
		Node smallerEnd = null;
		Node largerStart = null;
		Node largerEnd = null;
		
		while (runner != null) {
			Node next = runner.next;
			runner.next = null;
			if (runner.data < x) {
				if (smallerStart == null) {
					smallerStart = runner;
					smallerEnd = runner;
				}
				else {
					smallerEnd.next = runner;
					smallerEnd = runner;
				}
			}
			else {
				if (largerStart == null) {
					largerStart = runner;
					largerEnd = runner;
				}
				else {
					largerEnd.next = runner;
					largerEnd = runner;
				}
			}
			runner = next;
		}
		
		if (smallerStart == null) {
			return largerStart;
		}
		else {
			smallerEnd.next = largerStart;
			return smallerStart;
		}
	}
}
