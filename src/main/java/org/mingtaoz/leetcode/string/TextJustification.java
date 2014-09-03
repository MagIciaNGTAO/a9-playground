package org.mingtaoz.leetcode.string;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {

	/**
	 * Given an array of words and a length L, format the text such that each
	 * line has exactly L characters and is fully (left and right) justified.
	 * 
	 * You should pack your words in a greedy approach; that is, pack as many
	 * words as you can in each line. Pad extra spaces ' ' when necessary so
	 * that each line has exactly L characters.
	 * 
	 * Extra spaces between words should be distributed as evenly as possible.
	 * If the number of spaces on a line do not divide evenly between words, the
	 * empty slots on the left will be assigned more spaces than the slots on
	 * the right.
	 * 
	 * For the last line of text, it should be left justified and no extra space
	 * is inserted between words.
	 * 
	 * For example, words: ["This", "is", "an", "example", "of", "text",
	 * "justification."] L: 16.
	 * 
	 * Return the formatted lines as: [ "This    is    an", "example  of text",
	 * "justification.  " ] Note: Each word is guaranteed not to exceed L in
	 * length.
	 * 
	 * @param words
	 * @param L
	 * @return
	 */
	public List<String> fullJustify(String[] words, int L) {
		List<String> ret = new LinkedList<>();
		int currentWordSize = 0, left = 0, right = 0;
		for (int i = 0; i < words.length; i++) {
			if (currentWordSize + words[i].length() + (right - left) > L) {
				left = spacing(words, L, ret, currentWordSize, left, right);
				currentWordSize = 0;
			}
			right++;
			currentWordSize += words[i].length();
		}
		if (left < right) {
			int numberOfNiche = right - left - 1;
			if (numberOfNiche == 0) {
				StringBuilder temp = new StringBuilder();
				temp.append(words[left++]);
				int s = 0;
				while (s++ < L - currentWordSize) {
					temp.append(" ");
				}
				ret.add(temp.toString());
			} else {
				int spaceSize = L - currentWordSize;
				StringBuilder temp = new StringBuilder();
				while (left < right) {
					temp.append(words[left++]);
					temp.append(" ");
					spaceSize--;
				}
				while (spaceSize-- > 0) {
					temp.append(" ");
				}
				ret.add(temp.toString());
			}
		}
		return ret;
	}

	private int spacing(String[] words, int L, List<String> ret,
			int currentWordSize, int left, int right) {
		// calculate space and append
		int numberOfNiche = right - left - 1;
		if (numberOfNiche == 0) {
			StringBuilder temp = new StringBuilder();
			temp.append(words[left++]);
			int s = 0;
			while (s++ < L - currentWordSize) {
				temp.append(" ");
			}
			ret.add(temp.toString());
		} else {
			int averageSpaceSize = (L - currentWordSize) / numberOfNiche;
			int additionalSpaces = (L - currentWordSize) % numberOfNiche;
			StringBuilder temp = new StringBuilder();
			while (left < right - 1) {
				temp.append(words[left++]);
				int s = 0;
				while (s++ < averageSpaceSize) {
					temp.append(" ");
				}
				if (additionalSpaces-- > 0) {
					temp.append(" ");
				}
			}
			temp.append(words[left++]);
			ret.add(temp.toString());
		}
		return left;
	}
}
