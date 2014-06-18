package org.mingtaoz.leetcode.toolbox.graph;

import java.util.ArrayList;
import java.util.List;

import org.mingtaoz.leetcode.toolbox.graph.UndirectedGraph.UndirectedGraphNode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class UndirectedGraphTest extends TestCase {

	private UndirectedGraph sut;

	public UndirectedGraphTest(String testName) {
		super(testName);
		sut = new UndirectedGraph();
	}

	public static Test suite() {
		return new TestSuite(UndirectedGraphTest.class);
	}

	public void testSerializeUndirectedGraph1() {
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);

		List<UndirectedGraphNode> n0Neighbor = new ArrayList<UndirectedGraphNode>();
		List<UndirectedGraphNode> n1Neighbor = new ArrayList<UndirectedGraphNode>();
		List<UndirectedGraphNode> n2Neighbor = new ArrayList<UndirectedGraphNode>();

		n0Neighbor.add(n1);
		n0Neighbor.add(n2);

		n1Neighbor.add(n0);
		n1Neighbor.add(n2);

		n2Neighbor.add(n0);
		n2Neighbor.add(n1);
		n2Neighbor.add(n2);

		n0.neighbors = n0Neighbor;
		n1.neighbors = n1Neighbor;
		n2.neighbors = n2Neighbor;

		sut.node = n0;
		
		assertEquals("0,1,2#1,0,2#2,0,1,2", sut.serializeGraph());
	}
	
	public void testCloneGraph() {
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);

		List<UndirectedGraphNode> n0Neighbor = new ArrayList<UndirectedGraphNode>();
		List<UndirectedGraphNode> n1Neighbor = new ArrayList<UndirectedGraphNode>();
		List<UndirectedGraphNode> n2Neighbor = new ArrayList<UndirectedGraphNode>();

		n0Neighbor.add(n1);
		n0Neighbor.add(n2);

		n1Neighbor.add(n0);
		n1Neighbor.add(n2);

		n2Neighbor.add(n0);
		n2Neighbor.add(n1);
		n2Neighbor.add(n2);

		n0.neighbors = n0Neighbor;
		n1.neighbors = n1Neighbor;
		n2.neighbors = n2Neighbor;

		sut.node = n0;
		
		sut.node = sut.cloneGraph();
		
		assertEquals("0,1,2#1,0,2#2,0,1,2", sut.serializeGraph());
	}
}
