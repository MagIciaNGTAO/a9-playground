package org.mingtaoz.a9.string;

public class ValidPalindrome {

	/**
	 * 
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return true;

		char[] chars = s.toLowerCase().toCharArray();
		int n = s.length(), i = 0, j = n - 1;

		while (i < j) {
			if (isAlphanumeric(chars[i]) && isAlphanumeric(chars[j])) {
				if (chars[i] != chars[j]) {
					return false;
				}
				i++;
				j--;
			} else if (isAlphanumeric(chars[i])) {
				j--;
			} else if (isAlphanumeric(chars[j])) {
				i++;
			} else {
				i++;
				j--;
			}
		}

		return true;
	}

	public boolean isAlphanumeric(char c) {
		return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
	}
}
