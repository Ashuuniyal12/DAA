package com.graph;

import java.util.LinkedList;
import java.util.Stack;

class Pairs {
    int v, w;

    Pairs(int v, int w) {
        this.v = v;
        this.w = w;
    }

    int getV() {
        return v;
    }

    int getW() {
        return w;
    }
}

public class ShortestPathDirectedAcylic {
    static LinkedList<LinkedList<Pairs>> adj;

    ShortestPathDirectedAcylic(int V) {
        adj = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new LinkedList<Pairs>());
        }
    }

    private static void topoUtil(int v, Stack<Integer> st, boolean[] vis) {
        vis[v] = true;
        for (Pairs ele : adj.get(v)) {
            if (!vis[ele.getV()])
                topoUtil(ele.getV(), st, vis);
        }
        st.push(v);
    }

    private static void shortPath(int strt, int v) {
        Stack<Integer> st = new Stack<>();
        int dis[] = new int[v];
        boolean vis[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if(!vis[i])
                topoUtil(i, st, vis);
        }


        for (int i = 0; i < v; i++)
            vis[i] = false;

        for (int i = 0; i < v; i++)
            dis[i] = Integer.MAX_VALUE;

        dis[strt] = 0;

        while (!st.isEmpty()) {
            int n = st.pop();
            for (Pairs ele : adj.get(n)) {
                if (dis[n] + ele.getW() < dis[ele.getV()])
                    dis[ele.getV()] = dis[n] + ele.getW();
            }
        }

        for (int i = 0; i < v; i++) {
            System.out.print(dis[i] + " ");
        }

    }

    public static void main(String[] args) {
        int n = 6;
        ShortestPathDirectedAcylic graph = new ShortestPathDirectedAcylic(n);

        graph.adj.get(0).add(new Pairs(1, 2));
        graph.adj.get(0).add(new Pairs(4, 1));
        graph.adj.get(1).add(new Pairs(2, 3));
        graph.adj.get(2).add(new Pairs(3, 6));
        graph.adj.get(4).add(new Pairs(2, 2));
        graph.adj.get(4).add(new Pairs(5, 4));
        graph.adj.get(5).add(new Pairs(3, 1));

        shortPath(0, n);
    }

}

