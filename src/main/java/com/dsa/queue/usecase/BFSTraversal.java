package com.dsa.queue.usecase;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Let Q be a queue
 *  Q.enqueue(start_node)
 *  start_node.visited = true
 *  while Q is not empty Do
 *      node = Q.dequeue()
 *      for neighbor in neighbors(node):
 *          neighbor.visited = true
 *          Q.enqueue(neighbor)
 */
public class BFSTraversal {
    // total number of nodes in the graph
    private int node;
    // adjacency list
    private LinkedList<Integer> adj[];
    // maintaining a queue
    private Queue<Integer> que;

    public static void main(String args[]) {
        BFSTraversal graph = new BFSTraversal(6);
        // (edges are bidirectional in this example)
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 3);
        graph.insertEdge(0, 4);
        graph.insertEdge(4, 5);
        graph.insertEdge(3, 5);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 0);
        graph.insertEdge(2, 1);
        graph.insertEdge(4, 1);
        graph.insertEdge(3, 1);
        graph.insertEdge(5, 4);
        graph.insertEdge(5, 3);
        System.out.println("Breadth First Traversal for the graph is:");
        graph.BFS(0);
    }

    BFSTraversal(int v) {
        node = v;
        adj = new LinkedList[node];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
        que = new LinkedList<>();
    }

    void insertEdge(int v,int w) {
        // adding an edge to the adjacency list
        adj[v].add(w);
    }

    void BFS(int n) {
        // initialize boolean array for holding the data
        boolean[] nodes = new boolean[node];
        int a = 0;
        nodes[n]=true; // true == isVisited

        // root node is added to the top of the queue
        que.add(n);

        while (!que.isEmpty()) {
            // remove the top element of the queue and print it out
            n = que.poll();
            System.out.print(n+" ");

            // iterate through the linked list and push all neighbors into queue
            for (int i = 0; i < adj[n].size(); i++)  {
                a = adj[n].get(i);
                // only insert nodes into queue if they have not been explored already
                if (!nodes[a]) {
                    nodes[a] = true;
                    que.add(a);
                }
            }
        }
    }
}
