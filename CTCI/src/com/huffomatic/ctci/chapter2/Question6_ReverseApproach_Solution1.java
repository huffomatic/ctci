package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.Scenario;
import com.huffomatic.ctci.common.list.LinkedListUtil;

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
 * Space: O(n) where n is the length of the list.
 * 
 * @author huffomatic
 *
 */
public class Question6_ReverseApproach_Solution1 {
	public static void main(String[] args) {
		Node list1 = Scenario.scenario7_list1();
		Assert.assertTrue(isPalindrome(list1));
		
		Node list2 = Scenario.scenario7_list2();
		Assert.assertTrue(isPalindrome(list2));
		
		Node list3 = Scenario.scenario7_list3();
		Assert.assertFalse(isPalindrome(list3));
		
		Assert.assertTrue(isPalindrome(null));
		
		Node list4 = Scenario.scenario7_list4();
		Assert.assertTrue(isPalindrome(list4));
		
		Node list5 = Scenario.scenario7_list5();
		Assert.assertFalse(isPalindrome(list5));
	}
	
	public static boolean isPalindrome(Node list) {
		// Reverse the linked list.
		Node reversedList = reverseList(list);
		
		// Compare to original list.
		return LinkedListUtil.compareLists(list, reversedList);
	}
	
	private static Node reverseList(Node list) {
		Node prev = null;
		Node current = list;
		Node reversedList = list;
		
		// 1 -> 2 -> 3 -> null, Need to reverse the linked list and preserve the original list.
		// current = 1, reversedList = 1, prev = null => next = 2, newNode = 1, newNode.next = null, prev = 1 (newNode), current = 2, reversedList = 1 (newNode)
		// current = 2, reversedList = 1, prev = 1 => next = 3, newNode = 2, newNode.next = 1, prev = 2 (newNode), current = next, reversedList = 2 (newNode)
		// current = 3, reversedList = 2, prev = 2 => next = null, newNode = 3, newNode.next = 2, prev = 3 (newNode), current = null, reversedList = 3 (newNode)
		while (current != null) {
			Node next = current.next;
			Node newNode = new Node(current.data);
			newNode.next = prev;
			prev = newNode;
			current = next;
			reversedList = prev;
		}
		
		return reversedList;
	}
}
