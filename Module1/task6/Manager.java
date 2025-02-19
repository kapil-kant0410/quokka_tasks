package task6;

// Manager class implementation
class Manager extends Employee {
    int teamSize;

    // Use of super keyword to refer to the immediate parent class
    Manager(int id, String name, String department, int salary, int teamSize) {
        super(id, name, department, salary);
        this.teamSize = teamSize;
    }

    // Function overriding (polymorphism)
    @Override
    public void displayDetails(String type) {
        super.displayDetails(type);
        System.out.println("Team Size: " + teamSize);
    }
}