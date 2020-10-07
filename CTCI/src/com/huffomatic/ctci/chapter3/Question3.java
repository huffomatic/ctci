package com.huffomatic.ctci.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;

import com.huffomatic.ctci.common.stack.EmptyStackException;

/**
 * Stack of Plates: Implement a data structure which mimics a set of stacks as one logical stack
 * 
 * Time:  O(1)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question3 {
	private static final int MAX_SIZE = 5;
	private static List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	
	public static void main(String[] args) throws Exception {
		try {
			peek();
			pop();
			Assert.assertTrue(false);
		} catch (EmptyStackException e) {
			Assert.assertTrue(true);
		}
		Assert.assertTrue(isEmpty());
		push(1);
		Assert.assertFalse(isEmpty());
		push(2);
		Assert.assertTrue(peek() == 2);
		push(3);
		push(4);
		push(5);
		Assert.assertTrue(peek() == 5);
		push(6);
		Assert.assertTrue(peek() == 6);
		Assert.assertFalse(isEmpty());
		pop();
		Assert.assertTrue(peek() == 5);
		pop();
		pop();
		Assert.assertTrue(peek() == 3);
		pop();
		pop();
		pop();
		Assert.assertTrue(isEmpty());
	}
	
	private static void push(int value) {
		Stack<Integer> lastStack = getLastStack();
		if ((lastStack == null) || (lastStack.size() == MAX_SIZE)) {
			lastStack = new Stack<Integer>();
			lastStack.push(value);
			stacks.add(lastStack);
		}
		else {
			lastStack.push(value);
		}
	}
	
	private static int pop() throws EmptyStackException {
		Stack<Integer> lastStack = getLastStack();
		if (lastStack == null) {
			throw new EmptyStackException();
		}
		int value = lastStack.pop();
		if (lastStack.isEmpty()) {
			stacks.remove(getNumberOfStacks() - 1);
		}
		return value;
	}
	
	private static int peek() throws EmptyStackException {
		Stack<Integer> lastStack = getLastStack();
		if (lastStack == null) {
			throw new EmptyStackException();
		}
		int value = lastStack.peek();
		return value;
	}
	
	private static boolean isEmpty() {
		Stack<Integer> lastStack = getLastStack();
		return (lastStack == null);
	}
	
	private static Stack<Integer> getLastStack() {
		int numOfStacks = getNumberOfStacks();
		if (numOfStacks > 0) {
			return stacks.get(numOfStacks - 1);
		}
		else {
			return null;
		}
	}
	
	private static int getNumberOfStacks() {
		return stacks.size();
	}
}
