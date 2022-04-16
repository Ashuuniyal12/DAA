package com.oopsInJava;

import java.util.Scanner;

class Employee {
    String name;
    int id;
    String department;
    Float salary;

    void setDetails(String name, int id, String department, float salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

    void showDetails() {
        System.out.println("Name : " + this.name);
        System.out.println("Id : " + this.id);
        System.out.println("Department : " + this.department);
        System.out.println("Salary : " + salary);
    }
}

class Office {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Employee id");
        int id = sc.nextInt();

        System.out.println("Enter Employee department");
        String department = sc.next();

        System.out.println("Enter Employee salary");
        int salary = sc.nextInt();

        Employee e1 = new Employee();
        e1.setDetails(name, id, department, salary);
        e1.showDetails();
    }
}
