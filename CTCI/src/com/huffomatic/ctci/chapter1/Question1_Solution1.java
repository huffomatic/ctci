package com.huffomatic.ctci.chapter1;

import org.junit.Assert;

/**
 * Determine if all characters in a string are unique.
 * Assume this is ASCII (128 characters).
 * Extended ASCII is 256 characters.
 * 
 * Input:  abcdefg
 * Output: true
 * 
 * Input:  abcdabcd
 * Output: false
 * 
 * Time:  O(min(n, c)) where n is the length of the string and c is the character set length
 * Space: O(c) where c is the character set length
 * 
 * @author huffomatic
 *
 */
public class Question1_Solution1 {
	public static void main(String[] argv) {
		String input1 = "abcdefg";
		Assert.assertTrue(isUniqueChars(input1));
		
		String input2 = "abcdabcd";
		Assert.assertFalse(isUniqueChars(input2));
		
		String input3 = null;
		Assert.assertTrue(isUniqueChars(input3));
	}
	
	public static boolean isUniqueChars(String str) {
		if (str == null) {
			return true;
		}
		else if (str.length() > 128) {
			return false;
		}
		
		boolean[] found = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int charVal = str.charAt(i);
			if (found[charVal]) {
				return false;
			}
			else {
				found[charVal] = true;
			}
		}
		
		return true;
	}
}
