package com.huffomatic.ctci.chapter3;

import java.util.Stack;

import org.junit.Assert;

import com.huffomatic.ctci.common.stack.EmptyStackException;

/**
 * Queue via Stacks: Implement a queue using two stacks.
 * 
 * Time:  O(n) where n is the number of items in the stack.
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question4 {
	private static Stack<Integer> stackNewest = new Stack<Integer>();
	private static Stack<Integer> stackOldest = new Stack<Integer>();
	
	public static void main(String[] args) throws Exception {		
		try {
			peek();
			remove();
			Assert.assertTrue(false);
		} catch (EmptyStackException e) {
			Assert.assertTrue(true);
		}
		Assert.assertTrue(isEmpty());
		add(1);
		Assert.assertFalse(isEmpty());
		add(2);
		Assert.assertTrue(peek() == 1);
		add(3);
		add(4);
		add(5);
		Assert.assertTrue(peek() == 1);
		add(6);
		Assert.assertTrue(peek() == 1);
		Assert.assertFalse(isEmpty());
		remove();
		Assert.assertTrue(peek() == 2);
		remove();
		remove();
		Assert.assertTrue(peek() == 4);
		remove();
		Assert.assertTrue(peek() == 5);
		remove();
		Assert.assertTrue(peek() == 6);
		remove();
		Assert.assertTrue(isEmpty());
		
		// add(1): stack1: { 1 }, stack2: { }
		// add(2): stack1: { 1, 2 }, stack2: { }
		// add(3): stack1: { 1, 2, 3 }, stack2: { }
		// add(4): stack1: { 1, 2, 3, 4 }, stack2: { }
		// peek(): stack1: { }, stack2: { 4, 3, 2, 1 } => return 1
		// remove(): stack1: { }, stack2: { 4, 3, 2 } => return 1
		// remove(): stack1: { }, stack2: { 4, 3 } => return 2
		// add(5): stack1: { 5 }, stack2: { 4, 3 }
		// add(6): stack1: { 5, 6 }, stack2: { 4, 3 }
		// remove(): stack1: { 5, 6 }, stack2: { 4 } => return 3
		// peek(): stack1: { 5, 6 }, stack2: { 4 } => return 4
		// remove(): stack1: { 5, 6 }, stack2: { } => return 4
		// remove(): stack1: { }, stack2: { 6 } => return 5
		// remove(): stack1: { }, stack2: { } => return 6
		add(1);
		add(2);
		add(3);
		add(4);
		Assert.assertTrue(peek() == 1);
		Assert.assertTrue(remove() == 1);
		Assert.assertTrue(remove() == 2);
		add(5);
		add(6);
		Assert.assertTrue(remove() == 3);
		Assert.assertTrue(peek() == 4);
		Assert.assertTrue(remove() == 4);
		Assert.assertTrue(remove() == 5);
		Assert.assertTrue(remove() == 6);
	}
	
	private static void add(int value) {
		stackNewest.add(value);
	}
	
	private static int remove() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else if (stackOldest.isEmpty()) {
			refreshStackOldest();
		}
		int value = stackOldest.pop();
		return value;
	}
	
	private static int peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else if (stackOldest.isEmpty()) {
			refreshStackOldest();
		}
		int value = stackOldest.peek();
		return value;
	}
	
	private static boolean isEmpty() {
		return (stackNewest.isEmpty() && stackOldest.isEmpty());
	}
	
	private static void refreshStackOldest() {
		// Pop all stackNewest and push into stackOldest
		while (!stackNewest.isEmpty()) {
			int value = stackNewest.pop();
			stackOldest.push(value);
		}
	}
}
