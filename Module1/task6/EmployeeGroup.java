package task6;

public class EmployeeGroup {
    public static Employee createEmployee(String type) {
        int id = InputHandler.getInt("Enter ID: ");
        String name = InputHandler.getString("Enter Name: ");
        String department = InputHandler.getString("Enter Department: ");
        int salary = InputHandler.getInt("Enter Salary: ");

        switch (type) {
            case "Employee":
                return new Employee(id, name, department, salary);
            case "Manager":
                int teamSize = InputHandler.getInt("Enter Team Size: ");
                return new Manager(id, name, department, salary, teamSize);
            case "HumanResource":
                int recruitmentsHandled = InputHandler.getInt("Enter Recruitments Handled: ");
                return new HumanResource(id, name, department, salary, recruitmentsHandled);
            default:
                System.out.println("Invalid Type!");
                return null;
        }
    }
}
