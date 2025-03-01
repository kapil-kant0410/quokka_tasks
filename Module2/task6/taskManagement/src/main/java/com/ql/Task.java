package com.ql;

import java.time.LocalDate;

class Task {
    public static int idCounter = 1;
    private int id;
    private String title;
    private String description;
    private LocalDate deadline;
    private int priority; // High, Medium, Low
    private boolean isCompleted;

    public Task(String title, String description, LocalDate deadline, int priority) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.isCompleted = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDeadline() { return deadline; }
    public int getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }

    public void markAsCompleted() { this.isCompleted = true; }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Title: " + title + ", Deadline: " + deadline +
                ", Priority: " + priority + ", Completed: " + isCompleted;
    }
}