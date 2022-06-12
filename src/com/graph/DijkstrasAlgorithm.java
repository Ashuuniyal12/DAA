package com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Paired implements Comparable<Paired> {
    int v, w;

    Paired(int v, int w) {
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Paired o) {
        return this.w - o.w;
    }
}

public class DijkstrasAlgorithm {

    static LinkedList<LinkedList<Paired>> adj;

    DijkstrasAlgorithm(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Paired>());
        }
    }

    private static void dijkstra(int src, int v) {
        int dis[] = new int[v];
        PriorityQueue<Paired> pq = new PriorityQueue<>();

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        pq.add(new Paired(0, 0));

        while (!pq.isEmpty()) {
            Paired node = pq.poll();

            for (Paired ele : adj.get(node.v)) {
                if (dis[node.v] + ele.w < dis[ele.v]) {
                    dis[ele.v] = dis[node.v] + ele.w;
                    pq.add(new Paired(ele.v, dis[ele.w]));
                }
            }
        }

        for(int ele : dis)
            System.out.print(ele + " ");
    }

    public static void main(String[] args) {
        int n = 6;
        DijkstrasAlgorithm graph = new DijkstrasAlgorithm(n);

        graph.adj.get(0).add(new Paired(1, 2));
        graph.adj.get(1).add(new Paired(0, 2));

        graph.adj.get(0).add(new Paired(4, 1));
        graph.adj.get(4).add(new Paired(0, 1));

        graph.adj.get(1).add(new Paired(2, 3));
        graph.adj.get(2).add(new Paired(1, 3));

        graph.adj.get(2).add(new Paired(3, 6));
        graph.adj.get(3).add(new Paired(2, 6));

        graph.adj.get(4).add(new Paired(2, 2));
        graph.adj.get(2).add(new Paired(4, 2));

        graph.adj.get(4).add(new Paired(5, 4));
        graph.adj.get(5).add(new Paired(4, 4));

        graph.adj.get(5).add(new Paired(3, 1));
        graph.adj.get(3).add(new Paired(5, 1));

        dijkstra(0, n);
    }
}
