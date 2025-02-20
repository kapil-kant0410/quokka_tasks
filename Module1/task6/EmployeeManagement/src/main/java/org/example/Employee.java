package org.example;

public class Employee {
    int id;
    String name;
    String department;
    private int salary;

    // Use of this keyword to refer to the same class
    Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display employee details
    public void displayDetails(String type) {
        System.out.println(type + " " + "Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}
