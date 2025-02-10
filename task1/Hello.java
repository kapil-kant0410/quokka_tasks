
// Problem Statement:

// Create a Java program that calculates an employee's salary after adding allowances and deducting taxes. The program should:
//  Use basic arithmetic operators (+, -, *, /).
//   Use type casting to ensure correct calculations.
//   Use string concatenation (+) to display results.
//   Use ternary (? :) operator to check if the salary is taxable.
// Requirements:

// Create variables for:
// baseSalary
// allowance 
// taxRate 
// netSalary
// Assume the following conditions ternary operator:
//  If the salary is greater than 50,000, apply 10% tax.Otherwise, apply 0% tax.
// Instead of a condition, use mathematical expressions to determine the tax rate.
// Display results using string concatenation (+).

// Example Output: 

// Base Salary: 45000.0  
// Allowance: 7000.0  
// Gross Salary: 52000.0  
// Tax Applied: 5200.0  
// Net Salary: 46800.0

import java.util.*;

public class Hello {
   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter your base sallary");
      double baseSalary = scanner.nextDouble();
      System.out.println("Enter your allowance");
      double allowance = scanner.nextDouble();

      double grossSalary = baseSalary + allowance;

      double totalTax = (grossSalary > 50000) ? grossSalary * 0.10 : 0;

      double netSalary = grossSalary - totalTax;
      System.out.println("Base Salary:" + baseSalary);
      System.out.println("Allowance:" + allowance);
      System.out.println("Gross Salary:" + grossSalary);
      System.out.println("Net Salary:" + netSalary);

      scanner.close();
   }
}