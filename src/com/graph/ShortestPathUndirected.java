package com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathUndirected {

    static LinkedList<LinkedList> adj;

    ShortestPathUndirected(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Integer>());
        }
    }

    void addEle(int s, int d) {
        adj.get(s).add(d);
        adj.get(d).add(s);
    }

    private static void shortPath(int v, int src) {
        int dis[] = new int[v];
        for (int i = 0; i < v; i++) {
            dis[i] = 10000000;
        }

        Queue<Integer> q = new LinkedList<>();
        dis[src] = 0;
        q.add(src);

        while (!q.isEmpty()) {
            int n = q.poll();
            for (Object ele : adj.get(n)) {
                if (dis[n] + 1 < dis[(int) ele]) {
                    dis[(int) ele] = dis[n] + 1;
                    q.add((int) ele);
                }
            }
        }

        for (int i = 0; i < v; i++) {
            System.out.print(dis[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        ShortestPathUndirected graph = new ShortestPathUndirected(v);

        System.out.println("Enter " + e + " edges");

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.addEle(s, d);
        }

        shortPath(v, 0);
    }
}
