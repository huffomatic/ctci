package com.huffomatic.ctci.chapter1;

import org.junit.Assert;

/**
 * Replace all spaces in a string with %20
 * 
 * Input:  str = "Mr John Smith    ", 13
 * Output: str = "Mr%20John%20Smith"
 * 
 * Time:  O(n) where n is the length of str
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question3 {
	public static void main(String[] argv) {
		char[] str1Chars = "Mr John Smith    ".toCharArray();
		boolean result1 = replaceSpaces(str1Chars, 13);
		Assert.assertTrue(result1);
		Assert.assertTrue(java.util.Arrays.equals("Mr%20John%20Smith".toCharArray(), str1Chars));
		
		char[] str2Chars = "".toCharArray();
		boolean result2 = replaceSpaces(str2Chars, 13);
		Assert.assertFalse(result2);
		Assert.assertTrue(java.util.Arrays.equals("".toCharArray(), str2Chars));
		
		char[] str3Chars = "ab".toCharArray();
		boolean result3 = replaceSpaces(str3Chars, 0);
		Assert.assertFalse(result3);
		Assert.assertTrue(java.util.Arrays.equals("ab".toCharArray(), str3Chars));
		
		char[] str4Chars = "ab".toCharArray();
		boolean result4 = replaceSpaces(str4Chars, 1);
		Assert.assertFalse(result4);
		Assert.assertTrue(java.util.Arrays.equals("ab".toCharArray(), str4Chars));
		
		char[] str5Chars = "ab".toCharArray();
		boolean result5 = replaceSpaces(str5Chars, 3);
		Assert.assertFalse(result5);
		Assert.assertTrue(java.util.Arrays.equals("ab".toCharArray(), str5Chars));
		
		char[] str6Chars = "abcdefg".toCharArray();
		boolean result6 = replaceSpaces(str6Chars, 7);
		Assert.assertTrue(result6);
		Assert.assertTrue(java.util.Arrays.equals("abcdefg".toCharArray(), str6Chars));
	}
	
	public static boolean replaceSpaces(char[] str, int trueLength) {
		if (str.length == 0 || trueLength == 0 || str.length < trueLength) {
			return false;
		}
		
		int totalSpaces = countSpaces(str, trueLength);
		
		// One space character is converted into three characters.
		int replacedSize = trueLength + totalSpaces * 2;
		
		if (replacedSize != str.length) {
			return false;
		}
		
		int newIndex = str.length - 1;
		for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--) {
			if (str[oldIndex] == ' ') {
				str[newIndex] = '0';
				str[newIndex - 1] = '2';
				str[newIndex - 2] = '%';
				newIndex = newIndex - 3;
			}
			else {
				str[newIndex] = str[oldIndex];
				newIndex--;
			}
		}
		
		return true;
	}
	
	private static int countSpaces(char[] str, int trueLength) {
		int count = 0;
		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				count++;
			}
		}
		return count;
	}
}
