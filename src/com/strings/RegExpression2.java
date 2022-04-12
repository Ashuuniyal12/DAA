package com.strings;

public class RegExpression2 {
    public static void main(String[] args) {
        String s = "dfsag@sdrg%&&DTR W%614";
        String newS = s.replaceAll("[^a-zA-z0-9]","");
        System.out.println(newS);

        String s2 = "adsf aaD ASF     GASDFC      DREWTTS DDS FBasdf  sdfg";
        String newS2 = s2.replaceAll("\\s+"," ");
        System.out.println(newS2);

        String words[ ] = newS2.split("\\s");
        System.out.println(words.length);

    }
}
