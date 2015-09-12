package org.mingtaoz.a9.string;

public class ValidNumber {

    public boolean isNumber(String s) {
        char[] characters = s.trim().toCharArray();
        boolean eFlag = false, dotFlag = false, numberFlag = false;
        if (characters.length == 0 || (characters.length == 1 && characters[0] == '.') || characters[0] == 'e') {
            return false;
        }
        for (int i = characters.length - 1; i >= 0; i--) {
            // reverse go through
            if (characters[i] >= '0' && characters[i] <= '9') {
                numberFlag = true;
            } else if (characters[i] == 'e') {
                if (eFlag || !numberFlag || dotFlag) {
                    return false;
                }
                numberFlag = false;
                eFlag = true;
            } else if (characters[i] == '.') {
                if (dotFlag) {
                    // 000.000.000
                    return false;
                }
                dotFlag = true;
            } else if (characters[i] == '-' || characters[i] == '+') {
                if ((!numberFlag) || (i != 0 && characters[i - 1] != 'e')) {
                    // 000.000.000
                    return false;
                }
            } else {
                // everything else
                return false;
            }
        }
        if (dotFlag && eFlag && !numberFlag) {
            return false;
        }
        return true;
    }
}
