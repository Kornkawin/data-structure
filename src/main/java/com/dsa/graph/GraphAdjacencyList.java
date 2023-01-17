package com.dsa.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphAdjacencyList implements Graph {
    int nVertices;
    LinkedList<Integer>[] adjLists;

    @SuppressWarnings("unchecked")
    public GraphAdjacencyList(int nVertices) {
        this.nVertices = nVertices;
        adjLists = new LinkedList[nVertices];

        for (int i = 0; i < nVertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(int source, int destination){
        if (source < nVertices && destination < nVertices){
            this.adjLists[source].addLast(destination);

            //for undirected graph uncomment the line below
            //this.adjLists[destination].addLast(source);
        }
    }

    public void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < nVertices; i++) {
            if(adjLists[i] != null) {
                System.out.print("|" + i + "| => ");
                for (int j = 0; j < adjLists[i].size(); j++) {
                    System.out.print("[" + adjLists[i].get(j) + "] -> ");
                }
                System.out.println("null");
            }
            else{
                System.out.println("|" + i + "| => null");
            }
        }
    }

    @Override
    public int size() {
        return nVertices;
    }

    @Override
    public boolean isEmpty() {
        return nVertices == 0;
    }
}
