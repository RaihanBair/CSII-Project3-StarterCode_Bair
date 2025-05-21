import java.util.ArrayList;
import java.util.List;
// UNUSED, WE JUST USED List<Student>
public class StudentList {
    private static List<Student> students = new ArrayList<>();

    public static void createStudent(Student student) {
        students.add(student);
    }

    public static List<Student> readStudents() {
        return students;
    }

//    public static void updateStudent(Student student) {
//        for (Student s : students) {
//            if (s.getId().equals(student.getId())) {
//                s.setName(student.getName());
//                s.setCourse(student.getCourse());
//                break;
//            }
//        }
//    }

    public static void deleteStudent(Student student) {
        students.removeIf(s -> s.getId().equals(student.getId()));
    }
}