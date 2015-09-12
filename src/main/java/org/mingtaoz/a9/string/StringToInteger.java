package org.mingtaoz.a9.string;

public class StringToInteger {

    public int atoi(String str) {
        char[] c = str.toCharArray();
        long ret = 0, ABS_MIN = 1 + (long) Integer.MAX_VALUE;
        int i = 0;
        boolean neg = false;
        if (c.length == 0) {
            return 0;
        }
        while (i < c.length && (c[i] == ' ')) {
            i++;
        }
        if ((c[i] == '-' || c[i] == '+')) {
            if (c[i++] == '-') {
                neg = !neg;
            }
        }
        while (i < c.length) {
            if (c[i] == '+' || c[i] == '-') {
                return 0;
            }
            if (c[i] < '0' || c[i] > '9') {
                break;
            }
            ret *= 10;
            ret += (c[i] - '0');
            if (ret > Integer.MAX_VALUE && !neg) {
                return Integer.MAX_VALUE;
            }
            if (ret > ABS_MIN && neg) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (neg ? -1 * ret : ret);
    }
}
