package org.mingtaoz.leetcode.string;

public class ReverseWordsInString {

    public String reverseWordsInString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return s;
        int rightCursor = s.length(), leftCursor = rightCursor - 1;
        StringBuilder ret = new StringBuilder();
        char[] sc = s.toCharArray();

        while (true) {
            // find space routine
            while (leftCursor >= 0 && sc[leftCursor] != ' ') {
                leftCursor--;
            }

            // copy routine
            int tempCursor = leftCursor + 1;
            while (tempCursor < rightCursor) {
                ret.append(sc[tempCursor++]);
            }

            // continue/put space routine
            rightCursor = leftCursor--;
            if (rightCursor < 0) {
                break;
            }
            ret.append(' ');
        }

        return ret.toString();
    }

    /**
     * Reverse Words in a String II
     * 
     * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

    The input string does not contain leading or trailing spaces and the words are always separated by a single space.

    For example,
    Given s = "the sky is blue",
    return "blue is sky the".

    Could you do it in-place without allocating extra space?
     * 
     * @param sequence
     */
    public void reverseWordsInPlace(char[] sequence) {
        int i = 0, j = sequence.length - 1;

        // reverse
        while (i < j) {
            char temp = sequence[i];
            sequence[i] = sequence[j];
            sequence[j] = temp;
            i++;
            j--;
        }

        // get good words
        int prev = 0;
        for (i = 0; i < sequence.length; i++) {
            if (sequence[i] == ' ') {
                j = i - 1;
                while (prev < j) {
                    char temp = sequence[prev];
                    sequence[prev] = sequence[j];
                    sequence[j] = temp;
                    prev++;
                    j--;
                }
                prev = i + 1;
            }
        }
        j = i - 1;
        while (prev < j) {
            char temp = sequence[prev];
            sequence[prev] = sequence[j];
            sequence[j] = temp;
            prev++;
            j--;
        }
    }
}
