package org.mingtaoz.leetcode.array;

public class ReadNCharacters {

    private char[] buffer = new char[4];
    private int offset, bufferSize;

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
        while (offset < bufferSize && n > 0) {
            destination[ret++] = buffer[offset++];
            n--;
        }
        // 2. read4 as usual
        while (n > 0 && (bufferSize = read4(buffer)) == 4) {
            copy(buffer, destination, ret);
            ret += bufferSize;
            n -= bufferSize;
        }
        if (n > 0) {
            copy(buffer, destination, ret);
            n -= bufferSize;
            ret += bufferSize;
        }
        while (n < 0) {
            destination[ret--] = 0;
            offset--;
            n++;
        }
        return ret;
    }

    private void copy(char[] buffer, char[] destination, int ret) {
        System.arraycopy(buffer, offset, destination, ret, bufferSize - offset);
        offset = bufferSize;
    }

    /**
     * DUMMY
     */
    int read4(char[] buf) {
        return 0;
    }

    /**
     * TODO better solution
     */
    class dummy {
        private char[] buffer = new char[4];
        int offset = 0, bufsize = 0;

        /**
            * @param buf Destination buffer
            * @param n   Maximum number of characters to read
            * @return    The number of characters read
            */
        public int read(char[] buf, int n) {
            int readBytes = 0;
            boolean eof = false;
            while (!eof && readBytes < n) {
                if (bufsize == 0) {
                    bufsize = read4(buffer);
                    eof = bufsize < 4;
                }
                int bytes = Math.min(n - readBytes, bufsize);
                System.arraycopy(buffer, offset, buf, readBytes, bytes);
                offset = (offset + bytes) % 4;
                bufsize -= bytes;
                readBytes += bytes;
            }
            return readBytes;
        }
    }
}
