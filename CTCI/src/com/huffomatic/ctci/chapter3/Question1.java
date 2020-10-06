package com.huffomatic.ctci.chapter3;

import org.junit.Assert;

import com.huffomatic.ctci.common.stack.EmptyStackException;
import com.huffomatic.ctci.common.stack.FullStackException;

/**
 * Use a single array to implement three stacks.
 * Fixed sized stacks.
 * 
 * Time:  O(1)
 * Space: O(n) where n is the length of the array.
 * 
 * @author huffomatic
 *
 */
public class Question1 {
	private static int stackSize = 10;
	private static int[] data = new int[stackSize * 3];
	private static int[] topIndices = { -1, -1, -1 };
	
	public static void main(String[] args) throws Exception {
		push(0, 1);
		push(0, 2);
		push(0, 3);
		
		Assert.assertTrue(peek(0) == 3);
		Assert.assertTrue(pop(0) == 3);
		Assert.assertFalse(isEmpty(0));
		Assert.assertTrue(pop(0) == 2);
		Assert.assertTrue(pop(0) == 1);
		Assert.assertTrue(isEmpty(0));
		
		push(0, 1);
		push(1, 11);
		push(2, 21);
		push(0, 2);
		push(1, 12);
		push(2, 22);
		Assert.assertTrue(peek(0) == 2);
		Assert.assertTrue(peek(1) == 12);
		Assert.assertTrue(peek(2) == 22);
		Assert.assertFalse(isEmpty(0));
		Assert.assertFalse(isEmpty(1));
		Assert.assertFalse(isEmpty(2));
		push(2, 23);
		push(2, 24);
		push(2, 25);
		push(2, 26);
		push(2, 27);
		push(2, 28);
		push(2, 29);
		push(2, 30);
		try {
			push(2, 31);
			Assert.assertTrue(false);
		} catch (FullStackException e) {
			Assert.assertTrue(true);
		}
		
		Assert.assertTrue(pop(0) == 2);
		Assert.assertTrue(pop(0) == 1);
		try {
			pop(0);
			Assert.assertTrue(false);
		} catch (EmptyStackException e) {
			Assert.assertTrue(true);
		}
	}
	
	private static void push(int stackNumber, int value) throws FullStackException {
		if ((topIndices[stackNumber] + 1) >= stackSize) {
			throw new FullStackException();
		}
		int index = stackNumber * stackSize + topIndices[stackNumber] + 1;
		data[index] = value;
		topIndices[stackNumber] = topIndices[stackNumber] + 1;
	}
	
	private static int pop(int stackNumber) throws EmptyStackException {
		if (topIndices[stackNumber] == -1) {
			throw new EmptyStackException();
		}
		int index = stackNumber * stackSize + topIndices[stackNumber];
		int value = data[index];
		topIndices[stackNumber] = topIndices[stackNumber] - 1;
		return value;
	}
	
	private static int peek(int stackNumber) throws EmptyStackException {
		if (topIndices[stackNumber] == -1) {
			throw new EmptyStackException();
		}
		int index = stackNumber * stackSize + topIndices[stackNumber];
		int value = data[index];
		return value;
	}
	
	private static boolean isEmpty(int stackNumber) {
		return (topIndices[stackNumber] == -1);
	}
}
