package com.ql;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n===== TaskFlow - Smart Task Manager =====");
            System.out.println("1 Add Task");
            System.out.println("2 Show All Tasks");
            System.out.println("3 Show Overdue Tasks");
            System.out.println("4 Mark Task as Completed");
            System.out.println("5 Task Analytics");
            System.out.println("6 Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print(" Enter Task Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Task Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter Deadline (YYYY-MM-DD): ");
                    LocalDate deadline = LocalDate.parse(sc.nextLine());
                    System.out.print("Enter Priority (High(10)/Medium(5)/Low(1): ");
                    int priority = sc.nextInt();
                    manager.addTask(title, desc, deadline, priority);
                    break;

                case 2:
                    manager.showAllTasks();
                    break;

                case 3:
                    manager.showOverdueTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to Mark as Completed: ");
                    int taskId = sc.nextInt();
                    manager.markTaskCompleted(taskId);
                    break;

                case 5:
                    manager.getTaskAnalytics();
                    break;

                case 6:
                    System.out.println(" Exiting TaskFlow. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid Choice! Try Again.");
            }
        }
    }
}

