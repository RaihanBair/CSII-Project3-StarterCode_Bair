import java.util.UUID;

public class Student {
    private final String id;
    private int hwTime;
    private boolean hasSixClasses;
    private boolean givenNotice; // You feel like you are given enough notice before assessments.
    private int support;
    private String extraC; // Do you engage in any extracurricular activities?(if so please list them)
    private Subject subject; // string question

    public Student(int hwTime, boolean numClasses, boolean givenNotice, int support, String extraC, Subject subject) {
        this.id = UUID.randomUUID().toString();
        this.hwTime = hwTime;
        this.hasSixClasses = numClasses;
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

    public boolean getNumClasses() {
        return hasSixClasses;
    }

    public void setNumClasses(boolean numClasses) {
        this.hasSixClasses = numClasses;
    }

    public boolean isGivenNotice() {
        return givenNotice;
    }

    public void setGivenNotice(boolean givenNotice) {
        this.givenNotice = givenNotice;
    }

    public int isSupport() {
        return support;
    }

    public void setSupport(int support) {
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