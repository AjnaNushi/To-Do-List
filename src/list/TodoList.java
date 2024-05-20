package list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TodoList {
    private LinkedList<Task> tasks;
    private ArrayList<Task> completedTasks;
    private HashMap<Integer, Task> taskMap; // Task map for efficient lookup
    private PriorityQueue<Task> taskQueue; // Priority queue for priority-based management

    public TodoList() {
        tasks = new LinkedList<>();
        completedTasks = new ArrayList<>();
        taskMap = new HashMap<>();
        taskQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getPriority(), t1.getPriority())); // Priority queue sorted by descending priority
    }

    // Method to add tasks to the task list
    public void addTask(String description, int priority, Date dueDate) {
        Task newTask = new Task(description);

        // Validate priority level
        if (priority >= 1 && priority <= 5) {
            newTask.setPriority(priority);
        } else {
            System.out.println("Invalid priority level. Please enter a number between 1 and 5.");
            return;
        }

        newTask.setDueDate(dueDate);
        tasks.add(newTask); // Add the task to the LinkedList
        taskMap.put(tasks.size(), newTask); // Add the task to the HashMap
        taskQueue.add(newTask); // Add the task to the PriorityQueue

        // Sort the tasks by priority after adding the new task
        tasks.sort((t1, t2) -> Integer.compare(t2.getPriority(), t1.getPriority()));
    }

    // Method to mark a task as completed
    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
            completedTasks.add(task); // Add to the list of completed tasks
            tasks.remove(index); // Remove from the list of tasks
            taskMap.remove(tasks.size() + 1); // Remove from the map
            taskQueue.remove(task); // Remove from the priority queue
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Method to view tasks in the list
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
        } else {
            // Sort tasks by priority before displaying
            tasks.sort((t1, t2) -> Integer.compare(t2.getPriority(), t1.getPriority()));
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Method to view the tasks that are completed
    public void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            System.out.println("Completed Tasks:");
            for (Task task : completedTasks) {
                System.out.println("- " + task.getDescription());
            }
        }
    }

    // Main method to run the to do list application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View Tasks");
            System.out.println("4. View Completed Tasks");
            System.out.println("5. Exit");

            // Validate choice input
            int choice = 0;
            boolean validChoice = false;
            while (!validChoice) {
                System.out.print("Enter your choice (1-5): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 5) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    scanner.next(); // Clear the invalid input
                }
            }

            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task priority (1 - 5): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    // Add due date input with validation
                    Date dueDate = null;
                    boolean validDate = false;
                    while (!validDate) {
                        System.out.print("Enter due date and time (YYYY-MM-DD HH:mm): ");
                        String dueDateString = scanner.nextLine();
                        try {
                            dueDate = dateFormat.parse(dueDateString);
                            Date currentDate = new Date();
                            if (dueDate.before(currentDate)) {
                                System.out.println("The due date and time cannot be earlier than the current date and time. Please enter a valid date and time.");
                            } else {
                                validDate = true;
                            }
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter the date and time in the format YYYY-MM-DD HH:mm.");
                        }
                    }
                    todoList.addTask(description, priority, dueDate);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter task index to mark as completed: ");
                    int index = scanner.nextInt();
                    todoList.markTaskAsCompleted(index - 1);
                    break;
                case 3:
                    todoList.viewTasks();
                    break;
                case 4:
                    todoList.viewCompletedTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
