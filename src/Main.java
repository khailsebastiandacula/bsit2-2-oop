public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");

        Manager manager = new Manager("Alice Smith", 2001, 80000, "Engineering", 15000, 8);
        System.out.println("\n--- Employee Details ---");
        manager.displayInfo();
        manager.work();
        System.out.println("Monthly Salary: $" + manager.calculateSalary());

        Developer developer = new Developer("Bob Johnson", 2002, 70000, "Engineering", "Java", 5);
        System.out.println("\n--- Employee Details ---");
        developer.displayInfo();
        developer.work();
        System.out.println("Monthly Salary: $" + developer.calculateSalary());

        Intern intern = new Intern("Charlie Brown", 2003, 30000, "Engineering", "Tech University", true);
        System.out.println("\n--- Employee Details ---");
        intern.displayInfo();
        intern.work();
        System.out.println("Monthly Salary: $" + intern.calculateSalary());
    }
}
