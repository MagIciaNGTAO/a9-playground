package org.mingtaoz.leetcode.geometry;

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

	public static class PointWrapper {
		Point p;

		PointWrapper(Point p) {
			this.p = p;
		}

		@Override
		public int hashCode() {
			return (p.x << 8) + p.y;
		}

		@Override
		public boolean equals(Object obj) {
			PointWrapper pw = (PointWrapper) obj;
			return p.x == pw.p.x && p.y == pw.p.y;
		}
	}

	public int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		if (points.length == 1)
			return 1;
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			Map<String, Set<PointWrapper>> lineToPointSet = new HashMap<String, Set<PointWrapper>>();
			for (int j = i + 1; j < points.length; j++) {
				String key = getLineRep(points[i], points[j]);
				if (lineToPointSet.containsKey(key)) {
					Set<PointWrapper> set = lineToPointSet.get(key);
					set.add(new PointWrapper(points[i]));
					set.add(new PointWrapper(points[j]));
					if (set.size() > max) {
						max = set.size();
					}
				} else {
					Set<PointWrapper> set = new HashSet<PointWrapper>();
					set.add(new PointWrapper(points[i]));
					set.add(new PointWrapper(points[j]));
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
			return k + " " + b;
		}
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
