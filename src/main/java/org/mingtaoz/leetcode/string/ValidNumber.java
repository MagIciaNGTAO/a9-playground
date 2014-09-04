package org.mingtaoz.leetcode.string;

public class ValidNumber {

	public boolean isNumber(String s) {
		char[] characters = s.trim().toCharArray();
		boolean zeroFlag = false, eFlag = false, dotFlag = false, numberFlag = false;
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
				if (characters[i] == '0') {
					if (zeroFlag == true && i == 0) {
						return false;
					}
					zeroFlag = true;
				} else {
					zeroFlag = false;
				}
				numberFlag = true;
			} else if (characters[i] == 'e') {
				if (eFlag || i == 0 || !numberFlag) {
					return false;
				}
				zeroFlag = false;
				eFlag = true;
			} else if (characters[i] == '.') {
				if (dotFlag) {
					// 000.000.000
					return false;
				}
				dotFlag = true;
				zeroFlag = false;
			} else {
				// eveything else
				return false;
			}
		}
		return true;
	}
}
