package com.filehandeling;

import java.io.FileReader;
import java.io.FileWriter;

public class ReadFromTextFile {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("D:\\JAVA\\src\\com\\filehandeling\\tct");
            FileWriter fw = new FileWriter("D:\\JAVA\\src\\com\\filehandeling\\tct");
            String s = "";
            int i;
            fw.write("Schools");
            while ((i = fr.read()) != -1) {
                s += (char) i;
            }
            System.out.println(s);
            fw.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("IO Exception" + e);
        }
    }
}
