package com.graph;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSortDFS {
    private static LinkedList<LinkedList> adj;

    TopologicalSortDFS(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Integer>());
        }
    }

    void addEle(int source, int dest) {
        adj.get(source).add(dest);
    }

    public static void dfsutil(int v, boolean[] vis, Stack<Integer> st) {
        vis[v] = true;

        for (Object neigh : adj.get(v)) {
            if (!vis[(int) neigh]) {
                dfsutil((Integer) neigh, vis, st);
            }
        }
        st.push(v);
    }

    public static void dfs(int v) {
        boolean vis[] = new boolean[v];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (!vis[i])
                dfsutil(i, vis, st);
        }
        int ans[] = new int [v];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }

        for (int ele : ans)
            System.out.print(ele);
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        TopologicalSortDFS graph = new TopologicalSortDFS(v);

        System.out.println("Enter " + e + " edges");

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.addEle(s, d);
        }
        graph.dfs(v);
    }
}
