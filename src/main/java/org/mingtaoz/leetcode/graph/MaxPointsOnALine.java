package org.mingtaoz.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		Map<String, Set<Point>> lineToPointSet = new HashMap<String, Set<Point>>();
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				String key = getLineRep(points[i], points[j]);
				if (lineToPointSet.containsKey(key)) {
					Set<Point> set = lineToPointSet.get(key);
					set.add(points[i]);
					set.add(points[j]);
					if (set.size() > max) {
						max = set.size();
					}
				} else {
					Set<Point> set = new HashSet<Point>();
					set.add(points[i]);
					set.add(points[j]);
					if (set.size() > max) {
						max = set.size();
					}
					lineToPointSet.put(key, set);
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

		int z = getLargestDenominator(y, x);

		ret.append(y / z).append("/").append(x / z);

		return ret.toString();
	}

	public int getLargestDenominator(int x, int y) {
		if (x < y) {
			int t = x;
			x = y;
			y = t;
		}
		// x >= y now
		if ((x / y) * y == x) {
			return y;
		} else {
			return getLargestDenominator(x - y, y);
		}
	}
}
