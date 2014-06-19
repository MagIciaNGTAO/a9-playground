package org.mingtaoz.leetcode.puzzle;

public class GasStation {

	/**
	 * 
	 * There are N gas stations along a circular route, where the amount of gas
	 * at station i is gas[i].
	 * 
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
	 * travel from station i to its next station (i+1). You begin the journey
	 * with an empty tank at one of the gas stations.
	 * 
	 * Return the starting gas station's index if you can travel around the
	 * circuit once, otherwise return -1.
	 * 
	 * Note: The solution is guaranteed to be unique.
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int searchMax = gas.length, i = 0;
		while (i < searchMax) {
			// conduct the search from i to end then to i-1
			int tank = 0;
			int j;
			for (j = i; j < searchMax; j++) {
				tank += gas[j];
				if(tank < cost[j]) {
					i = j + 1;
					tank -= cost[j];
					break;
				} else {
					tank -= cost[j];
				}
			}
			if(i == j + 1) {
				// goto the next search
				continue;
			}
			for (j = 0; j < i; j++) {
				tank += gas[j];
				if(tank < cost[j]) {
					// already searched this half
					return -1;
				} else {
					tank -= cost[j];
				}
			}
			if(tank >= 0) {
				return i; // find one possible solution
			}
		}
		return (i == searchMax) ? -1 : i;
	}
}
