package com.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class cycleInDirectedUsingDFS {

    static LinkedList<LinkedList> adj;

    cycleInDirectedUsingDFS(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Integer>());
        }
    }

    void addEle(int s, int d) {
        adj.get(s).add(d);
    }

    static boolean isCycle(int v) {
        boolean vis[] = new boolean[v];
        int dfsVis[] = new int[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkCycle(i, vis, dfsVis)) return true;
            }
        }
        return false;
    }

    private static boolean checkCycle(int v, boolean[] vis, int[] dfsVis) {
        vis[v] = true;
        dfsVis[v] = 1;

        for (Object ele : adj.get(v)) {
            if (!vis[(int) ele]) {
                vis[(int) ele] = true;
                if (checkCycle((int) ele, vis, dfsVis)) return true;
            } else if (dfsVis[(int) ele] == 1)
                return true;
        }
        dfsVis[v] = 0;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        cycleInDirectedUsingDFS graph = new cycleInDirectedUsingDFS(v);

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
