package com.daa;

import java.util.Scanner;

public class Que6 {

    static int findDiffer(int[] arr,int key) {
        int count =0 ;
        for(int i =0 ;i < arr.length;i++)
        {
            for(int j =0 ;j< arr.length;j++)
            {
                if(arr[i]-arr[j] == key)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Test Cases:");
        int t = sc.nextInt();

        while (t != 0) {
            System.out.println("Enter the size of the array: ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            System.out.println("Enter the key");
            int key = sc.nextInt();
            int count = findDiffer(arr, key);
            System.out.println(count);
            t--;
        }
    }

}

