package org.mingtaoz.leetcode.puzzle;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
	int start;
	int end;

	public Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	public String toString() {
		return "[" + start + "-" + end + "]";
	}

	public boolean equals(Object o) {
		if (o instanceof Interval) {
			Interval that = (Interval) o;
			return this.start == that.start && this.end == that.end;
		}
		return false;
	}

	// TODO em...
	public int hashCode() {
		return 31 * start + 31 ^ 2 * end;
	}
}

public class Intervals {

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new LinkedList<>();
		List<Interval> temp = new LinkedList<>(intervals);

		Collections.sort(temp, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		Interval merged = null;
		for (Interval i : temp) {
			if (merged == null) {
				merged = i;
			} else {
				if (merged.end >= i.start) {
					merged.end = Math.max(merged.end, i.end);
				} else {
					ret.add(merged);
					merged = i;
				}
			}
		}
		if (merged != null) {
			ret.add(merged);
		}
		return ret;
	}

	// TODO
	// 1. draw it don't waste brain - -
	// 2. refactor with equals/hashCode
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new LinkedList<>();
		Interval merged = new Interval(newInterval.start, newInterval.end);
		for (Interval i : intervals) {
			if (merged == null || i.end < merged.start) {
				ret.add(i);
			} else {
				// i.end >= merged.start
				if (i.start <= merged.start) {
					// grow
					merged.start = i.start;
					merged.end = Math.max(i.end, merged.end);
				} else {
					if (merged.end < i.start) {
						// grow is over
						ret.add(merged);
						merged = null;
						ret.add(i);
					} else {
						// i.end >= merged.start
						// i.start > merged.start
						// merged.end > i.start

						// grow
						merged.end = Math.max(i.end, merged.end);
					}
				}
			}
		}
		if (merged != null) {
			ret.add(merged);
		}
		return ret;
	}
}
