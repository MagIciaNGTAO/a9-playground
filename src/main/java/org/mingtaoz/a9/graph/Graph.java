package org.mingtaoz.a9.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class GraphNode {

    public int label;
    public List<GraphNode> neighbors;

    public GraphNode(int x) {
        label = x;
        neighbors = new ArrayList<GraphNode>();
    }

}

public class Graph {

    public GraphNode node;

    public GraphNode cloneGraph() {
        return cloneGraph(node);
    }

    public String serializeGraph() {
        return serializeGraph(node);
    }

    public boolean isBipartite() {
        return dfsColoring(node, new HashMap<>(), 1);
    }

    // color 1 for A, -1 for B
    private boolean dfsColoring(GraphNode node, Map<GraphNode, Integer> colorOfVisited, int color) {
        colorOfVisited.put(node, color);
        for (GraphNode neighbor : node.neighbors) {
            if (!colorOfVisited.containsKey(neighbor)) {
                // tree edge
                if (!dfsColoring(neighbor, colorOfVisited, -color)) {
                    return false;
                }
            } else {
                // forward/back/cross edge
                if (colorOfVisited.get(neighbor) == colorOfVisited.get(node)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void dfsFull(GraphNode node, Map<GraphNode, Integer> sequenceOfVisited, Set<GraphNode> mark, int sequence) {
        // visit
        System.out.println("current: " + node.label);
        sequenceOfVisited.put(node, ++sequence);
        // NOTE: mark current recursion tree
        mark.add(node);
        for (GraphNode neighbor : node.neighbors) {
            if (!sequenceOfVisited.containsKey(neighbor)) {
                // tree edge
                System.out.println("tree edge: " + node.label + " to " + neighbor.label);
                dfsFull(neighbor, sequenceOfVisited, mark, sequence);
            } else if (sequenceOfVisited.get(neighbor) > sequence) {
                // forward edge
                System.out.println("forward edge: " + node.label + " to " + neighbor.label);
            } else if (!mark.contains(neighbor)) {
                // cross edge
                System.out.println("cross edge: " + node.label + " to " + neighbor.label);
            } else {
                // back edge
                System.out.println("back edge: " + node.label + " to " + neighbor.label);
            }
        }
        mark.remove(node);
    }

    /**
     * 
     * Clone an undirected graph. Each node in the graph contains a label and a
     * list of its neighbors.
     * 
     * @param node
     * @return
     */
    public static GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return node;
        }
        // mapping label with new graph node
        Map<GraphNode, GraphNode> newNodes = new HashMap<>();
        Queue<GraphNode> toBeVisit = new LinkedList<>();
        toBeVisit.add(node);
        GraphNode newSource = new GraphNode(node.label);
        newNodes.put(node, newSource);
        while (!toBeVisit.isEmpty()) {
            GraphNode visiting = toBeVisit.poll();
            GraphNode copyTo = newNodes.get(visiting);
            for (GraphNode neighbour : visiting.neighbors) {
                GraphNode newNode;
                if (!newNodes.containsKey(neighbour)) {
                    // add to be visited
                    toBeVisit.add(neighbour);
                    // haven't created newNode
                    newNode = new GraphNode(neighbour.label);
                    newNodes.put(neighbour, newNode);
                } else {
                    newNode = newNodes.get(neighbour);
                }
                copyTo.neighbors.add(newNode);
            }
        }
        return newSource;
    }

    static Map<GraphNode, GraphNode> map = new HashMap<>();

    // DFS
    public static GraphNode cloneGraphDFS(GraphNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        GraphNode newGraph = new GraphNode(node.label);
        map.put(node, newGraph);
        for (GraphNode neighbour : node.neighbors) {
            GraphNode newNeighbour = cloneGraphDFS(neighbour);
            newGraph.neighbors.add(newNeighbour);
        }
        return newGraph;
    }

    /**
     * 
     * Nodes are labeled uniquely.
     * 
     * We use # as a separator for each node, and , as a separator for node
     * label and each neighbor of the node. As an example, consider the
     * serialized graph {0,1,2#1,0,2#2,0,1,2}.
     * 
     * The graph has a total of three nodes, and therefore contains three parts
     * as separated by #.
     * 
     * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second
     * node is labeled as 1. Connect node 1 to node 2. Third node is labeled as
     * 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
     * 
     * @param node
     * @return
     */
    // TODO this is simple as the label is stored in each node
    public static String serializeGraph(GraphNode node) {
        StringBuilder ret = new StringBuilder();
        Set<Integer> marked = new HashSet<Integer>();
        Queue<GraphNode> toVisit = new LinkedList<GraphNode>();
        toVisit.add(node);
        marked.add(node.label); // marked
        while (!toVisit.isEmpty()) {
            GraphNode visiting = toVisit.poll();
            ret.append(visiting.label); // append to result
            for (GraphNode neighbor : visiting.neighbors) {
                if (!marked.contains(neighbor.label)) {
                    toVisit.add(neighbor);
                    marked.add(neighbor.label); // marked
                }
                ret.append(",").append(neighbor.label); // append to result
            }
            ret.append("#");
        }

        if (ret.length() > 0) {
            // get rid off appended #
            return ret.substring(0, ret.length() - 1);
        } else {
            return ret.toString();
        }
    }
}
