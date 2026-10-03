import java.util.*;
abstract class Course {
    String courseCode;
    String courseName;
    int credits;
    Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }
    abstract double calculateFee();
    void displayCourseDetails(String courseType) {
        System.out.println(courseName + " (" + courseCode + ") - " + courseType + " - Fee: " + calculateFee());
    }
}
class RegularCourse extends Course {
    RegularCourse(String courseCode, String courseName, int credits) {
        super(courseCode, courseName, credits);
    }
    @Override
    double calculateFee() {
        return credits * 5000.0;
    }
}
class OnlineCourse extends Course {
    OnlineCourse(String courseCode, String courseName, int credits) {
        super(courseCode, courseName, credits);
    }
    @Override
    double calculateFee() {
        return credits * 3000.0;
    }
}
class CertificationCourse extends Course {
    CertificationCourse(String courseCode, String courseName, int credits) {
        super(courseCode, courseName, credits);
    }
    @Override
    double calculateFee() {
        return (credits * 2000.0) + 1000.0;
    }
}

public class universitycourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Course[] courses = new Course[n];
        String[] types = new String[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String code = sc.next();
            String name = sc.next();
            int credits = sc.nextInt();
            if (type.equalsIgnoreCase("REGULAR")) {
                courses[i] = new RegularCourse(code, name, credits);
                types[i] = "RegularCourse";
            } else if (type.equalsIgnoreCase("ONLINE")) {
                courses[i] = new OnlineCourse(code, name, credits);
                types[i] = "OnlineCourse";
            } else if (type.equalsIgnoreCase("CERTIFICATION")) {
                courses[i] = new CertificationCourse(code, name, credits);
                types[i] = "CertificationCourse";
            }
        }
        for (int i = 0; i < n; i++) {
            if (courses[i] != null) {
                courses[i].displayCourseDetails(types[i]);
            }
        }
    }
}