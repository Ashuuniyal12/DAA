package com.daa;

import java.util.Scanner;

public class Que3 {

    static int jumpSearch(int arr[], int key) {
        int start = 0;
        int n = arr.length;
        int end = (int) Math.floor(Math.sqrt(arr.length));

        while (arr[end - 1] <= key && end < n) {
            start = end;
            end += (int) Math.floor(Math.sqrt(arr.length));
            if (end > n - 1) {
                end = n - 1;
                start--;
                break;
            }
        }

        for (int i = start; i <= end; i++) {
            if (key == arr[i])
                return 1;
        }
        return 0;
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
            System.out.println("Enter the key to be searched: ");
            int key = sc.nextInt();

            int result = jumpSearch(arr, key);

            if (result == 1) {
                System.out.println("Present " + key);
            } else {
                System.out.println("Not Present " + key);
            }
            t--;
        }
    }
}
