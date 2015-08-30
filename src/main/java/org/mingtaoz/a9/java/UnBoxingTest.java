package org.mingtaoz.a9.java;

import java.util.HashMap;
import java.util.Map;

public class UnBoxingTest {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        // unboxing will get NullPointer exception
        int a = map.get(1);
    }

}
