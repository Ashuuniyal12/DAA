package com.graph;

import java.util.Arrays;
import java.util.LinkedList;

class Paier implements Comparable<Paier> {
    int v, w;

    Paier(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Paier o) {
        return this.w - o.w;
    }
}

public class PrimsAlgorithm {
    static LinkedList<LinkedList<Paier>> adj;

    PrimsAlgorithm(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Paier>());
        }
    }

    private static void prims(int strt, int v) {
        int[] key = new int[v];
        int parent[] = new int[v];
        boolean[] mst = new boolean[v];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;

        for (int i = 0; i < v - 1; i++) {
            int min = Integer.MAX_VALUE, u = 0;
            for (int j = 0; j < v; j++) {
                if (!mst[j] && key[j] < min) {
                    min = key[j];
                    u = j;
                }
            }

            mst[u] = true;

            for(Paier ele : adj.get(u)){
                if(!mst[ele.v] && key[ele.v] > ele.w)
                {
                    key[ele.v]= ele.w;
                    parent[ele.v] = u;
                }
            }
        }
        for (int i = 0 ; i< parent.length;i++)
            System.out.println("parent of "+ i+ "  is "+parent[i] );

    }

    public static void main(String[] args) {
        int n = 6;
        PrimsAlgorithm graph = new PrimsAlgorithm(n);


        adj.get(0).add(new Paier(1, 2));
        adj.get(1).add(new Paier(0, 2));

        adj.get(0).add(new Paier(4, 1));
        adj.get(4).add(new Paier(0, 1));

        adj.get(1).add(new Paier(2, 3));
        adj.get(2).add(new Paier(1, 3));

        adj.get(2).add(new Paier(3, 6));
        adj.get(3).add(new Paier(2, 6));

        adj.get(4).add(new Paier(2, 2));
        adj.get(2).add(new Paier(4, 2));

        adj.get(4).add(new Paier(5, 4));
        adj.get(5).add(new Paier(4, 4));

        adj.get(5).add(new Paier(3, 1));
        adj.get(3).add(new Paier(5, 1));
        prims(0, n);
    }
}
