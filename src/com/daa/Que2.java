package com.daa;

import java.util.Scanner;

public class Que2{

    static int  binarySearch(int arr[], int start ,int end, int key)
    {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return 1;
            else if (arr[mid] < key)
                start= mid + 1;
            else
                end = mid - 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Test Cases:");
        int t = sc.nextInt();

        while(t != 0){
            System.out.println("Enter the size of the array: ");
            int n = sc.nextInt();
            int arr[] = new int [n];
            System.out.println("Enter elements : ");
            for(int i=0 ;i < n ; i ++)
                arr[i] = sc.nextInt();
            System.out.println("Enter the key to be searched: ");
            int key = sc.nextInt();

            int result = binarySearch(arr ,0, n -1,key);

            if(result==1) {
                System.out.println("Present " + key);
            }else{
                System.out.println("Not Present " + key);
            }
            t--;
        }
    }
}
