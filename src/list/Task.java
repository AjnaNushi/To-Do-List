package list;

import java.text.SimpleDateFormat;
import java.util.*;

class Task {
    private String description;
    private boolean completed;
    private int priority; // Priority of the task
    private Date dueDate; // Due date of the task

    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.priority = 0; // Default priority
        this.dueDate = null; // No due date initially
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dueDateString = (dueDate != null) ? dateFormat.format(dueDate) : "No due date";
        return description + (completed ? " (Completed)" : "") + " Priority: " + priority + ", Due Date: " + dueDateString;
    }
}
