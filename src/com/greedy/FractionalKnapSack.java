package com.greedy;

import java.util.ArrayList;
import java.util.Collections;

class ValueWeight implements Comparable<ValueWeight> {
    int index, ratio;

    ValueWeight(int index, int weightratio) {
        this.index = index;
        this.ratio = weightratio;
    }

    public int compareTo(ValueWeight o) {
        return o.ratio - this.ratio;
    }
}

public class FractionalKnapSack {

    public static void main(String[] args) {
        int n = 3, w = 50;
        int value[] = {60, 120 ,100};
        int weight[] = {10, 30, 20};

        ArrayList<ValueWeight> ar = new ArrayList<>();
        for (int i = 0; i < value.length; i++) {
            int x = value[i] / weight[i];
            ar.add(new ValueWeight(i, x));
        }

        Collections.sort(ar);
        int ans = 0;
        int s = 0;
        for (int i = 0; i < value.length; i++) {
            if (s + weight[ar.get(i).index] < w) {
                ans += value[ar.get(i).index];
                s += weight[ar.get(i).index];
            }else {
                ans += ar.get(i).ratio*(w-s);
                break;
            }
        }
        System.out.println("total Value is " +ans);
    }
}
