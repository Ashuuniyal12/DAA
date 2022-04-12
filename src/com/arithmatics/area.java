package com.arithmatics;

import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l, b, h;
        int totalArea, volume;
        System.out.println("Enter the length width and height of cuboid");
        l = sc.nextInt();
        b = sc.nextInt();
        h = sc.nextInt();

        volume = l * b * h;
        totalArea = 2 * (l * b + b * h + l * h);
        System.out.println("Total area = " + totalArea + "\n1Volume = " + volume);

    }
}
