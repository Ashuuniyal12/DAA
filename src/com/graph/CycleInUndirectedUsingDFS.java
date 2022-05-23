package com.graph;

import java.util.*;

public class CycleInUndirectedUsingDFS {

        static LinkedList<LinkedList> adj;

        CycleInUndirectedUsingDFS(int v) {
            adj = new LinkedList<>();
            for (int i = 0; i < v; i++) {
                adj.add(i, new LinkedList<Integer>());
            }
        }

        void addEle(int s, int d) {
            adj.get(s).add(d);
            adj.get(d).add(s);
        }

     static boolean isCycle(int v) {
            boolean vis [] = new  boolean[v];
            for (int i =0 ; i< v ; i++){
                if(!vis[i]){
                    if(checkCycle(i, vis,-1))return  true;
                }
            }return false;
    }

    private static boolean checkCycle(int i, boolean[] vis,int parent) {
            vis[i] =true;
            for(Object ele : adj.get(i)){
                if(!vis[(int) ele]){
                    vis[(int)ele] = true;
                    if(checkCycle((int)ele, vis, i))
                        return true;
                    else if( parent != (int)ele) {
                        return true;
                    }
                }
            }return false;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertex and edges");
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        cycleInUndirectedUsingBFS graph = new cycleInUndirectedUsingBFS(v);

        System.out.println("Enter " + e + " edges");

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.addEle(s, d);
        }
        if (isCycle(v))
            System.out.println("Cycle present");
        else
            System.out.println("Cycle not present");
    }
}
