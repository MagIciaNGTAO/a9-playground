package org.mingtaoz.other.java;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();

		// unboxing will get NullPointer exception
		int a = map.get(1);
	}

}
