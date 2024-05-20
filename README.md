# To Do List Application
This project is a console-based Todo List application that allows users to manage their tasks efficiently. Users can add tasks, set priorities and due dates, mark tasks as completed, and view both pending and completed tasks.
## Project Structure
The project is organized into two main classes:
1. ### Task Class:
- *Location:* Task.java
- *Description:* Represents an individual task.
#### Methods:
- Task(String description): Constructor to create a new task with a description.
- String getDescription(): Returns the task description.
- boolean isCompleted(): Returns the completion status of the task.
- void markAsCompleted(): Marks the task as completed.
- int getPriority(): Returns the task priority.
- void setPriority(int priority): Sets the task priority.
- Date getDueDate(): Returns the task due date.
- void setDueDate(Date dueDate): Sets the task due date.
- String toString(): Returns a string representation of the task, including its description, completion status, priority, and due date.

2. ### TodoList Class
- *Location:* TodoList.java
- *Description:* Manages a list of tasks, including adding new tasks, marking tasks as completed, and viewing tasks.

#### Methods:
- TodoList(): Constructor to initialize the task list, completed tasks list, task map, and priority queue.
- void addTask(String description, int priority, Date dueDate): Adds a new task to the list with the specified description, priority, and due date.
- void markTaskAsCompleted(int index): Marks a task as completed based on its index in the list.
- void viewTasks(): Displays the list of pending tasks.
- void viewCompletedTasks(): Displays the list of completed tasks.

## Usage
*Add Task:*
- Prompts the user to enter a task description, priority (1-5), and due date (in YYYY-MM-DD HH:mm format).
- Adds the task to the list with validation checks for priority and due date.

*Mark Task as Completed:*
- Prompts the user to enter the index of the task to mark as completed.
- Removes the task from the pending tasks list and adds it to the completed tasks list.

*View Tasks:*
- Displays all pending tasks, sorted by priority.

*View Completed Tasks:*
- Displays all completed tasks.

*Exit:*
- Exits the application.

## Main Method
The main method in the TodoList class provides a menu-driven interface for user interaction. It continuously prompts the user for input and performs the corresponding actions.
