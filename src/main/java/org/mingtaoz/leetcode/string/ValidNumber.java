package org.mingtaoz.leetcode.string;

public class ValidNumber {

	public boolean isNumber(String s) {
		char[] characters = s.trim().toCharArray();
		boolean eFlag = false, dotFlag = false, numberFlag = false;
		if (characters.length == 0) {
			return false;
		}
		if (characters.length == 1) {
			if (characters[0] == '.') {
				return false;
			}
		}

		for (int i = characters.length - 1; i >= 0; i--) {
			if (characters[i] >= '0' && characters[i] <= '9') {
				numberFlag = true;
			} else if (characters[i] == 'e') {
				if (eFlag || i == 0 || !numberFlag) {
					return false;
				}
				eFlag = true;
				numberFlag = false;
			} else if (characters[i] == '.') {
				if (dotFlag || (!numberFlag && eFlag)) {
					// 000.000.000
					return false;
				}
				dotFlag = true;
			} else if (characters[i] == '-' || characters[i] == '+') {
				if ((!numberFlag && eFlag) || i != 0) {
					// 000.000.000
					return false;
				}
			} else {
				// eveything else
				return false;
			}
		}
		return true;
	}
}
