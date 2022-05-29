package com.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class biparatedDFS {

    static LinkedList<LinkedList> adj;

    biparatedDFS(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Integer>());
        }
    }

    void addEle(int s, int d) {
        adj.get(s).add(d);
        adj.get(d).add(s);
    }

    private static boolean checkBipartite(int v) {
        int col[] = new int[v];
        for (int i = 0; i < v; i++) {
            col[i] = -1;
        }

        for (int i = 0; i < v; i++) {
            if (col[i] == -1) {
                if (dfsBiparated(i, col))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfsBiparated(int v, int col[]) {
        if (col[v] == -1) col[v] = 1;

        for (Object ele : adj.get(v)) {
            if (col[(int) ele] == -1) {
                col[(int) ele] = 1 - col[v];
                if (dfsBiparated((int) ele, col)) return true;
            } else if (col[(int) ele] == col[v]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        biparatedDFS graph = new biparatedDFS(v);

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

