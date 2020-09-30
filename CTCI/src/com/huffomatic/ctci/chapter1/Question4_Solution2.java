package com.huffomatic.ctci.chapter1;

import org.junit.Assert;

/**
 * Check if a string is a permutation of a palindrome.
 * Assuming characters 'a' to 'z' are allowed.
 * 
 * Input:  str = "tact coa"
 * Output: true since some permutations are "taco cat", "atco cta", etc.
 * 
 * Time:  O(n) where n is the length of str
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question4_Solution2 {
	public static void main(String[] argv) {
		String str1 = "tactcoa";
		Assert.assertTrue(isPermutationOfPalindrome(str1));
		
		String str2 = "tactcot";
		Assert.assertFalse(isPermutationOfPalindrome(str2));
		
		String str3 = "tacTcoa";
		Assert.assertFalse(isPermutationOfPalindrome(str3));
		
		String str4 = "\naaaa";
		Assert.assertFalse(isPermutationOfPalindrome(str4));
	}
	
	public static boolean isPermutationOfPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		
		// Palindrome is a string that is the same forwards and backwards.
		// Permutation is the arrangement of letters.
		// If a palindrome, then at most one character has an odd count.
		// We can use a bit vector to store the even and odd counts.
		// We want the bit vector to have at most one 1 digit.
		// We can subtract 1 from the bit vector and then AND the result with the original bit vector.
		// If the result is zero, then the string is a permutation of a palindrome.
		// A single integer can hold 32 bits so if we wanted to store the 128 ASCII characters then we would need 4 integer bit vectors.
		int bitVector = 0;
		for (int i = 0; i < str.length(); i++) {
			int charValue = str.charAt(i) - 'a';
			
			// Return false if the characters are not between 'a' and 'z'.
			if (charValue < 0 || charValue > 25) {
				return false;
			}
			
			// Toggle bit at position charValue.
			// We can use the ^ (xor) command.
			int currentBit = (1 << charValue);
			bitVector = bitVector ^ currentBit;
		}
		
		int smallerBitVector = bitVector - 1;
		return ((bitVector & smallerBitVector) == 0);	
	}
}
