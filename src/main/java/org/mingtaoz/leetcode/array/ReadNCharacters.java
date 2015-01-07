package org.mingtaoz.leetcode.array;

public class ReadNCharacters {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ret = 0, temp = 0;
        char[] buffer = new char[4];
        while (n > 0 && (temp = read4(buffer)) == 4) {
            copy(buffer, buf, ret);
            ret += temp;
            n -= temp;
        }
        if (n > 0) {
            copy(buffer, buf, ret);
            n -= temp;
            ret += temp;
        }
        while (n < 0) {
            buf[ret--] = 0;
            n++;
        }
        return ret;
    }

    private void copy(char[] buffer, char[] buf, int ret) {
        for (int i = 0; i < 4; i++) {
            buf[ret++] = buffer[i];
        }
    }

    /**
     * DUMMY
     */
    int read4(char[] buf) {
        return 0;
    }
}
