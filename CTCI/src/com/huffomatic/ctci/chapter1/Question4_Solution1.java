package com.huffomatic.ctci.chapter1;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.Assert;

/**
 * Check if a string is a permutation of a palindrome
 * 
 * Input:  str = "tact coa"
 * Output: true since some permutations are "taco cat", "atco cta", etc.
 * 
 * Time:  O(n) where n is the length of str
 * Space: O(n) where n is the length of str
 * 
 * @author huffomatic
 *
 */
public class Question4_Solution1 {
	public static void main(String[] argv) {
		String str1 = "tactcoa";
		Assert.assertTrue(isPermutationOfPalindrome(str1));
		
		String str2 = "tactcot";
		Assert.assertFalse(isPermutationOfPalindrome(str2));
	}
	
	public static boolean isPermutationOfPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		
		// Palindrome is a string that is the same forwards and backwards
		// Permutation is the arrangement of letters
		// If a palindrome, then at most one character has an odd count.
		
		HashMap<Integer, Integer> strCountMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < str.length(); i++) {
			int charValue = str.charAt(i);
			Integer count = strCountMap.get(charValue);
			if (count != null) {
				count = count + 1;
			}
			else {
				count = 1;
			}
			strCountMap.put(charValue, count);
		}
		
		boolean foundOdd = false;
		Iterator<Integer> keys = strCountMap.keySet().iterator();
		while (keys.hasNext()) {
			Integer key = keys.next();
			Integer value = strCountMap.get(key);
			if (value % 2 != 0) {
				if (!foundOdd) {
					foundOdd = true;
				}
				else {
					return false;
				}
			}
		}
		
		return true;
	}
}
