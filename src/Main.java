import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "tasks.dat";
    private static final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        loadTasks();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=================================");
        System.out.println("      STUDENT TASK MANAGER");
        System.out.println("=================================");

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addTask(scanner);
                case "2" -> viewTasks();
                case "3" -> completeTask(scanner);
                case "4" -> deleteTask(scanner);
                case "5" -> {
                    saveTasks();
                    System.out.println("Tasks saved. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Task title cannot be empty.");
            return;
        }

        tasks.add(new Task(title));
        saveTasks();
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks found.");
            return;
        }

        System.out.println("\n---------- YOUR TASKS ----------");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void completeTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to complete.");
            return;
        }

        viewTasks();
        System.out.print("Enter task number to mark as completed: ");

        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 1 || number > tasks.size()) {
                System.out.println("Invalid task number.");
                return;
            }

            tasks.get(number - 1).setCompleted(true);
            saveTasks();
            System.out.println("Task marked as completed.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void deleteTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to delete.");
            return;
        }

        viewTasks();
        System.out.print("Enter task number to delete: ");

        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 1 || number > tasks.size()) {
                System.out.println("Invalid task number.");
                return;
            }

            Task removed = tasks.remove(number - 1);
            saveTasks();
            System.out.println("Deleted: " + removed.getTitle());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void saveTasks() {
        try (ObjectOutputStream output =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            output.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Could not save tasks: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadTasks() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(new FileInputStream(file))) {
            tasks.clear();
            tasks.addAll((List<Task>) input.readObject());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load saved tasks.");
        }
    }
}
