import java.util.*;
class Person {
    String name;
    String id;
    int age;
    Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    void displayDetails() {
        System.out.println("Person: " + name + ", ID: " + id + ", Age: " + age);
    }
}
class Student extends Person {
    Student(String id, String name, int age) {
        super(id, name, age);
    }
    @Override
    void displayDetails() {
        System.out.println("Student: " + name + ", ID: " + id + ", Age: " + age);
    }
}
class EngineeringStudent extends Student {
    String branch;
    EngineeringStudent(String id, String name, int age, String branch) {
        super(id, name, age);
        this.branch = branch;
    }
    @Override
    void displayDetails() {
        System.out.println("Engineering Student: " + name + ", ID: " + id + ", Age: " + age + ", Branch: " + branch);
    }
}
class CSEStudent extends EngineeringStudent {
    String specialization;
    CSEStudent(String id, String name, int age, String specialization) {
        super(id, name, age, "CSE");
        this.specialization = specialization;
    }
    @Override
    void displayDetails() {
        System.out.println("CSE Student: " + name + ", ID: " + id + ", Age: " + age + ", Specialization: " + specialization);
    }
}
public class universitystudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equalsIgnoreCase("STUDENT")) {
                String id = sc.next();
                String name = sc.next();
                int age = sc.nextInt();
                people[i] = new Student(id, name, age);
            } else if (type.equalsIgnoreCase("ENGINEERING")) {
                String id = sc.next();
                String name = sc.next();
                int age = sc.nextInt();
                String branch = sc.next();
                people[i] = new EngineeringStudent(id, name, age, branch);
            } else if (type.equalsIgnoreCase("CSE")) {
                String id = sc.next();
                String name = sc.next();
                int age = sc.nextInt();
                String specialization = sc.next();
                people[i] = new CSEStudent(id, name, age, specialization);
            }
        }
        for (Person p : people) {
            if (p != null) {
                p.displayDetails();
            }
        }
    }
}
