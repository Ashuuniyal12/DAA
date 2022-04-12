package com.daa;

import java.util.Scanner;

public class Ques8 {
    static void selectionSort(int arr[]) {
        int comp = 0, shift = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                comp++;
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            shift++;
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Comparison = " + comp);
        System.out.println("Shift = " + shift);
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
            selectionSort(arr);
            for (int item : arr)
                System.out.print(item + " ");
            t--;
        }
    }
}
