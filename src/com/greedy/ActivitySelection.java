package com.greedy;

import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair> {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Pair o) {
        return this.y - o.y;
    }
}

public class ActivitySelection {

    public static void main(String[] args) {
        int s[] = {1, 3, 0, 5, 8, 5}; //start time
        int e[] = {2, 4, 6, 7, 9, 9};//end time

        ArrayList<Pair> ar = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            ar.add(new Pair(s[i], e[i]));

        }
        Collections.sort(ar); // sort according  to the requirements of max or min

        int i = 0, j = 1, c = 1;

        while (j < s.length) {
            if (ar.get(i).y < ar.get(j).x ){
                c++;
                i=j;
                j++;
            }else j++;
        }
        System.out.println("NO of meeting can be done in time period are "+ c);
    }
}
