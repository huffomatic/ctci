package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.Scenario;
import com.huffomatic.ctci.common.util.LinkedListUtil;

/**
 * Delete a middle element in a singly linked list.
 * The element will not be the last element in the linked list.
 * 
 * Input:  Delete element with value 8 in (3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1)
 * Output: (3 -> 5 -> 5 -> 10 -> 2 -> 1)
 * 
 * Time:  O(1)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question3 {
	public static void main(String[] argv) {
		Node list = Scenario.scenario5_list1();

		boolean result1 = deleteMiddleNode(null);
		Assert.assertFalse(result1);
		
		boolean result2 = deleteMiddleNode(list.next.next.next.next.next.next);
		Assert.assertFalse(result2);
		
		boolean result3 = deleteMiddleNode(list.next.next);
		LinkedListUtil.print(list); // 3 5 5 10 2 1
		Assert.assertTrue(result3);
		
		boolean result4 = deleteMiddleNode(list.next.next);
		LinkedListUtil.print(list); // 3 5 10 2 1
		Assert.assertTrue(result4);
		
		boolean result5 = deleteMiddleNode(list);
		LinkedListUtil.print(list); // 5 10 2 1
		Assert.assertTrue(result5);
	}
	
	public static boolean deleteMiddleNode(Node node) {
		if (node == null || node.next == null) {
			return false;
		}
		
		Node next = node.next;
		node.data = next.data;
		node.next = next.next;
		
		return true;
	}
}
