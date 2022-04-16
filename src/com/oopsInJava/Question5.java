package com.oopsInJava;

class Students {

    String name;
    int id;
   static String universityName = "Graphic Era Hill University";
    String branch;

    void setDetails(String name, int id, String branch) {
        this.name = name;
        this.id = id;
        this.branch = branch;
    }

    void showDetails() {
        System.out.println(name + " " + id + " " + universityName + " " + branch);
    }
}
class College{
    public static void main(String args[]) {
        Students s = new Students();
        s.setDetails("Ashutosh", 13, "CSE");
        s.showDetails();
    }
}