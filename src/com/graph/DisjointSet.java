package com.graph;

import java.util.Arrays;
import java.util.Scanner;

public class DisjointSet {
    static int parent[];
    static int rank[];
    int v;

    DisjointSet(int v) {
        this.v = v;
        parent = new int[v];
        rank = new int[v];

        Arrays.fill(rank, 1);
        for (int i = 0; i < v; i++)
            parent[i] = i;
    }

    private static int find(int i) {
        if (parent[i] != i)
            parent[i] = find(parent[i]);
        return parent[i];
    }

    private static void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x == y) return;
        if (rank[x] < rank[y])
            parent[x] = y;
        else if (rank[y] < rank[x])
            parent[y] = x;
        else {
            parent[x] = y;
            rank[y]++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertices");
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        DisjointSet ds = new DisjointSet(v);
        union(1, 2); //make friend()
        union(3,4);
        union(2,4);
        union(5,8);
        union(0,3);
        union(8,3);
        union(0,5);
        if(find(0)==find(2)) System.out.println("Are friend"); //find friend
        else System.out.println("Are not friend");
    }
}
