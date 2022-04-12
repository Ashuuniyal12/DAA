package com.daa;

import java.util.Scanner;

public class Ques10 {

    private static void merge(int[] arr, int l, int m, int h) {
        int n1 = m - l + 1;
        int n2 = h - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + 1];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;

        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    private static void mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, h);
            merge(arr, l, m, h);
        }
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
            mergeSort(arr, 0, arr.length - 1);
            for (int i = 0; i < n; i++)
                System.out.print(arr[i]+" ");
            t--;
        }
    }
}
