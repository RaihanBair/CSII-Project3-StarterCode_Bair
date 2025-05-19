import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: Create a Student List object that stores preloaded student objects
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(2,true,false, 7,"No", Subject.MATH));
        students.add(new Student(3,true,true, 8,"Soccer", Subject.ENGLISH));
        students.add(new Student(2,true,false, 7,"Sports", Subject.PHYSICS));
        students.add(new Student(4,true,true, 5,"Track", Subject.MATH));
        students.add(new Student(2,false,true, 8,"No", Subject.LANGUAGE));
        students.add(new Student(3,false,false, 8,"Basketball", Subject.ENGLISH));
        students.add(new Student(1,true,true, 8,"Music", Subject.ENGLISH));
        students.add(new Student(2,true,false, 7,"No", Subject.ENGLISH));
        students.add(new Student(3,false,true, 9,"No", Subject.ENGLISH));
        students.add(new Student(1,false,true, 8,"Debate", Subject.LANGUAGE));
        students.add(new Student(2,true,true, 7,"Piano", Subject.MATH));

        // Student objects should be each student with info you collected
        while (true) {
            System.out.println("1. Create Student");
            System.out.println("2. Read Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    createStudent(scanner);
                    break;
                case 2:
                    readStudents(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createStudent(Scanner scanner) {

        int hwTime = inputInt(scanner, "On average, how long does it take to complete homework on an average night?");
        int support = inputInt(scanner, "How supported do you feel by your teachers?");
        String extraC = input(scanner, "How supported do you feel by your teachers?");
        Subject subject = inputSubject(scanner, "How supported do you feel by your teachers?");
        boolean numClasses = inputBoolean(scanner, "You will take 6 academic classes next year. True or False?");
        boolean givenNotice = inputBoolean(scanner, "You feel like you are given enough notice before assessments. True or false?");
        // TODO: fill out the rest of this


        // TODO: create a student object with this information
        StudentList.createStudent(student);
        System.out.println("Student created successfully!");
    }

    private static void readStudents(Scanner scanner) {
        List<Student> students = StudentList.readStudents();
        // TODO: print out each student
    }

    private static void updateStudent(Scanner scanner) {
        // TODO: ask for new information to update student

        Student student = new Student(id, name, course);
        StudentList.updateStudent(student);
        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent(Scanner scanner) {
        // TODO: ask for student ID and store in a variable

        Student student = new Student(id, "", "");
        StudentList.deleteStudent(student);
        System.out.println("Student deleted successfully!");
    }

    private static String input(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    private static Subject inputSubject(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String subject = scanner.nextLine();
        return Subject.fromName(subject);
    }

    private static int inputInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
    private static boolean inputBoolean(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextBoolean();
    }
}