import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;

import java.awt.Desktop;
import java.io.File;

public class Main {
    private static final String CSV_PATH = "students.csv";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student csvHelper = new Student(0, 0, false, false, "", Subject.MATH);

        // load
        try {
            students = csvHelper.readAll(CSV_PATH);
            System.out.println("Loaded " + students.size() + " students.");
        } catch (IOException e) {
            System.out.println("No existing data, starting fresh.");
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. List Students");
            System.out.println("4. Edit Student");
            System.out.println("5. Analyze Data");
            System.out.println("6. Open CSV");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            switch (scanner.nextLine()) {
                case "1":
                    students.add(inputStudent(scanner));
                    System.out.println("✔ Added.");
                    pause(scanner);
                    break;

                case "2":
                    list(students);
                    System.out.print("Index to remove: ");
                    int r = parseIndex(scanner, students.size());
                    if (r >= 0) {
                        students.remove(r);
                        System.out.println("✔ Removed.");
                    }
                    pause(scanner);
                    break;

                case "3":
                    list(students);
                    pause(scanner);
                    break;

                case "4":
                    list(students);
                    System.out.print("Index to edit: ");
                    int i = parseIndex(scanner, students.size());
                    if (i >= 0) {
                        System.out.println("Enter new values:");
                        students.set(i, inputStudent(scanner));
                        System.out.println("✔ Updated.");
                    }
                    pause(scanner);
                    break;

                case "5":
                    analyze(students);
                    pause(scanner);
                    break;

                case "6":
                    openCsv(CSV_PATH);
                    pause(scanner);
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid, try again.");
                    pause(scanner);
            }
        }

        // save
        try {
            csvHelper.writeAll(students, CSV_PATH);
            System.out.println("Saved " + students.size() + " students.");
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    private static Student inputStudent(Scanner scanner) {
        System.out.print("Homework time (int): ");
        int hw = Integer.parseInt(scanner.nextLine());
        System.out.print("Number of classes (int): ");
        int nc = Integer.parseInt(scanner.nextLine());
        System.out.print("Given notice (true/false): ");
        boolean gn = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Support (true/false): ");
        boolean sup = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Extracurriculars (String): ");
        String ec = scanner.nextLine();

        System.out.print("Subject (");
        for (Subject s : Subject.values()) System.out.print(s + " ");
        System.out.print("): ");
        Subject subj = Subject.valueOf(scanner.nextLine().trim().toUpperCase());

        return new Student(hw, nc, gn, sup, ec, subj);
    }

    private static int parseIndex(Scanner scanner, int size) {
        try {
            int idx = Integer.parseInt(scanner.nextLine());
            if (idx < 0 || idx >= size) {
                System.out.println("❌ Out of range.");
                return -1;
            }
            return idx;
        } catch (NumberFormatException e) {
            System.out.println("❌ Not a number.");
            return -1;
        }
    }

    private static void list(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("(no students)");
        }
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i+1) + ": " + students.get(i));
        }
    }

    private static void analyze(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No data to analyze.");
            return;
        }
        // stats for hwTime
        IntSummaryStatistics hwStats = students.stream()
                .mapToInt(Student::getHwTime)
                .summaryStatistics();
        // stats for numClasses
        IntSummaryStatistics clStats = students.stream()
                .mapToInt(Student::getNumClasses)
                .summaryStatistics();

        System.out.println("Homework Time →  min: " + hwStats.getMin()
                + ", max: " + hwStats.getMax()
                + ", avg: " + String.format("%.2f", hwStats.getAverage()));
        System.out.println("Num Classes   →  min: " + clStats.getMin()
                + ", max: " + clStats.getMax()
                + ", avg: " + String.format("%.2f", clStats.getAverage()));
    }

    private static void pause(Scanner scanner) {
        System.out.print("Press Enter to continue…");
        scanner.nextLine();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void openCsv(String path) {
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Opening files isn't supported on this platform.");
            return;
        }
        try {
            Desktop.getDesktop().open(new File(path));
            System.out.println("Launched CSV in default app.");
        } catch (IOException e) {
            System.out.println("Failed to open CSV: " + e.getMessage());
        }
    }
}
