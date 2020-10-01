package com.huffomatic.ctci.chapter1;

import org.junit.Assert;

/**
 * Check if two strings are one edit away from each other.
 * 
 * Input:  str1 = "pale", str2 = "ple"
 * Output: true one deletion away
 * 
 * Input:  str1 = "ple", str2 = "pale"
 * Output: true one addition away
 * 
 * Input:  str1 = "pale", str2 = "bale"
 * Output: true one replace away
 * 
 * Input:  str1 = "pale", str2 = "bae"
 * Output: false two edits away
 * 
 * Time:  O(m + n) where m is the length of str1 and n is the length of str2
 * Space: O(1) 
 * 
 * @author huffomatic
 *
 */
public class Question5_Solution1 {
	public static void main(String[] argv) {
		Assert.assertTrue(isOneEditAway("pale", "ple"));
		Assert.assertTrue(isOneEditAway("ple", "pale"));
		Assert.assertTrue(isOneEditAway("pale", "bale"));
		Assert.assertFalse(isOneEditAway("pale", "bae"));
		Assert.assertTrue(isOneEditAway(null, null));
		Assert.assertTrue(isOneEditAway(null, ""));
		Assert.assertTrue(isOneEditAway(null, "a"));
		Assert.assertTrue(isOneEditAway("", null));
		Assert.assertTrue(isOneEditAway("", ""));
		Assert.assertTrue(isOneEditAway("", "a"));
	}
	
	public static boolean isOneEditAway(String str1, String str2) {
		String first = (str1 != null) ? str1 : "";
		String second = (str2 != null) ? str2 : "";
		
		int diff = (first.length() > second.length()) ? first.length() - second.length() : second.length() - first.length();
		
		if (diff > 1) {
			return false;
		}
		
		if (first.length() == second.length()) {
			return isOneReplaceAway(first, second);
		}
		else if (first.length() > second.length()) {
			return isOneInsertAway(second, first);
		}
		else {
			return isOneInsertAway(first, second);
		}
	}
	
	public static boolean isOneReplaceAway(String str1, String str2) {
		boolean foundDiff = false;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (foundDiff) {
					return false;
				}
				foundDiff = true;
			}
		}
		
		return true;
	}
	
	public static boolean isOneInsertAway(String str1, String str2) {
		int i = 0;
		int j = 0;
		while (i < str1.length() && j < str2.length()) {
			if (str1.charAt(i) != str2.charAt(j)) {
				if (i != j) {
					return false;
				}
				j++;
			}
			else {
				i++;
				j++;
			}
		}
		
		return true;
	}
}
