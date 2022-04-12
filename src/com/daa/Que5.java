package com.daa;

import java.util.Scanner;

public class Que5 {

    static void findSum(int[] arr) {
        int n = arr.length;

        boolean flag = true;
        for (int k = 2; k < arr.length; k++) {
            int j = k - 1;
            int i = 0;
            while (i < j) {

                if (arr[i] + arr[j] == arr[k]) {
                    if(flag)
                        flag = false;
                    System.out.println(i + " " + j + " " + k);
                    i++;
                    j--;
                }
                if (arr[i] + arr[j] < arr[k])
                    i++;
                else
                    j--;
            }
        }
        if (flag)
            System.out.println("No Sequence Found");
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
            findSum(arr);
            t--;
        }
    }


}
