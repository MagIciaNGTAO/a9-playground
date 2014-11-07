package org.mingtaoz.other.binary;

/**
 * 
 * programming pearls page 12
 *
 */
public class BitMap {

    private static final int DEFAULT_SIZE = 1 << 10;
    private static final int WORD_SIZE = 1 << 3;

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

    public void flip(int number) {
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
        sut.flip(9);
        sut.flip(8);
        sut.flip(1);
        System.out.println(sut.toString());
    }
}
