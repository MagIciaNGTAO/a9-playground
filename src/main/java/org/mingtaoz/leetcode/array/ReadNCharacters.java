package org.mingtaoz.leetcode.array;

public class ReadNCharacters {

    private char[] buffer = new char[4];
    private int index = -1;
    private int previous = -1;

    /**
     * Read N Characters Given Read4 II - Call multiple times
     * 
     * The API: int read4(char *buf) reads 4 characters at a time from a file.
     * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
     * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
     * Note: The read function may be called multiple times.
     * 
     */
    public int read(char[] destination, int n) {
        int ret = 0;
        // 1. consume buffer
        while (index < previous) {
            destination[ret++] = buffer[index++];
            n--;
        }
        // 2. read4 as usual
        while (n > 0 && (previous = read4(buffer)) == 4) {
            copy(buffer, destination, ret);
            ret += previous;
            n -= previous;
        }
        if (n > 0) {
            copy(buffer, destination, ret);
            n -= previous;
            ret += previous;
        }
        while (n < 0) {
            destination[ret--] = 0;
            index--;
            n++;
        }
        return ret;
    }

    private void copy(char[] buffer, char[] destination, int ret) {
        for (index = 0; index < previous; index++) {
            destination[ret++] = buffer[index];
        }
    }

    /**
     * DUMMY
     */
    int read4(char[] buf) {
        return 0;
    }
}
