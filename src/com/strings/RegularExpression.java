package com.strings;
import java.lang.*;
public class RegularExpression {
    public static void main(String[] args) {
            int n = 101011010;
            String  str = n+"";
            if(str.matches("[01]*"))
                System.out.println("True");

            String s = "4654ADE6454";
            if(s.matches("[0-9A-F]*"))
                System.out.println("True");

            String  date = "12/03/2003";
            if(s.matches("[0-3][0-9]/[0|1][0-9]/[0-9]{4}"))
                System.out.println("True");

    }
}
