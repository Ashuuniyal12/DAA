package com.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class GraphLinkedList {

    private LinkedList<LinkedList> adj;

    GraphLinkedList(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Integer>());
        }
    }

    public void addEdge(int source, int destination) {
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    public void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adj list of vertex " + i + " is ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertex");
        v = sc.nextInt();

        GraphLinkedList graph = new GraphLinkedList(v);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 2);

        graph.printGraph();
    }
}
