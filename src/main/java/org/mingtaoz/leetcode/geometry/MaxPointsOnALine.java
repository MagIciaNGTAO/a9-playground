package org.mingtaoz.leetcode.geometry;

import java.util.HashMap;
import java.util.Map;

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
		if (points == null)
			return 0;
		if (points.length == 1)
			return 1;
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			Map<String, Integer> lineToCount = new HashMap<String, Integer>();
			int overlap = 0, tempMax = 0;
			for (int j = i + 1; j < points.length; j++) {
				// TODO get rid of this special case
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					overlap++;
				} else {
					String key = getLineRep(points[i], points[j]);
					if (lineToCount.containsKey(key)) {
						int count = lineToCount.get(key) + 1;
						if (count > tempMax) {
							tempMax = count;
						}
						lineToCount.put(key, count);
					} else {
						if (2 > tempMax) {
							tempMax = 2;
						}
						lineToCount.put(key, 2);
					}
				}
			}
			if (tempMax == 0) {
				tempMax = 1;
			}
			tempMax = tempMax + overlap;
			if (max < tempMax) {
				max = tempMax;
			}
		}
		return max;
	}

	public String getLineRep(Point p1, Point p2) {
		if (p1.x == p2.x) {
			return "i " + p1.x;
		}
		if (p1.y == p2.y) {
			return "0 " + p1.y;
		}

		String k = getDivideByRep((p1.y - p2.y), (p1.x - p2.x));
		String b = getDivideByRep(p1.x * p2.y - p2.x * p1.y, p1.x - p2.x);
		return k + " " + b;
	}

	public String getDivideByRep(int y, int x) {
		if (x == 0) {
			return y + "/0";
		}
		if (y == 0) {
			return "0";
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
