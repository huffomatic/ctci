package com.huffomatic.ctci.chapter1;

import org.junit.Assert;

/**
 * Determine if all characters in a string are unique.
 * Assume this characters a through z.
 * No additional data structures are permitted.
 * 
 * Input:  abcdefg
 * Output: true
 * 
 * Input:  abcdabcd
 * Output: false
 * 
 * Time:  O(n) where n is the length of the string.
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question1_Solution2 {
	public static void main(String[] argv) {
		String input1 = "abcdefg";
		Assert.assertTrue(isUniqueChars(input1));
		
		String input2 = "abcdabcd";
		Assert.assertFalse(isUniqueChars(input2));
		
		String input3 = null;
		Assert.assertTrue(isUniqueChars(input3));
		
		String input4 = "abcdefghijklmnopqrstuvwxyza";
		Assert.assertFalse(isUniqueChars(input4));
	}
	
	public static boolean isUniqueChars(String str) {
		if (str == null) {
			return true;
		}
		else if (str.length() > 26) {
			return false;
		}
		
		// Integer is 4 bytes or 32 bits so we can store the 26 character flags in the first 26 bits.
		int found = 0;
		for (int i = 0; i < str.length(); i++) {
			int charVal = str.charAt(i) - 'a';
			if ((found & (1 << charVal)) > 0) {
				return false;
			}
			found = found | (1 << charVal);
		};
		
		return true;
	}
}
