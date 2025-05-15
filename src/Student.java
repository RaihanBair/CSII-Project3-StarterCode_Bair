import java.util.List;
import java.util.UUID;

public class Student implements CsvSerializable<Student> {
    private final String id;
    private int hwTime;
    private int numClasses;
    private boolean givenNotice; // You feel like you are given enough notice before assessments.
    private boolean support;
    private String extraC; // Do you engage in any extracurricular activities?(if so please list them)
    private Subject subject; // string question

    public Student(int hwTime, int numClasses, boolean givenNotice, boolean support, String extraC, Subject subject) {
        this.id = UUID.randomUUID().toString();
        this.hwTime = hwTime;
        this.numClasses = numClasses;
        this.givenNotice = givenNotice;
        this.support = support;
        this.extraC = extraC;
        this.subject = subject;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public int getHwTime() {
        return hwTime;
    }

    public void setHwTime(int hwTime) {
        this.hwTime = hwTime;
    }

    public int getNumClasses() {
        return numClasses;
    }

    public void setNumClasses(int numClasses) {
        this.numClasses = numClasses;
    }

    public boolean isGivenNotice() {
        return givenNotice;
    }

    public void setGivenNotice(boolean givenNotice) {
        this.givenNotice = givenNotice;
    }

    public boolean isSupport() {
        return support;
    }

    public void setSupport(boolean support) {
        this.support = support;
    }

    public String getExtraC() {
        return extraC;
    }

    public void setExtraC(String extraC) {
        this.extraC = extraC;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toLine() {
        // TODO
        return "";
    }

    public Student fromLine(String line) {
        // TODO
    }


    //    @Override
//    public String toString() {
//        return "Student{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", course='" + course + '\'' +
//                '}';
//    }
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