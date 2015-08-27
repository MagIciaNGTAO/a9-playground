package org.mingtaoz.a9.binary;

/**
 * 
 * programming pearls page 12
 *
 */
public class BitMap {

    private static final int DEFAULT_SIZE = 1 << 10; // 128 bytes
    private static final int WORD_SIZE = 1 << 3; // 1 byte

    private final int size;
    private final byte[] back;

    public BitMap() {
        size = DEFAULT_SIZE / WORD_SIZE;
        back = new byte[size];
    }

    public BitMap(int size) {
        this.size = size / WORD_SIZE;
        back = new byte[this.size];
    }

    public void on(int number) {
        number--;
        int location = number / WORD_SIZE;
        int bit = number % WORD_SIZE;
        back[location] |= 1 << bit;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            byte b = back[i];
            for (int j = WORD_SIZE - 1; j >= 0; j--) {
                byte mask = (byte) (1 << j);
                if ((b & mask) != 0) {
                    ret.append("1");
                } else {
                    ret.append("0");
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        BitMap sut = new BitMap(16);
        sut.on(9);
        sut.on(8);
        sut.on(1);
        System.out.println(sut.toString());
    }
}
