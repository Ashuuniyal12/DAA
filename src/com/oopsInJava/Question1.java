package com.oopsInJava;

class Student {

    String name;
    int id;
    String universityName;
    String branch;

    void setDetails(String name, int id, String unversityName, String branch) {
        this.name = name;
        this.id = id;
        this.universityName = unversityName;
        this.branch = branch;
    }

    void showDetails() {
        System.out.println(name + " " + id + " " + universityName + " " + branch);
    }
}
class Main{
    public static void main(String args[]) {
        Student s = new Student();
        s.setDetails("Ashutosh", 13, "GEHU", "CSE");
        s.showDetails();
    }
}