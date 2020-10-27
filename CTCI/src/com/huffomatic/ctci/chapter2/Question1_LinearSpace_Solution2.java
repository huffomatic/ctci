package com.huffomatic.ctci.chapter2;

import java.util.HashSet;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.Result;
import com.huffomatic.ctci.common.test.LinkedListScenario;
import com.huffomatic.ctci.common.list.LinkedListUtil;

/**
 * Remove duplicates from an unsorted list.
 * 
 * Input:  (3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1)
 * Output: (3 -> 5 -> 8 -> 10 -> 2 -> 1)
 * 
 * Time:  O(length of list)
 * Space: O(length of list)
 * 
 * @author huffomatic
 *
 */
public class Question1_LinearSpace_Solution2 {
	public static void main(String[] argv) {
		Node result1 = removeDuplicates(LinkedListScenario.scenario5_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result1, Result.result16()));
		
		Node result2 = removeDuplicates(LinkedListScenario.scenario6_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result2, LinkedListScenario.scenario6_list1()));
		
		Node result3 = removeDuplicates(null);
		Assert.assertNull(result3);
	}
	
	public static Node removeDuplicates(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		
		HashSet<Integer> uniqueSet = new HashSet<Integer>();
		Node current = node;
		Node start = null;
		Node end = null;
		while (current != null) {
			Node next = current.next;
			current.next = null;
			if (uniqueSet.contains(current.data)) {
				current = next;
			}
			else {
				uniqueSet.add(current.data);
				if (start == null) {
					start = current;
					end = current;
				}
				else {
					end.next = current;
					end = current;
				}
				current = next;
			}
		}
		
		return start;
	}
}
