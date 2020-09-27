package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.Result;
import com.huffomatic.ctci.common.test.Scenario;
import com.huffomatic.ctci.common.util.LinkedListUtil;

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
 * Space: O(length of list1) + O(length of list2)
 * 
 * @author huffomatic
 *
 */
public class Question5_LeastSignificantDigitFirst_RecursiveApproach {
	public static void main(String[] args) {
		Node result1 = addLists(Scenario.scenario1_list1(), Scenario.scenario1_list2());
		Assert.assertTrue(LinkedListUtil.compareLists(result1, Result.result1()));
		
		Node result2 = addLists(Scenario.scenario1_list2(), Scenario.scenario1_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result2, Result.result1()));
		
		Node result3 = addLists(Scenario.scenario2_list1(), Scenario.scenario2_list2());
		Assert.assertTrue(LinkedListUtil.compareLists(result3, Result.result2()));
		
		Node result4 = addLists(Scenario.scenario2_list2(), Scenario.scenario2_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result4, Result.result2()));
		
		Node result5 = addLists(Scenario.scenario1_list1(), null);
		Assert.assertTrue(LinkedListUtil.compareLists(result5, Scenario.scenario1_list1()));
		
		Node result6 = addLists(null, Scenario.scenario1_list1());
		Assert.assertTrue(LinkedListUtil.compareLists(result6, Scenario.scenario1_list1()));
		
		Node result7 = addLists(null, null);
		Assert.assertNull(result7);
	}
	
	public static Node addLists(Node list1, Node list2) {
		return addLists(list1, list2, 0);
	}
	
	public static Node addLists(Node list1, Node list2, int carry) {
		if (list1 == null && list2 == null && carry <= 0) {
			return null;
		}
		
		int sum = carry;
		if (list1 != null) {
			sum = sum + list1.data;
			list1 = list1.next;
		}
		if (list2 != null) {
			sum = sum + list2.data;
			list2 = list2.next;
		}
		
		if (sum >= 10) {
			sum = sum - 10;
			carry = 1;
		}
		else {
			carry = 0;
		}
		
		Node current = new Node(sum);
		Node next = addLists(list1, list2, carry);
		current.next = next;
		
		return current;
	}
}
