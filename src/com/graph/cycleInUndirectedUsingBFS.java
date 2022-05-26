package com.graph;

import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class cycleInUndirectedUsingBFS {
    static LinkedList<LinkedList> adj;

    cycleInUndirectedUsingBFS(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i <=v; i++) {   // start from 0 and end before v if graph start from 0
                                                // and start from 0 end at v if start from 1
            adj.add(i, new LinkedList<Integer>());
        }
    }

    void addEle(int s, int d) {
        adj.get(s).add(d);
        adj.get(d).add(s);
    }

    static boolean isCycle(int v) {
        boolean vis[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkCycle(i, vis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkCycle(int v, boolean vis[], LinkedList<LinkedList> adj) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(v, -1));

        vis[v] = true;

        while (!q.isEmpty()) {
            int node = q.peek().x;
            int par = q.peek().y;
            q.remove();
            for (Object ele : adj.get(node)) {
                if (!vis[(int) ele]) {

                    vis[(int) ele] = true;
                    q.add(new Pair((int) ele, node));

                } else if (par != (int) ele) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        cycleInUndirectedUsingBFS graph = new cycleInUndirectedUsingBFS(v);

        System.out.println("Enter " + e + " edges");

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.addEle(s, d);
        }
        if (isCycle(v))
            System.out.println("Cycle present");
        else
            System.out.println("Cycle not present");
    }
}