package com.daa;

import java.util.Random;
import java.util.Scanner;

public class Ques11 {
    private static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    private static void random(int[] arr, int l, int h) {
        Random r = new Random();
        int pivot = r.nextInt(h);
        swap(pivot,arr[h]);
    }

    private static int partition(int[] arr, int l, int h) {
        random(arr,l,h);
        int pivot = arr[l];
        int i = l, j = h;
        while (i < j) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j++;
            } while (arr[j] > pivot);
            if (i < j) {
                swap(arr[i], arr[j]);
            }
        }
        swap(arr[j], pivot);
        return j;
    }

    private static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int index = partition(arr, l, h);
            quickSort(arr, l, index - 1);
            quickSort(arr, index + 1, h);
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
            System.out.println("Enter elāements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            quickSort(arr, 0, arr.length - 1);
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            t--;
        }
    }

}
