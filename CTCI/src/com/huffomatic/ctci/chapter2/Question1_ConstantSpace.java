package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.Result;
import com.huffomatic.ctci.common.test.Scenario;
import com.huffomatic.ctci.common.list.LinkedListUtil;

/**
 * Remove duplicates from an unsorted list.  No extra space allowed.
 * 
 * Input:  (3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1)
 * Output: (3 -> 5 -> 8 -> 10 -> 2 -> 1)
 * 
 * Time:  O(length of list ^2)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question1_ConstantSpace {
	public static void main(String[] argv) {
		Node result1 = removeDuplicates(Scenario.scenario5_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result1, Result.result16()));
		
		Node result2 = removeDuplicates(Scenario.scenario6_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result2, Scenario.scenario6_list1()));
		
		Node result3 = removeDuplicates(null);
		Assert.assertNull(result3);
	}
	
	public static Node removeDuplicates(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		
		Node current = node;
		while (current != null) {
			Node prev = current;
			Node next = current.next;
			while (next != null) {
				if (current.data == next.data) {
					prev.next = next.next;
				}
				prev = next;
				next = next.next;
			}
			current = current.next;
		}
		
		return node;
	}
}
