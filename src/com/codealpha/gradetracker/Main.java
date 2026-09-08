package com.codealpha.gradetracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console-based Student Grade Tracker.
 * Lets the user add students with marks, view individual records,
 * and view an overall summary report.
 */
public class Main {

    private static final List<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    viewSummaryReport();
                    break;
                case 4:
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-4.\n");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== Student Grade Tracker =====");
        System.out.println("1. Add a new student and their marks");
        System.out.println("2. View all students with their marks and stats");
        System.out.println("3. View summary report (per-student + class stats)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Reads the menu choice, returning -1 if the input isn't a valid integer.
     */
    private static int readMenuChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Adds a new student and prompts for marks until the user is done.
     */
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty. Cancelling.\n");
            return;
        }

        Student student = new Student(name);

        System.out.println("Enter marks one at a time (0-100).");
        System.out.println("Type 'done' when finished entering marks for " + name + ".");

        while (true) {
            System.out.print("Mark (or 'done'): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int mark = Integer.parseInt(input);
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid mark: must be between 0 and 100. Try again.");
                    continue;
                }
                student.addMark(mark);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: please enter a whole number or 'done'.");
            }
        }

        if (student.getMarks().isEmpty()) {
            System.out.println("No marks entered. Student not added.\n");
            return;
        }

        students.add(student);
        System.out.println("Student '" + name + "' added successfully.\n");
    }

    /**
     * Prints details and stats for every student.
     */
    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.\n");
            return;
        }

        System.out.println("----- All Students -----");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Student #" + (i + 1));
            System.out.println(students.get(i));
            System.out.println("-------------------------");
        }
        System.out.println();
    }

    /**
     * Prints a summary report: per-student stats plus overall class stats.
     */
    private static void viewSummaryReport() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.\n");
            return;
        }

        System.out.println("========== Summary Report ==========");

        double classMarkSum = 0.0;
        int classMarkCount = 0;
        int classHighest = Integer.MIN_VALUE;
        int classLowest = Integer.MAX_VALUE;

        for (Student s : students) {
            System.out.printf("%-20s Avg: %-6.2f Highest: %-4d Lowest: %-4d%n",
                    s.getName(), s.getAverage(), s.getHighest(), s.getLowest());

            for (int mark : s.getMarks()) {
                classMarkSum += mark;
                classMarkCount++;
                if (mark > classHighest) {
                    classHighest = mark;
                }
                if (mark < classLowest) {
                    classLowest = mark;
                }
            }
        }

        System.out.println("-------------------------------------");

        if (classMarkCount == 0) {
            System.out.println("No marks recorded across any student.");
        } else {
            double classAverage = classMarkSum / classMarkCount;
            System.out.printf("Class Average: %.2f%n", classAverage);
            System.out.println("Class Highest: " + classHighest);
            System.out.println("Class Lowest: " + classLowest);
        }

        System.out.println("=====================================\n");
    }
}
