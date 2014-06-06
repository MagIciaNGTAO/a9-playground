package org.mingtaoz.leetcode.graph;

import java.util.HashMap;
import java.util.Map;

// TODO incomplete
public class MaxPointsOnALine {

	public static class Point {
		int x;
		int y;

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			Map<String, Integer> lineToCount = new HashMap<String, Integer>();
			for (int j = i + 1; j < points.length; j++) {
				String key = getLineRep(points[i], points[j]);
				if (lineToCount.containsKey(key)) {
					int count = lineToCount.get(key);
					if (count + 1 > max) {
						max = count + 1;
					}
					lineToCount.put(key, count + 1);
				} else {
					if (2 > max) {
						max = 2;
					}
					lineToCount.put(key, 2);
				}
			}
		}
		return max;
	}

	public String getLineRep(Point p1, Point p2) {
		if (p1.x == p2.x) {
			return "i " + p1.x;
		} else if (p1.y == p2.y) {
			return "0 " + p1.y;
		} else {
			String k = getDivideByRep((p1.y - p2.y), (p1.x - p2.x));
			String b = getDivideByRep(p1.x * p2.y - p2.x * p1.y, p1.x - p2.x);
			return k + b;
		}
	}

	public String getDivideByRep(int y, int x) {
		if (x == 0) {
			return y + "/0";
		}
		if (y == 0) {
			return "0/" + x;
		}
		StringBuilder ret = new StringBuilder();
		if (x * y < 0) {
			ret.append("-");
		}
		x = Math.abs(x);
		y = Math.abs(y);

		double z = (double) y / x;

		ret.append(z);

		return ret.toString();
	}
}
