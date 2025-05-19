import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String CSV_PATH = "students.csv";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        // using empty student to use interface messages
        Student csvHelper = new Student(0, 0, false, false, "", Subject.MATH);

        try {
            students = csvHelper.readAll(CSV_PATH);
            System.out.println("Loaded " + students.size() + " students.");
        } catch (IOException e) {
            System.out.println("Could not load students from CSV. Starting with an empty list.");
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. List Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Student newStudent = inputStudent(scanner);
                    students.add(newStudent);
                    System.out.println("Student added.");
                    break;
                case "2":
                    System.out.print("Enter student index to remove: ");
                    try {
                        int idx = Integer.parseInt(scanner.nextLine());
                        if (idx >= 0 && idx < students.size()) {
                            students.remove(idx);
                            System.out.println("Student removed.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input.");
                    }
                    break;
                case "3":
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + ": " + students.get(i));
                    }
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        // Save to CSV on exit
        try {
            csvHelper.writeAll(students, CSV_PATH);
            System.out.println("Saved students to CSV.");
        } catch (IOException e) {
            System.out.println("Failed to save students: " + e.getMessage());
        }
    }


    private static Student inputStudent(Scanner scanner) {
        System.out.print("Homework time: ");
        int hwTime = Integer.parseInt(scanner.nextLine());
        System.out.print("Number of classes: ");
        int numClasses = Integer.parseInt(scanner.nextLine());
        System.out.print("Given notice (true/false): ");
        boolean givenNotice = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Support (true/false): ");
        boolean support = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Extracurricular activities: ");
        String extraC = scanner.nextLine();
        System.out.print("Subject (");
        for (Subject s : Subject.values()) {
            System.out.print(s.name() + " ");
        }
        System.out.print("): ");
        Subject subject = Subject.valueOf(scanner.nextLine().toUpperCase());

        return new Student(hwTime, numClasses, givenNotice, support, extraC, subject);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}