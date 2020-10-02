package com.huffomatic.ctci.chapter2;

import java.util.Stack;

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
 * Space: O(n) where n is the length of the list.
 * 
 * @author huffomatic
 *
 */
public class Question6_StackApproach {
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
		
		// First find the middle of the list.  We can use a slow and fast pointer to find the midpoint.
		// Ex: 1 -> 2 -> 3 -> 4 -> 5 => slow = 1, fast = 1
		// firstHalf = (), slow = 1, fast = 1 => firstHalf = (1), slow = 2, fast = 3
		// firstHalf = (1), slow = 2, fast = 3 => firstHalf = (1, 2), slow = 3, fast = 5
		Stack<Integer> firstHalf = new Stack<Integer>();
		Node slow = list;
		Node fast = list;
		while ((fast != null) && (fast.next != null)) {
			firstHalf.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// If fast is not null, then we have an odd number of elements so skip the midpoint.
		if (fast != null) {
			slow = slow.next;
		}
		
		// Compare the second half elements to the top of the stack.
		while (slow != null) {
			Integer value = firstHalf.pop().intValue();
			if (value != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}
}
