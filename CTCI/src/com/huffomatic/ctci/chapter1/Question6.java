package com.huffomatic.ctci.chapter1;

import org.junit.Assert;

/**
 * Perform basic string compression using the counts of repeat characters.
 * Only return the compressed string if the size is less than the original string.
 * Assume characters 'a' to 'z'.
 * 
 * Input:  str = "aabcccccaaa"
 * Output: compressedStr = "a2b1c5ae" so return "a2b1c5a3"
 * 
 * Input:  str = "aabbccdd"
 * Output: compressedStr = "a2b2c2d2" so return "aabbccdd"
 * 
 * Input:  str = "abcd"
 * Output: compressedStr = "a1b1c1d1" so return "abcd"
 * 
 * Time:  O(n) where n is the length of str
 * Space: O(1) 
 * 
 * @author huffomatic
 *
 */
public class Question6 {
	public static void main(String[] argv) {
		Assert.assertTrue(compress("aabcccccaaa").equals("a2b1c5a3"));
		Assert.assertTrue(compress("aabbccdd").equals("aabbccdd"));
		Assert.assertTrue(compress("abcd").equals("abcd"));
		Assert.assertNull(compress(null));
		Assert.assertTrue(compress("").equals(""));
		Assert.assertTrue(compress("a").equals("a"));
		Assert.assertTrue(compress("aa").equals("aa"));
	}
	
	public static String compress(String str) {
		if (str == null || str.length() <= 2) {
			return str;
		}
		
		StringBuilder compressedStr = new StringBuilder();
		
		int length = 1;
		int i = 0;
		while (i < str.length()) {
			if (((i + 1) < str.length()) && (str.charAt(i) != str.charAt(i+1))) {
				compressedStr = compressedStr.append(str.charAt(i)).append(length);
				length = 1;
			}
			else if ((i + 1) == str.length()) {
				compressedStr = compressedStr.append(str.charAt(i)).append(length);
				length = 1;
			}
			else {
				length++;
			}
			i++;
		}
		
		return (str.length() > compressedStr.toString().length()) ? compressedStr.toString() : str;
	}
}
