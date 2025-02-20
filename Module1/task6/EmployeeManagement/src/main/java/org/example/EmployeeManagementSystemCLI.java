package org.example;

import java.util.Scanner;


public class EmployeeManagementSystemCLI {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter class type (Employee, Manager, or HumanResource): ");
        String type = sc.nextLine();

          //  Runtime Polymorphism
         Employee employee = EmployeeGroup.createEmployee(type);

         if (employee != null) {
             employee.displayDetails(type);
         }
    }

}
