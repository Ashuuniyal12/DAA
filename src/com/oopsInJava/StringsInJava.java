package com.oopsInJava;

public class StringsInJava {

    public static void main (String agrs[])
    {
        String s = "Java";

        // concat
        System.out.println(s.concat("Welcome"));
        System.out.println(s);
        //The strings are immutable by default so, they can't be appended  in case of concatenation the
        // strings are concatenated but , there is no change in original string pointed by s .

        // charAt()
        System.out.println(s.charAt(1));


        // find index at first 'a'

        System.out.println(s.indexOf('a'));

        // find index at second 'a'

        System.out.println(s.lastIndexOf('a'));

        // Compare

        System.out.println(s.equals("JAVA"));

        // Compare ignoring case
        System.out.println(s.equalsIgnoreCase("JAVA"));

        //index of first a from last
        System.out.println(s.lastIndexOf('a', 2));
    }
}