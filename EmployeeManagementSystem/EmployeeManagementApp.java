package EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private String position;
    private double salary;

    public Employee(String name, int id, String position, double salary) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementApp {
    private List<Employee> employeeList;

    public EmployeeManagementApp() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void viewEmployeeInformation() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void searchEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println("Employee found: " + employee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void deleteEmployee(int id) {
        Employee foundEmployee = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                foundEmployee = employee;
                break;
            }
        }

        if (foundEmployee != null) {
            employeeList.remove(foundEmployee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementApp app = new EmployeeManagementApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Information");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter employee position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    Employee newEmployee = new Employee(name, id, position, salary);
                    app.addEmployee(newEmployee);
                    break;

                case 2:
                    app.viewEmployeeInformation();
                    break;

                case 3:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    app.searchEmployee(searchId);
                    break;

                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    app.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting the Employee Management System.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
