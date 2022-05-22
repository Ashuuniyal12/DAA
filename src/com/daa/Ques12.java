package com.daa;

import java.util.Scanner;

public class Ques12 {

    private static int findMax(int[] arr) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (max <= arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void countSort(int[] arr) {
        int max = findMax(arr);
        int output[] = new int[arr.length];
        int countarray[] = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            countarray[arr[i]]++;
        }

        for (int i = 1; i < countarray.length; i++) {
            countarray[i] += countarray[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[--countarray[arr[i]]] = arr[i];
        }
        for (int i = 0; i < output.length; i++) {
            arr[i] = output[i];
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

            countSort(arr);

            for (int item : arr)
                System.out.print(item + " ");

            System.out.println("Enter the Kth index value ");
            int k = sc.nextInt();
            if (k - 1 < arr.length)
                System.out.println(arr[k - 1]);
            else
                System.out.println("Not Present ");
            t--;
        }
    }
}
