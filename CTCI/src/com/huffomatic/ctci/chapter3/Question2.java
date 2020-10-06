package com.huffomatic.ctci.chapter3;

import java.util.Stack;

import org.junit.Assert;

/**
 * Design a stack which has a function min and runs in O(1) time.
 * 
 * Time:  O(1)
 * Space: O(n) where n is the length of the array.
 * 
 * @author huffomatic
 *
 */
public class Question2 {
	private static Stack<Integer> data = new Stack<Integer>();
	private static Stack<Integer> mins = new Stack<Integer>();
	private static Stack<Integer> maxs = new Stack<Integer>();
	
	public static void main(String[] args) throws Exception {
		push(1);
		push(2);
		push(3);
		
		Assert.assertTrue(peek() == 3);
		Assert.assertTrue(pop() == 3);
		Assert.assertFalse(isEmpty());
		Assert.assertTrue(pop() == 2);
		Assert.assertTrue(pop() == 1);
		Assert.assertTrue(isEmpty());
		
		Assert.assertTrue(min() == Integer.MAX_VALUE);
		
		push(10); 						// data: { 10 }, mins: { 10 }, maxs: { 10 }
		Assert.assertTrue(min() == 10); // data: { 10 }, mins: { 10 }, maxs: { 10 }
		Assert.assertTrue(max() == 10); // data: { 10 }, mins: { 10 }, maxs: { 10 }
		
		push(20); 						// data: { 10, 20 }, mins: { 10 }, maxs: { 10, 20 }
		Assert.assertTrue(min() == 10); // data: { 10, 20 }, mins: { 10 }, maxs: { 10, 20 }
		Assert.assertTrue(max() == 20); // data: { 10, 20 }, mins: { 10 }, maxs: { 10, 20 }
		
		push(9); 						// data: { 10, 20, 9 }, mins: { 10, 9 }, maxs: { 10, 20 }
		Assert.assertTrue(min() == 9);  // data: { 10, 20, 9 }, mins: { 10, 9 }, maxs: { 10, 20 }
		Assert.assertTrue(max() == 20); // data: { 10, 20, 9 }, mins: { 10, 9 }, maxs: { 10, 20 }
		
		push(11); 						// data: { 10, 20, 9, 11 }, mins: { 10, 9 }, maxs: { 10, 20 }
		Assert.assertTrue(min() == 9);  // data: { 10, 20, 9, 11 }, mins: { 10, 9 }, maxs: { 10, 20 }
		Assert.assertTrue(max() == 20); // data: { 10, 20, 9, 11 }, mins: { 10, 9 }, maxs: { 10, 20 }
		
		Assert.assertTrue(pop() == 11); // data: { 10, 20, 9 }, mins: { 10, 9 }, maxs: { 10, 20 }
		Assert.assertTrue(min() == 9);  // data: { 10, 20, 9 }, mins: { 10, 9 }, maxs: { 10, 20 }
		Assert.assertTrue(max() == 20); // data: { 10, 20, 9 }, mins: { 10, 9 }, maxs: { 10, 20 }
		
		Assert.assertTrue(pop() == 9);  // data: { 10, 20 }, mins: { 10 }, maxs: { 10, 20 }
		Assert.assertTrue(min() == 10); // data: { 10, 20 }, mins: { 10 }, maxs: { 10, 20 }
		Assert.assertTrue(max() == 20);
		
		Assert.assertTrue(pop() == 20); // data: { 10 }, mins: { 10 }, maxs: { 10, 20 }
		Assert.assertTrue(min() == 10); // data: { 10 }, mins: { 10 }, maxs: { 10 }
		Assert.assertTrue(max() == 10); // data: { 10 }, mins: { 10 }, maxs: { 10 }
		
		Assert.assertTrue(pop() == 10); 				// data: { }, mins: MAX_VALUE, maxs: MIN_VALUE
		Assert.assertTrue(min() == Integer.MAX_VALUE);  // data: { }, mins: MAX_VALUE, maxs: MIN_VALUE
		Assert.assertTrue(max() == Integer.MIN_VALUE);  // data: { }, mins: MAX_VALUE, maxs: MIN_VALUE
		
		push(Integer.MAX_VALUE);						// data: { MAX_VALUE }, mins: { }, maxs: { MAX_VALUE }
		Assert.assertTrue(min() == Integer.MAX_VALUE);  // data: { MAX_VALUE }, mins: { }, maxs: { MAX_VALUE }
		Assert.assertTrue(max() == Integer.MAX_VALUE);  // data: { MAX_VALUE }, mins: { }, maxs: { MAX_VALUE }
		
		push(Integer.MIN_VALUE);						// data: { MAX_VALUE, MIN_VALUE }, mins: { MIN_VALUE }, maxs: { MAX_VALUE }
		Assert.assertTrue(min() == Integer.MIN_VALUE);  // data: { MAX_VALUE, MIN_VALUE }, mins: { MIN_VALUE }, maxs: { MAX_VALUE }
		Assert.assertTrue(max() == Integer.MAX_VALUE);  // data: { MAX_VALUE, MIN_VALUE }, mins: { MIN_VALUE }, maxs: { MAX_VALUE }
		
		Assert.assertTrue(pop() == Integer.MIN_VALUE); 	// data: { MAX_VALUE }, mins: MAX_VALUE, maxs: { MAX_VALUE }
		Assert.assertTrue(min() == Integer.MAX_VALUE);  // data: { MAX_VALUE }, mins: MAX_VALUE, maxs: { MAX_VALUE }
		Assert.assertTrue(max() == Integer.MAX_VALUE);  // data: { MAX_VALUE }, mins: MAX_VALUE, maxs: { MAX_VALUE }
		
		Assert.assertTrue(pop() == Integer.MAX_VALUE); 	// data: { }, mins: MAX_VALUE, maxs: MIN_VALUE
		Assert.assertTrue(min() == Integer.MAX_VALUE);  // data: { }, mins: MAX_VALUE, maxs: MIN_VALUE
		Assert.assertTrue(max() == Integer.MIN_VALUE);  // data: { }, mins: MAX_VALUE, maxs: MIN_VALUE
		
		push(1);						// data: { 1 }, mins: { 1 }, maxs: { 1 }
		Assert.assertTrue(min() == 1);  // data: { 1 }, mins: { 1 }, maxs: { 1 }
		Assert.assertTrue(max() == 1);  // data: { 1 }, mins: { 1 }, maxs: { 1 }
		
		push(1);						// data: { 1, 1 }, mins: { 1, 1 }, maxs: { 1, 1 }
		Assert.assertTrue(min() == 1);  // data: { 1, 1 }, mins: { 1, 1 }, maxs: { 1, 1 }
		Assert.assertTrue(max() == 1);  // data: { 1, 1 }, mins: { 1, 1 }, maxs: { 1, 1 }
		
		push(2);						// data: { 1, 1, 2 }, mins: { 1, 1 }, maxs: { 1, 1, 2 }
		Assert.assertTrue(min() == 1);  // data: { 1, 1, 2 }, mins: { 1, 1 }, maxs: { 1, 1, 2 }
		Assert.assertTrue(max() == 2);  // data: { 1, 1, 2 }, mins: { 1, 1 }, maxs: { 1, 1, 2 }
		
		push(2);						// data: { 1, 1, 2, 2 }, mins: { 1, 1 }, maxs: { 1, 1, 2, 2 }
		Assert.assertTrue(min() == 1);  // data: { 1, 1, 2, 2 }, mins: { 1, 1 }, maxs: { 1, 1, 2, 2 }
		Assert.assertTrue(max() == 2);  // data: { 1, 1, 2, 2 }, mins: { 1, 1 }, maxs: { 1, 1, 2, 2 }
		
		Assert.assertTrue(pop() == 2);  // data: { 1, 1, 2 }, mins: { 1, 1 }, maxs: { 1, 1, 2 }
		Assert.assertTrue(min() == 1);  // data: { 1, 1, 2 }, mins: { 1, 1 }, maxs: { 1, 1, 2 }
		Assert.assertTrue(max() == 2);  // data: { 1, 1, 2 }, mins: { 1, 1 }, maxs: { 1, 1, 2 }
		
		Assert.assertTrue(pop() == 2);  // data: { 1, 1 }, mins: { 1, 1 }, maxs: { 1, 1 }
		Assert.assertTrue(min() == 1);  // data: { 1, 1 }, mins: { 1, 1 }, maxs: { 1, 1 }
		Assert.assertTrue(max() == 1);  // data: { 1, 1 }, mins: { 1, 1 }, maxs: { 1, 1 }
		
		Assert.assertTrue(pop() == 1);  // data: { 1 }, mins: { 1 }, maxs: { 1 }
		Assert.assertTrue(min() == 1);  // data: { 1 }, mins: { 1 }, maxs: { 1 }
		Assert.assertTrue(max() == 1);  // data: { 1 }, mins: { 1 }, maxs: { 1 }
		
		Assert.assertTrue(pop() == 1);  				// data: { }, mins: MAX_VALUE, maxs: MIN_VALUE
		Assert.assertTrue(min() == Integer.MAX_VALUE);  // data: { }, mins: MAX_VALUE, maxs: MIN_VALUE
		Assert.assertTrue(max() == Integer.MIN_VALUE);  // data: { }, mins: MAX_VALUE, maxs: MIN_VALUE
	}
	
	private static void push(int value) {
		if (value <= min()) {
			mins.push(value);
		}
		if (value >= max()) {
			maxs.push(value);
		}
		data.push(value);
	}
	
	private static int pop() {
		int value = data.pop();
		if (value == min()) {
			mins.pop();
		}
		if (value == max()) {
			maxs.pop();
		}
		return value;
	}
	
	private static int peek() {
		return data.peek();
	}
	
	private static boolean isEmpty() {
		return data.isEmpty();
	}
	
	private static int min() {
		if (data.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else {
			return mins.peek();
		}
	}
	
	private static int max() {
		if (data.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		else {
			return maxs.peek();
		}
	}
}
