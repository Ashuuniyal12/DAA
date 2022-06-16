package com.graph;

import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node> {

    int u, v, w;

    Node(int _u, int _v, int _w) {
        u = _u;
        v = _v;
        w = _w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class KruskalAlgorithm {

    static int findParent(int i, int parent[]) {
        if (parent[i] == i)
            return i;
        return parent[i] = findParent(parent[i], parent);
    }

    static void union(int u, int v, int parent[], int rank[]) {
        u = findParent(u, parent);
        v = findParent(v, parent);
        if (rank[u] < rank[v])
            parent[u] = v;
        else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    static void kruskal(ArrayList<Node> adj, int n) {
        Collections.sort(adj);
        int parent[] = new int[n];
        int rank[] = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int cost = 0;
        ArrayList<Node> mst = new ArrayList<>();
        for (Node ele : adj) {
            if (findParent(ele.u, parent) != findParent(ele.v, parent)) {
                cost += ele.w;
                mst.add(ele);
                union(ele.u, ele.v, parent, rank);
            }
        }
        System.out.println("Total Cost is "+ cost);
        for (Node it : mst) {
            System.out.println(it.u + " - " + it.v);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();

        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));
        kruskal(adj, n);
    }
}
