package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.test.Scenario;

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
public class Question6_ReverseApproach_Solution3 {
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
		if ((list == null) || (list.next == null) || (list.data == list.next.data)) {
			return true;
		}
		
		// Find the beginning of the second half of the list.
		Node secondHalf = findSecondHalf(list);
		
		// Reverse the second half of the list.
		secondHalf = reverseList(secondHalf);
		
		// Compare the two lists to see if they are equal.
		Node firstHalf = list;
		while (secondHalf != null) {
			if (firstHalf.data != secondHalf.data) {
				return false;
			}
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}
		
		return true;
	}
	
	private static Node findSecondHalf(Node list) {
		// First find the middle of the list.  We can use a slow and fast pointer to find the midpoint.
		Node slow = list;
		Node fast = list;
		while ((fast != null) && (fast.next != null)) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// If fast is not null, then we have an odd number of elements so skip the midpoint.
		if (fast != null) {
			slow = slow.next;
		}
		
		return slow;
	}
	
	private static Node reverseList(Node list) {
		Node prev = null;
		Node current = list;
		Node head = list;
		
		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			head = prev;
		}
		
		return head;
	}
}
