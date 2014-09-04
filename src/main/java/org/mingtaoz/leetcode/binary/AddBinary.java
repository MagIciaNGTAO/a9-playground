package org.mingtaoz.leetcode.binary;

public class AddBinary {

	public String addBinary(String a, String b) {
		StringBuilder resultBuilder = new StringBuilder();
		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();
		reverse(ca);
		reverse(cb);

		int i = 0;
		boolean carry = false;
		while (i < ca.length && i < cb.length) {
			if (ca[i] == '0' && cb[i] == '0') {
				resultBuilder.insert(0, carry ? 1 : 0);
				carry = false;
			} else if (ca[i] == '0') {
				int temp = (carry ? 1 : 0) + cb[i] - '0';
				carry = temp == 2;
				resultBuilder.insert(0, carry ? temp - 2 : temp);
			} else if (cb[i] == '0') {
				int temp = (carry ? 1 : 0) + ca[i] - '0';
				carry = temp == 2;
				resultBuilder.insert(0, carry ? temp - 2 : temp);
			} else {
				int temp = (carry ? 1 : 0) + ca[i] - '0' + cb[i] - '0';
				carry = temp >= 2;
				resultBuilder.insert(0, carry ? temp - 2 : temp);
			}
			i++;
		}
		while (i < ca.length) {
			int temp = (carry ? 1 : 0) + ca[i] - '0';
			carry = temp == 2;
			resultBuilder.insert(0, carry ? temp - 2 : temp);
			i++;
		}
		while (i < cb.length) {
			int temp = (carry ? 1 : 0) + cb[i] - '0';
			carry = temp == 2;
			resultBuilder.insert(0, carry ? temp - 2 : temp);
			i++;
		}
		if (carry) {
			resultBuilder.insert(0, 1);
		}
		return resultBuilder.toString();
	}

	private static void reverse(char[] toBeReversed) {
		int i = 0, j = toBeReversed.length - 1;
		while (i < j) {
			char temp = toBeReversed[i];
			toBeReversed[i++] = toBeReversed[j];
			toBeReversed[j--] = temp;
		}
	}
}
