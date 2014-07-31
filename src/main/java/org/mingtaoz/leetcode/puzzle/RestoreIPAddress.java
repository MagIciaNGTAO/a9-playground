package org.mingtaoz.leetcode.puzzle;

import java.util.LinkedList;
import java.util.List;

// TODO ugly solution?
public class RestoreIPAddress {
	/**
	 * 
	 * Given a string containing only digits, restore it by returning all
	 * possible valid IP address combinations.
	 * 
	 * For example: Given "25525511135",
	 * 
	 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 * 
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses(String s) {
		if (s == null || s.length() == 0) {
			return new LinkedList<>();
		}
		List<String> ret = new LinkedList<>();
		for (int i = 1; i <= 3; i++) {
			if (i > s.length()) {
				break;
			}
			List<List<String>> in = new LinkedList<>();
			List<String> inSmall = new LinkedList<>();
			String oneComponent = s.substring(0, i);
			inSmall.add(0, oneComponent);
			in.add(inSmall);
			ret.addAll(restoreIpAddressesHelper(in, s.substring(i), 3));
		}
		return ret;
	}

	private List<String> restoreIpAddressesHelper(
			List<List<String>> potentialComponents, String remained,
			int remainedComponents) {
		List<String> ret = new LinkedList<>();
		if (remained.length() == 0 && remainedComponents == 0) {
			for (List<String> potentialComponent : potentialComponents) {
				if (potentialComponent.size() == 4) {
					boolean legal = true;
					StringBuilder temp = new StringBuilder();
					for (String s : potentialComponent) {
						legal = legal(s);
						if (!legal) {
							break;
						}
						temp.insert(0, s).insert(0, ".");
					}
					if (legal) {
						ret.add(temp.substring(1));
					}
				}
			}
		} else if (remained.length() != 0 && remainedComponents != 0
				&& remained.length() >= remainedComponents) {
			for (int i = 1; i <= 3; i++) {
				if (i > remained.length()) {
					break;
				}
				String oneComponent = remained.substring(0, i);
				for (List<String> inSmall : potentialComponents) {
					inSmall.add(0, oneComponent);
				}
				ret.addAll(restoreIpAddressesHelper(potentialComponents,
						remained.substring(i), remainedComponents - 1));
				for (List<String> inSmall : potentialComponents) {
					inSmall.remove(0);
				}
			}
		}
		return ret;
	}

	public boolean legal(String s) {
		if (s.length() == 1) {
			return true;
		} else {
			int i = Integer.parseInt(s);
			return i <= 255 && (!s.startsWith("0")) && (!s.startsWith("00"));
		}
	}

}
