package com.huffomatic.ctci.chapter1;

import org.junit.Assert;

/**
 * String Rotation: Given two strings, str1 and str2, check if str2 is a rotation of str1.
 * You have a method isSubstring() that checks if one string is a substring of another string.
 * 
 * Input:  str1 = "waterbottle", str2 = "erbottlewat"
 * Output: true
 * 
 * Time:  O(m + n) where m is the length of str1 and n is the length of str2
 * Space: O(1) 
 * 
 * @author huffomatic
 *
 */
public class Question9 {
	public static void main(String[] argv) {
		Assert.assertTrue(isRotation("waterbottle", "erbottlewat"));
		Assert.assertTrue(isRotation("erbottlewat", "waterbottle"));
		Assert.assertFalse(isRotation("waterbottle", "erbottlewas"));
		Assert.assertFalse(isRotation("waterbottle", "erbottlewa"));
		Assert.assertFalse(isRotation("waterbottl", "erbottlewat"));
		Assert.assertFalse(isRotation("", "erbottlewas"));
		Assert.assertFalse(isRotation("waterbottle", ""));
		Assert.assertFalse(isRotation("waterbottle", null));
		Assert.assertFalse(isRotation(null, "erbottlewas"));
	}
	
	public static boolean isRotation(String str1, String str2) {
		if ((str1 == null || str2 == null) || (str1.length() != str2.length())) {
			return false;
		}
		
		// If we want to determine if a string is a rotation, then we need to break the string into two parts - x and y.
		// Let's suppose str1 = xy.  If str2 is rotation of str1, then str2 = yx.
		// Notice that str1 concatenated with itself is str1str1 = xyxy.
		// yx will always be a substring of xyxy or str2 is a substring of str1str1.
		StringBuilder str1str1 = new StringBuilder();
		str1str1 = str1str1.append(str1).append(str1);
		
		return isSubstring(str1str1.toString(), str2);
	}
	
	private static boolean isSubstring(String str1, String str2) {
		return str1.contains(str2);
	}
}
