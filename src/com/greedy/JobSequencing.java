package com.greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Data implements Comparable<Data> {
    int id, deadline, profit;

    Data(int x, int y, int z) {
        this.id = x;  //id
        this.deadline = y; // time
        this.profit = z; //profit
    }

    public int compareTo(Data o) {
        return o.profit - this.profit;
    }
}

public class JobSequencing {
    public static void main(String[] args) {

        ArrayList<Data> ad = new ArrayList<>();
        ad.add(new Data(1, 2, 100));
        ad.add(new Data(2, 1, 19));
        ad.add(new Data(3, 2, 27));
        ad.add(new Data(4, 1, 25));
        ad.add(new Data(5, 1, 15));

        Collections.sort(ad); // sorting decending to maximize profit
        boolean done[] = new  boolean[ad.size()];
        int day = 0, profit = 0 ;
        for( int i = 0 ; i< ad.size(); i++)
        {
            for(int  j =Math.min(ad.size(),ad.get(i).deadline) ;j >=0 ; j --){
                if(!done[j]){
                    profit+= ad.get(j).profit;
                    day++;
                    done[j] =true;
                    break;
                }
            }
        }
        System.out.println("Days = " + day+ " Profit = " +profit);
    }
}
