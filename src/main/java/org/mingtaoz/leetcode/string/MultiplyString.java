package org.mingtaoz.leetcode.string;

public class MultiplyString {

    /**
     * 
     *   112
     * * 334
     * -----
     *   448
     *  336
     * 336
     * 37408 
     * multiply big integer
     * 
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder resultBuilder = new StringBuilder();
        // sign
        if (num1.contains("-") && !num2.contains("-")) {
            resultBuilder.append("-");
            num1 = num1.substring(1);
        }
        if (!num1.contains("-") && num2.contains("-")) {
            resultBuilder.append("-");
            num2 = num2.substring(1);
        }
        if (num1.contains("-") && num2.contains("-")) {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
        }
        int[] a = toIntArray(num1), b = toIntArray(num2);
        int[] ret = new int[num1.length() + num2.length() + 1];
        int carry = 0, max = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                int multi = a[i] * b[j];
                int index = a.length + b.length - i - j - 2;
                int temp = ret[index] + multi + carry;
                ret[index] = temp % 10;
                if (temp > 9) {
                    carry = temp / 10;
                } else {
                    carry = 0;
                }
                max = index;
            }
            if (carry > 0) {
                ret[max + 1] = carry;
                carry = 0;
            }
        }
        boolean start = false;
        for (int i = ret.length - 1; i >= 0; i--) {
            if (start) {
                resultBuilder.append(ret[i]);
            } else {
                if (ret[i] != 0) {
                    resultBuilder.append(ret[i]);
                    start = true;
                }
            }
        }
        return resultBuilder.toString();
    }

    private int[] toIntArray(String num) {
        int[] ret = new int[num.length()];
        int temp = 0;
        for (char c : num.toCharArray()) {
            ret[temp++] = c - '0';
        }
        return ret;
    }
}
