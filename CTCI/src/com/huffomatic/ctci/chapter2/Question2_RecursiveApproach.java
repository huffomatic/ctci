package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Index;
import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.LinkedListScenario;

/**
 * Print the kth to last element.  The 1st last element is the last element.
 * 
 * Input:  (3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1), k = 1
 * Output: 1
 * 
 * Time:  O(length of list)
 * Space: O(length of list)
 * 
 * @author huffomatic
 *
 */
public class Question2_RecursiveApproach {
	public static void main(String[] argv) {
		Node list = LinkedListScenario.scenario5_list1();

		Node result1 = printKthToLast(list, 1);
		Assert.assertTrue(result1 == list.next.next.next.next.next.next);
		
		Node result2 = printKthToLast(list, 4);
		Assert.assertTrue(result2 == list.next.next.next);
		
		Node result3 = printKthToLast(list, 0);
		Assert.assertNull(result3);
		
		Node result4 = printKthToLast(list, 8);
		Assert.assertNull(result4);
	}
	
	public static Node printKthToLast(Node node, int k) {
		if (k <= 0) {
			return null;
		}
		
		Index index = new Index();
		index.value = 0;
		
		return printKthToLast(node, k, index);
	}
	
	public static Node printKthToLast(Node current, int k, Index index) {
		if (current == null) {
			return null;
		}
		
		Node next = printKthToLast(current.next, k, index);
		
		index.value = index.value + 1;
		
		if (k == index.value) {
			return current;
		}
		else {
			return next;
		}
	}
}
