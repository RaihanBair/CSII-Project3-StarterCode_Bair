public class Student {
    private String id;
    private String name;
    private String course; // add question variables
    private int hours;
    private int classes;
    private boolean support;
    private boolean notice;
    private String extraC;
    private String subject;

    public Student(String id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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