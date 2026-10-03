import java.util.*;

class Employee {
    String name;
    String employeeId;
    double baseSalary;
    Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }
    double calculateSalary() {
        return baseSalary;
    }
    double calculateSalary(double bonus) {
        return baseSalary + bonus;
    }
}

class Manager extends Employee {
    Manager(String name, String id, double salary) {
        super(name, id, salary);
    }
    @Override
    double calculateSalary() {
        return baseSalary + (0.20 * baseSalary);
    }
}
class Developer extends Employee {
    Developer(String name, String id, double salary) {
        super(name, id, salary);
    }
    @Override
    double calculateSalary() {
        return baseSalary + (0.15 * baseSalary);
    }
}
class Intern extends Employee {
    Intern(String name, String id, double salary) {
        super(name, id, salary);
    }
    @Override
    double calculateSalary() {
        return baseSalary + 5000;
    }
}
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Employee[] employees = new Employee[n];
        String[] roles = new String[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            if (type.equalsIgnoreCase("MANAGER")) {
                employees[i] = new Manager(name, id, salary);
                roles[i] = "Manager";
            } else if (type.equalsIgnoreCase("DEVELOPER")) {
                employees[i] = new Developer(name, id, salary);
                roles[i] = "Developer";
            } else if (type.equalsIgnoreCase("INTERN")) {
                employees[i] = new Intern(name, id, salary);
                roles[i] = "Intern";
            }
        }
        for (int i = 0; i < n; i++) {
            Employee emp = employees[i];
            if (emp != null) {
                System.out.println(emp.name + " - " + roles[i] + " - " + emp.calculateSalary());
            }
        }
    }
}
