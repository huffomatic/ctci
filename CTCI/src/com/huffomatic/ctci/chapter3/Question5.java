package com.huffomatic.ctci.chapter3;

import java.util.Stack;

import org.junit.Assert;

import com.huffomatic.ctci.common.stack.EmptyStackException;

/**
 * Sort Stack: Sort a stack so that the smallest items are on top.
 * 
 * Time:  O(n^2) where n is the number of items in the stack.
 * Space: O(n) where n is the number of items in the stack.
 * 
 * @author huffomatic
 *
 */
public class Question5 {
	private static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) throws Exception {
		Assert.assertTrue(isEmpty());
		push(5);
		Assert.assertTrue(peek() == 5);
		push(6);
		Assert.assertTrue(peek() == 5);
		push(7);
		Assert.assertTrue(peek() == 5);
		push(3);
		Assert.assertTrue(peek() == 3);
		push(1);
		Assert.assertTrue(peek() == 1);
		Assert.assertFalse(isEmpty());
		Assert.assertTrue(pop() == 1);
		Assert.assertTrue(pop() == 3);
		Assert.assertTrue(pop() == 5);
		Assert.assertTrue(pop() == 6);
		Assert.assertTrue(pop() == 7);
	}
	
	private static void push(int value) {
		// Initializes the temporary stack.
		Stack<Integer> tempStack = new Stack<Integer>();
		
		// Move elements less than value over to temporary stack.
		while (!stack.isEmpty()) {
			int sortedValue = stack.peek();
			if (sortedValue < value) {
				sortedValue = stack.pop();
				tempStack.push(sortedValue);
			}
			else {
				break;
			}
		}
		
		// Add value to temporary stack.
		tempStack.push(value);
		
		// Move all elements from temporary stack to the original stack.
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}
	
	private static int pop() throws EmptyStackException {
		return stack.pop();
	}
	
	private static int peek() throws EmptyStackException {
		return stack.peek();
	}
	
	private static boolean isEmpty() {
		return stack.isEmpty();
	}
}
