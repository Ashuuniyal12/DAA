package com.daa;

import java.util.Arrays;
import java.util.Scanner;

public class Ques9 {

    static void checkDuplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i + 1]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
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

            checkDuplicate(arr);
            t--;
        }
    }


}
