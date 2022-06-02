package com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSortBFS {
    private static LinkedList<LinkedList> adj;

    TopologicalSortBFS(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<Integer>());
        }
    }

    void addEle(int source, int dest) {
        adj.get(source).add(dest);
    }

    void bfs(int v) {
        int topo[] = new int[v];
        int indegree[] = new int[v];
        for (int i = 0; i < v; i++) {
            for (Object it : adj.get(i)) {
                indegree[(int) it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0;i<v;i++ ){
            if(indegree[i] == 0)
                q.add(i);
        }
        int ind = 0;
        while (!q.isEmpty()){
            int node = q.poll();
            topo[ind++] = node;

            for(Object ele : adj.get(node)){
                indegree[(int)ele]--;
                if(indegree[(int)ele]== 0)
                    q.add((int)ele);
            }
        }

        for(int it :  topo)
            System.out.print(it+" ");

    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        TopologicalSortBFS graph = new TopologicalSortBFS(v);

        System.out.println("Enter " + e + " edges");

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.addEle(s, d);
        }
        graph.bfs(v);
    }
}
