package com.graph;

import java.util.*;

public class graphDfs {
    private static LinkedList<LinkedList> adj;

    graphDfs(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Integer>());
        }
    }

    void addEle(int source, int dest) {
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }

    public static void dfsutil(int v, boolean[] vis, ArrayList<Integer> ans) {
        vis[v] = true;
        ans.add(v);
        for (Object neigh : adj.get(v)) {
            if(!vis[(int) neigh]) {
                dfsutil((Integer) neigh, vis, ans);
            }
        }
    }

    public static void dfs(int v) {
        boolean vis[] = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (!vis[i])
                dfsutil(i, vis, ans);
        }

        System.out.println("DFS traversal for graph is : ");

        for (int ele : ans)
            System.out.print(ele + "->");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        graphDfs graph = new graphDfs(v);

        System.out.println("Enter " + e + " edges");

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.addEle(s, d);
        }
        graph.dfs(v);
    }
}
