package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.scenario.Scenario;
import com.huffomatic.ctci.common.util.LinkedListUtil;

/**
 * Partition a linked list around a value x.
 * The left partition is less than x.
 * The middle partition is equal to x.
 * The right partition is greater than x.
 * 
 * Input:  (3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1), x = 5
 * Output: (3 -> 1 -> 2 -> 5 -> 5 -> 10 -> 8)
 * 
 * Time:  O(length of list)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question4_Stable {
	public static void main(String[] argv) {
		Node result1 = partition(Scenario.scenario5_list1(), 5);
		Assert.assertTrue(LinkedListUtil.compareLists(result1, Scenario.result8()));
		
		Node result2 = partition(Scenario.scenario5_list1(), 3);
		Assert.assertTrue(LinkedListUtil.compareLists(result2, Scenario.result9()));
		
		Node result3 = partition(Scenario.scenario5_list1(), 8);
		Assert.assertTrue(LinkedListUtil.compareLists(result3, Scenario.result10()));
		
		Node result4 = partition(Scenario.scenario5_list1(), 1);
		Assert.assertTrue(LinkedListUtil.compareLists(result4, Scenario.result11()));
		
		Node result5 = partition(Scenario.scenario5_list1(), 11);
		Assert.assertTrue(LinkedListUtil.compareLists(result5, Scenario.scenario5_list1()));
		
		Node result6 = partition(Scenario.scenario5_list1(), 7);
		Assert.assertTrue(LinkedListUtil.compareLists(result6, Scenario.result10()));
	}
	
	public static Node partition(Node head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node runner = head;
		Node smallerStart = null;
		Node smallerEnd = null;
		Node middleStart = null;
		Node middleEnd = null;
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
			else if (runner.data == x) {
				if (middleStart == null) {
					middleStart = runner;
					middleEnd = runner;
				}
				else {
					middleEnd.next = runner;
					middleEnd = runner;
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
			if (middleStart == null) {
				return largerStart;
			}
			else {
				middleEnd.next = largerStart;
				return middleStart;
			}
		}
		else {
			if (middleStart == null) {
				smallerEnd.next = largerStart;
				return smallerStart;
			}
			else {
				smallerEnd.next = middleStart;
				middleEnd.next = largerStart;
				return smallerStart;
			}
		}
	}
}
