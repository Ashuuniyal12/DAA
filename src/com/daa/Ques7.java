package com.daa;

import java.util.Scanner;

public class Ques7 {
    static void insertionSort(int arr[]) {
        int com  =0 , shift = 0;

        for (int i = 1; i < arr.length;i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key  ) {
                com++;
                shift++;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            shift++;
        }
        System.out.println("Comparison = " +com);
        System.out.println("Shift = "+shift);
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
            insertionSort(arr);
            for (int item : arr)
                System.out.print(item+" ");
            t--;
        }
    }
}
