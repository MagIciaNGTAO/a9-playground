package org.mingtaoz.leetcode.map;

import java.util.List;

import org.mingtaoz.leetcode.map.LRUCache;
import org.mingtaoz.test.core.ParserUtil;
import org.mingtaoz.test.core.ParserUtil.Command;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LRUCacheTest extends TestCase {

	private LRUCache sut;

	public LRUCacheTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(LRUCacheTest.class);
	}

	public void testLRUCache1() {
		sut = new LRUCache(1);
		sut.set(2, 1);
		assertEquals(1, sut.get(2));
		sut.set(3, 2);
		assertEquals(-1, sut.get(2));
		assertEquals(2, sut.get(3));
	}

	public void testLRUCache2() {
		sut = new LRUCache(2);
		sut.set(2, 1);
		assertEquals(1, sut.get(2));
		sut.set(1, 1);
		assertEquals(1, sut.get(1));
		sut.set(3, 1);
		assertEquals(-1, sut.get(2));
		assertEquals(1, sut.get(1));
		sut.set(4, 1);
		assertEquals(1, sut.get(4));
	}

	public void testLRUCache3() {
		sut = new LRUCache(2);
		sut.set(2, 1);
		sut.set(1, 1);
		sut.set(2, 3);
		sut.set(4, 1);
		assertEquals(-1, sut.get(1));
		assertEquals(3, sut.get(2));
	}

	public void testLRUCache4() {
		sut = new LRUCache(10);
		List<Command> commands = ParserUtil
				.parseLRUCache("[set(10,13),set(3,17),set(6,11),set(10,5),set(9,10),get(13),set(2,19),get(2),get(3),set(5,25),get(8),set(9,22),set(5,5),set(1,30),get(11),set(9,12),get(7),get(5),get(8),get(9),set(4,30),set(9,3),get(9),get(10),get(10),set(6,14),set(3,1),get(3),set(10,11),get(8),set(2,14),get(1),get(5),get(4),set(11,4),set(12,24),set(5,18),get(13),set(7,23),get(8),get(12),set(3,27),set(2,12),get(5),set(2,9),set(13,4),set(8,18),set(1,7),get(6),set(9,29),set(8,21),get(5),set(6,30),set(1,12),get(10),set(4,15),set(7,22),set(11,26),set(8,17),set(9,29),get(5),set(3,4),set(11,30),get(12),set(4,29),get(3),get(9),get(6),set(3,4),get(1),get(10),set(3,29),set(10,28),set(1,20),set(11,13),get(3),set(3,12),set(3,8),set(10,9),set(3,26),get(8),get(7),get(5),set(13,17),set(2,27),set(11,15),get(12),set(9,19),set(2,15),set(3,16),get(1),set(12,17),set(9,1),set(6,19),get(4),get(5),get(5),set(8,1),set(11,7),set(5,2),set(9,28),get(1),set(2,2),set(7,4),set(4,22),set(7,24),set(9,26),set(13,28),set(11,26)]");

		List<Integer> expects = ParserUtil
				.parseLRUCacheExpect("-1,19,17,-1,-1,-1,5,-1,12,3,5,5,1,-1,30,5,30,-1,-1,24,18,-1,18,-1,18,-1,4,29,30,12,-1,29,17,22,18,-1,20,-1,18,18,20");

		int i = 0;

		for (Command m : commands) {
			if ("set".equals(m.method)) {
				sut.set(m.parameters);
			} else if ("get".equals(m.method)) {
				assertEquals(expects.get(i++) + 0, sut.get(m.parameters));
			}
		}
	}
}
