package task6;

import java.util.*;

//Employee class implementaion

class Employee {
    int id;
    String name;
    String department;
    private int salary;

    // use of this keyword to refer the same class

    Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // display employee details

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("ID:" + " " + id);
        System.out.println("Name:" + " " + name);
        System.out.println("Department:" + " " + department);
        System.out.println("Salary:" + "$" + salary);
    }

    // display manager details

    public void managerDisplayDetails() {
        System.out.println("Manager Details:");
        System.out.println("ID:" + " " + id);
        System.out.println("Name:" + " " + name);
        System.out.println("Department:" + " " + department);
        System.out.println("Salary:" + "$" + salary);
    }

    // display hr details

    public void hrDisplayDetails() {
        System.out.println("Hr Details:");
        System.out.println("ID:" + " " + id);
        System.out.println("Name:" + " " + name);
        System.out.println("Department:" + " " + department);
        System.out.println("Salary:" + "$" + salary);
    }

}

// manager class implementation

class Manager extends Employee {

    int teamSize;

    // use of super keyword to refer the immediate next parent

    Manager(int id, String name, String department, int salary, int teamSize) {
        super(id, name, department, salary);
        this.teamSize = teamSize;
    }

    // function overriding (polymorphism)

    public void displayDetails() {
        super.managerDisplayDetails();
        System.out.println("Team Size:" + " " + teamSize);
    }

}

// hr class implementaion

class Hr extends Employee {

    int recruitmentsHandled;

    // use of super keyword to refer the immediate next parent

    Hr(int id, String name, String department, int salary, int recruitmentsHandled) {
        super(id, name, department, salary);
        this.recruitmentsHandled = recruitmentsHandled;
    }

    // function overriding (polymorphism)

    public void displayDetails() {
        super.hrDisplayDetails();
        System.out.println("Recruitments Handled:" + " " + recruitmentsHandled);
    }

}

public class EmployeeManagementSystemCLI {

    public static void printEmployeeDetails(Employee e) {
        e.displayDetails();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter class type: employee or manager or hr: ");
        String selectClassType = sc.nextLine();

        switch (selectClassType) {
            
            case "employee": {
                System.out.print("Enter a valid employee id: ");
                int id = sc.nextInt();
                sc.nextLine();
                if (id < 0) {
                    System.out.println("enter valid positive id");
                    return;
                }
                System.out.print("Enter a valid employee name: ");
                String name = sc.nextLine();
                System.out.print("Enter a valid employee department: ");
                String department = sc.nextLine();
                System.out.print("Enter a valid employee salary: ");
                int salary = sc.nextInt();
                sc.nextLine();
                if (salary < 0) {
                    System.out.println("enter valid positive salary");
                    return;
                }
                Employee e1 = new Employee(id, name, department, salary);
                e1.displayDetails();
                printEmployeeDetails(e1);
                break;
            }
            case "manager": {
                System.out.print("Enter a valid manager id: ");
                int id = sc.nextInt();
                sc.nextLine();
                if (id < 0) {
                    System.out.println("enter valid positive id");
                    return;
                }
                System.out.print("Enter a valid manager name: ");
                String name = sc.nextLine();
                System.out.print("Enter a valid manager department: ");
                String department = sc.nextLine();
                System.out.print("Enter a valid manager salary: ");
                int salary = sc.nextInt();
                sc.nextLine();
                if (salary < 0) {
                    System.out.println("enter valid positive salary");
                    return;
                }
                System.out.print("Enter a valid manager teamSize: ");
                int teamSize = sc.nextInt();
                sc.nextLine();
                if (teamSize < 0) {
                    System.out.println("enter valid positive teamSize");
                    return;
                }
                Manager m1 = new Manager(id, name, department, salary, teamSize);
                m1.displayDetails();
                break;
            }
            case "hr": {
                System.out.print("Enter a valid hr id: ");
                int id = sc.nextInt();
                sc.nextLine();
                if (id < 0) {
                    System.out.println("enter valid positive id");
                    return;
                }
                System.out.print("Enter a valid hr name: ");
                String name = sc.nextLine();
                System.out.print("Enter a valid hr department: ");
                String department = sc.nextLine();
                System.out.print("Enter a valid hr salary: ");
                int salary = sc.nextInt();
                sc.nextLine();
                if (salary < 0) {
                    System.out.println("enter valid positive salary");
                    return;
                }
                System.out.print("Enter a valid hr recruitmentsHandled: ");
                int recruitmentsHandled = sc.nextInt();
                sc.nextLine();
                if (recruitmentsHandled < 0) {
                    System.out.println("enter valid positive recruitmentsHandled");
                    return;
                }
                Hr h1 = new Hr(id, name, department, salary, recruitmentsHandled);
                h1.displayDetails();
                break;
            }
            default: {
                System.out.println("enter valid department name hr, manager or employee");
            }
                sc.close();
        }

    }
}
