package com.ql;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.*;

class TaskManager {
    private List<Task> taskList = new ArrayList<>();

    // Add Task
    public void addTask(String title, String description, LocalDate deadline, int priority) {
        taskList.add(new Task(title, description, deadline, priority));

        String filePath="C:\\Users\\Kapil Kant\\OneDrive\\Desktop\\quokka-tasks\\Module2\\task6\\taskManagement\\src\\main\\java\\com\\ql\\tasksInfo.csv";


         try{
             boolean fileExists=new File(filePath).exists();
             FileWriter fw=new FileWriter(filePath,true);
             BufferedWriter bw=new BufferedWriter(fw);
             PrintWriter pw=new PrintWriter(bw);

             if(!fileExists){
                 pw.println("id,title,description,deadline,priority,isCompleted");
             }

             pw.println(Task.idCounter-1+","+title+","+description+","+deadline+","+priority+","+false);
             pw.flush();
         }catch(Exception e){
               e.printStackTrace();
         }



        System.out.println("Task added successfully!");
    }

    // Mark Task as Completed
    public void markTaskCompleted(int taskId) {
        taskList.stream()
                .filter(task -> task.getId() == taskId)
                .findFirst()
                .ifPresentOrElse(task -> {
                    task.markAsCompleted();
                    System.out.println(" Task marked as completed!");
                }, () -> System.out.println("Task not found!"));
    }

    // Show All Tasks (Sorted by Priority)
    public void showAllTasks() {
        System.out.println("\n All Tasks (Sorted by Priority & Deadline):");
        taskList.stream()
                .sorted(Comparator.comparing((Task task)->task.getPriority()).reversed()
                        .thenComparing((Task task)->task.getDeadline()))
                .forEach(System.out::println);
    }

    // Show Overdue Tasks
    public void showOverdueTasks() {
        LocalDate today = LocalDate.now();
        System.out.println("\n Overdue Tasks:");
        taskList.stream()
                .filter(task -> task.getDeadline().isBefore(today) && !task.isCompleted())
                .forEach(System.out::println);
    }

    // Get Task Statistics
    public void getTaskAnalytics() {
        long completedTasks = taskList.stream().filter(Task::isCompleted).count();
        long pendingTasks = taskList.size() - completedTasks;

        System.out.println("\nTask Analytics:");
        System.out.println("Completed Tasks: " + completedTasks);
        System.out.println("Pending Tasks: " + pendingTasks);
    }
}