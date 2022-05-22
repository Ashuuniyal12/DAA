package com.daa;

public class MedianOfArray {
    static int a = -1, b = -1;

    private static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    private static int partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l, j = h;
        while (i < j) {
            do {
                i++;
            } while (arr[i] <= pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j) {
                swap(arr[i], arr[j]);
            }
        }
        swap(arr[j],arr[l]);
        return j;
    }

    private static void median(int[] arr, int l, int h, int k) {
        if (l <= h) {
            int index = partition(arr, l, h);
            if (index == k) {
                a = arr[index];
                if (b != -1)
                    return;
            } else if (index == k - 1) {
                b = arr[index];
                if (a != -1) return;
            }
            if(index < k)
                median(arr,index+1,h,k);
            else
                median(arr,l,index-1,k);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, 3, 7, 3, 9};
        int ans = 0;
        if (arr.length % 2 == 1) {
            median(arr, 0, arr.length, arr.length / 2);
            ans = a;
        } else {
            median(arr, 0, arr.length, arr.length / 2);
            ans = (a + b) / 2;
        }
        System.out.println("Median is " + ans);
    }
}
