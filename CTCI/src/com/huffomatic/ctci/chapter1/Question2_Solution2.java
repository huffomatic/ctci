package com.huffomatic.ctci.chapter1;

import java.util.HashMap;

import org.junit.Assert;

/**
 * Check if one string is a permutation of another string
 * 
 * Input:  str1 = abcabc, str2 = abccba
 * Output: true
 * 
 * Input:  str1 = abcabc, str2 = abc
 * Output: false
 * 
 * Time:  O(m + n) where m is the length of str1 and n is the length of str2
 * Space: O(m + n) where m is the length of str1 and n is the length of str2
 * 
 * @author huffomatic
 *
 */
public class Question2_Solution2 {
	public static void main(String[] argv) {
		String str1 = "abcabc", str2 = "abccba";
		Assert.assertTrue(isPermutation(str1, str2));
		
		String str3 = "abcabc", str4 = "abccbb";
		Assert.assertFalse(isPermutation(str3, str4));
		
		String str5 = "abcabc", str6 = null;
		Assert.assertFalse(isPermutation(str5, str6));
		
		String str7 = null, str8 = "abcabc";
		Assert.assertFalse(isPermutation(str7, str8));
		
		String str9 = "abcd", str10 = "abc";
		Assert.assertFalse(isPermutation(str9, str10));
	}
	
	public static boolean isPermutation(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		else if (str1.length() != str2.length()) {
			return false;
		}
		
		HashMap<Integer, Integer> str1CountMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			int charValue = str1.charAt(i);
			Integer count = str1CountMap.get(charValue);
			if (count != null) {
				count = count + 1;
			}
			else {
				count = 1;
			}
			str1CountMap.put(charValue, count);
		}
		
		HashMap<Integer, Integer> str2CountMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < str2.length(); i++) {
			int charValue = str2.charAt(i);
			Integer count = str2CountMap.get(charValue);
			if (count != null) {
				count = count + 1;
			}
			else {
				count = 1;
			}
			str2CountMap.put(charValue, count);
		}
		
		return str1CountMap.equals(str2CountMap);
	}
}
