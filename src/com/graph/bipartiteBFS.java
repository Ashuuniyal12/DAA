package com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bipartiteBFS {

    static LinkedList<LinkedList> adj;

    bipartiteBFS(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Integer>());
        }
    }

    static void addEle(int s, int d) {
        adj.get(s).add(d);
        adj.get(d).add(s);
    }


    private static boolean checkBipartite(int v) {
        int col[] = new int[v];
        for (int i = 0; i <v; i++) {
            col[i] = -1;
        }

        for (int i = 0; i <v; i++) {
            if (col[i] == -1) {
                if (!bfsBipartite(i, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsBipartite(int v, int col[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        col[v] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Object ele : adj.get(node)) {
                if (col[(int) ele] == -1) {
                    col[(int) ele] = 1 - col[node];
                    q.add((int) ele);
                } else if (col[(int) ele ]== col[node]) {
                    return false;
                }
            }
        } return true;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        bipartiteBFS graph = new bipartiteBFS(v);

        System.out.println("Enter " + e + " edges");

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.addEle(s, d);
        }

        if (checkBipartite(v))
            System.out.println("Biparated graph");
        else
            System.out.println("Not a Biparated graph");
    }
}
