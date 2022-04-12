package com.strings;

import java.lang.*;
import java.util.Scanner;

/*find user mail is on gmail  and separate username and domain name*/
public class StingFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user mail address: ");
        String s = sc.nextLine();
        int index = s.indexOf("@");
        String userName = s.substring(0,index);
        String domainName = s.substring(index+1);
        System.out.println("user name is : "+userName);
        if(domainName.equals("gmail.com")){
            System.out.println("Mail domain in gmail.com");
        }
        else
            System.out.println("Not a gmail address");
    }
}

