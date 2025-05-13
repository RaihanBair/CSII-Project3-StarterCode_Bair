import java.util.UUID;

public class Student {
    private final String id;
    private int hours;
    private int classes;
    private boolean support;
    private boolean notice;
    private String extraC;
    private String subject;

    public Student(String name, String course) {
        this.id = UUID.randomUUID().toString();;
        this.hours = hours;
        this.classes = classes;
        this.support = support;
        this.notice = notice;
        this.extraC = extraC;
        this.subject = subject;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}

//public record Student(String id, int hours, int classes, boolean support, boolean notice, String extraC, String subject){
//    @Override
//    public String toString() { // TODO: EDIT TOSTRING
//        return "Student{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", course='" + course + '\'' +
//                '}';
//    }
//}