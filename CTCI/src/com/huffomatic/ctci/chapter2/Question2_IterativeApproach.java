package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.LinkedListScenario;
import com.huffomatic.ctci.common.list.LinkedListUtil;

/**
 * Print the kth to last element.  The 1st to last element is the last element.
 * 
 * Input:  (3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1), k = 1
 * Output: 1
 * 
 * Time:  O(length of list)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question2_IterativeApproach {
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
		
		int length = LinkedListUtil.getLength(node);
		
		if (k > length) {
			return null;
		}
		
		int diff = length - k;
		Node p1 = node;
		Node p2 = node;
		
		for (int i = 1; i <= k; i++) {
			p2 = p2.next;
		}
		
		for (int i = 1; i <= diff; i++) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
}
