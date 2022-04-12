package com.daa;

import java.util.Scanner;

public class Que1 {

   static int  linearSearch(int arr[], int n, int key)
    {
        for(int i= 0 ; i < n  ; i ++ ){
            if ( key == arr[i])
                return 1;
        }
        return  0 ;
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

           int result = linearSearch(arr , n ,key);

           if(result==1) {
               System.out.println("Present " + key);
           }else{
               System.out.println("Not 1Present " + key);
           }
            t--;
        }
    }
}
