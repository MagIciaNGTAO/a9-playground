package org.mingtaoz.a9.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.mingtaoz.a9.graph.Graph;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GraphTest extends TestCase {

    private Graph sut;

    public GraphTest(String testName) {
        super(testName);
        sut = new Graph();
    }

    public static Test suite() {
        return new TestSuite(GraphTest.class);
    }

    public void testSerializeUndirectedGraph1() {
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);

        List<GraphNode> n0Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n1Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n2Neighbor = new ArrayList<GraphNode>();

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
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);

        List<GraphNode> n0Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n1Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n2Neighbor = new ArrayList<GraphNode>();

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

    public void testIsBipartite() {
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);

        List<GraphNode> n0Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n1Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n2Neighbor = new ArrayList<GraphNode>();

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

        assertFalse(sut.isBipartite());
    }

    public void testIsBipartite2() {
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);

        List<GraphNode> n0Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n1Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n2Neighbor = new ArrayList<GraphNode>();

        n0Neighbor.add(n1);
        n0Neighbor.add(n2);

        n1Neighbor.add(n0);

        n2Neighbor.add(n0);

        n0.neighbors = n0Neighbor;
        n1.neighbors = n1Neighbor;
        n2.neighbors = n2Neighbor;

        sut.node = n0;

        assertTrue(sut.isBipartite());
    }

    public void testDFS() {
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);

        List<GraphNode> n0Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n1Neighbor = new ArrayList<GraphNode>();
        List<GraphNode> n2Neighbor = new ArrayList<GraphNode>();

        n0Neighbor.add(n1);
        n0Neighbor.add(n2);

        n1Neighbor.add(n2);

        n2Neighbor.add(n0);

        n0.neighbors = n0Neighbor;
        n1.neighbors = n1Neighbor;
        n2.neighbors = n2Neighbor;

        sut.dfsFull(n0, new HashMap<>(), new HashSet<>(), 0);
    }
}
