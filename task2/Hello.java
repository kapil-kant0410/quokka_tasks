// Problem Statement:

// Create a Java program that manages student grades. The system should:
//  Take input for student names and marks in multiple subjects.
//  Use control flow statements (if-else, switch, loops).
//  Implement functions (methods) for different calculations.
//  Include method overloading for grade calculation.
//  Demonstrate pass-by-value.
//  Implement recursion to find the highest mark.
// Features to Implement:

// Take input for multiple students (Use a loop).
// Calculate total marks & average (Use a method).
// Assign grades using if-else or switch.
// Find the highest mark using recursion.
// Use method overloading to calculate grades based on either marks or average.
// Implement pass-by-value by attempting to modify a variable inside a method.
// Example Output:

// Enter number of students: 2

// Enter name of student 1: Alice

// Enter marks in 3 subjects: 85 90 80

// Total Marks: 255

// Average Marks: 85.0

// Grade: A

// Enter name of student 2: Bob

// Enter marks in 3 subjects: 78 88 92

// Total Marks: 258

// Average Marks: 86.0

// Grade: A

// Highest mark among all: 92

package task2;

import java.util.*;

public class Hello {

     // function for the calculation of total marks for the particular student

     public static int totalMarks(int[] students) {
          int totalMarks = 0;
          for (int i = 0; i < students.length; i++) {
               totalMarks += students[i];
          }
          return totalMarks;
     }

     // function for calculation of average marks of particular student

     public static double averageMarks(int[] students) {
          double averageMarks = totalMarks(students) / 3.0;
          return averageMarks;
     }

     // assign grades as per the average marks of particular student

     public static char assignGrades(int[] students) {

          double averageMarks = averageMarks(students);

          if (averageMarks > 90)
               return 'A';
          else if (averageMarks > 80 && averageMarks <= 90)
               return 'B';
          else if (averageMarks > 70 && averageMarks < 80)
               return 'C';

          return 'D';
     }

     // modified recursive function

     public static int recursiveFunctionForHeighestMarks(int[] students, int idx, int arrayLength) {
          if (idx == arrayLength)
               return 0;

          int subProblemAns = recursiveFunctionForHeighestMarks(students, idx + 1, arrayLength);

          return Math.max(subProblemAns, students[idx]);

     }

     // applied recursion for calculation of maximum marks among all students

     // public static int heighestMarks(int[] students) {
     //      return recursiveFunctionForHeighestMarks(students, 0, students.length);
     // }

     public static void modifyValue(int value) {
          value = value + 10;
     }

     public static void main(String[] args) {

          System.out.print("Enter number of students:");
          Scanner sc = new Scanner(System.in);
          int total_students = sc.nextInt();
          sc.nextLine();

          int heighestMarks = 0;

          for (int i = 0; i < total_students; i++) {
               int[] students = new int[3];
               System.out.print("Enter name of student " + (i + 1) + ":");
               String studentName = sc.nextLine();

               System.out.print("Enter marks in 3 subjects: ");

               for (int j = 0; j < 3; j++) {
                    students[j] = sc.nextInt();
               }

               sc.nextLine();
               heighestMarks = Math.max(heighestMarks, recursiveFunctionForHeighestMarks(students,0,students.length));

               int totalMarks = totalMarks(students);
               double averageMarks = averageMarks(students);
               char grade = assignGrades(students);

               System.out.println("Total Marks: " + totalMarks);
               System.out.println("Average Marks: " + averageMarks);
               System.out.println("Grade: " + grade);
          }

          System.out.println("Highest mark among all: " + heighestMarks);

          // demonstrating pass by value

          // int beforeModificationValue = 10;
          // System.out.println("value before modifcation: " + beforeModificationValue);
          // modifyValue(beforeModificationValue);
          // System.out.println("value after modification: " + beforeModificationValue);

     }
}
