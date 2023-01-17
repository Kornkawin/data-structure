package com.dsa.graph;

public class GraphAdjacencyListTest {
    public static void main(String[] args) {
        System.out.println("GraphAdjacencyListTest");
        GraphAdjacencyList graph = new GraphAdjacencyList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.printGraph();
    }
}
