package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.Scenario;
import com.huffomatic.ctci.common.util.LinkedListUtil;

/**
 * Check if a linked list is a palindrome.
 * 
 * Input:  0 -> 1 -> 2 -> 1 -> 0
 * Output: true
 * 
 * Input:  0 -> 1 -> 2 -> 2 -> 1 -> 0
 * Output: true
 * 
 * Input:  0 -> 1 -> 2 -> 1 -> 1
 * Output: false
 * 
 * Time:  O(n) where n is the length of the list.
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question6_ReverseApproach_Solution2 {
	public static void main(String[] args) {
		Node list1 = Scenario.scenario7_list1();
		Assert.assertTrue(isPalindrome(list1));
		
		Node list2 = Scenario.scenario7_list2();
		Assert.assertTrue(isPalindrome(list2));
	}
	
	public static boolean isPalindrome(Node list) {
		// Reverse the linked list.
		Node reversedList = reverseList(list);
		
		// Compare to original list.
		return LinkedListUtil.compareLists(list, reversedList);
	}
	
	private static Node reverseList(Node list) {
		Node current = list;
		Node reversedList = null;
		
		// This solution clones the pointer to the list so the original list pointer is not modified.
		while (current != null) {
			Node newNode = new Node(current.data);
			newNode.next = reversedList;
			reversedList = newNode;
			current = current.next;
		}
		
		return reversedList;
	}
}
