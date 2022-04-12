package com.arithmatics;
import java.util.Scanner;

public class Quad {

    public static void main(String[] args) {

        int a, b, c;
        double r1, r2;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the coefficients");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        double D = Math.sqrt((b * b) - (4 * a * c));

        r1 = (-b + D) / (2 * a);
        r2 = (-b - D) / (2 * a);

        System.out.println("the roots are r1 = "+ r1+ " r2 = " +r2);
    }
}
