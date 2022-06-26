package com.graph;

import java.util.ArrayList;
import java.util.Arrays;

class Pir {
    int v, u, w;

    Pir(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class BellmanFord {

    private static void bellman(int src, int n, ArrayList<Pir> adj) {
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (Pir ele : adj) {
                if (dis[ele.u] + ele.w < dis[ele.v])
                    dis[ele.v] = ele.w + dis[ele.u];

            }
        }
        boolean flg = false;
        for (Pir ele : adj) {
            if (dis[ele.u] + ele.w < dis[ele.v])
                flg = true;
        }
        if (!flg) for (int i = 0; i < dis.length; i++)
            System.out.println(i + " " + dis[i]);
        else
            System.out.println("NEGATIVE CYCLE DETECTED");
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Pir> adj = new ArrayList<>();
        adj.add(new Pir(0, 1, 2));
        adj.add(new Pir(0, 3, 6));
        adj.add(new Pir(1, 3, -8));
        adj.add(new Pir(1, 2, 3));
        adj.add(new Pir(1, 4, 5));
        adj.add(new Pir(2, 4, 7));

        bellman(0, n, adj);
    }

}
