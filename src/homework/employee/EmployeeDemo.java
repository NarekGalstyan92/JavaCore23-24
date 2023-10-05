package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {

    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {

        // When you run the program, you will already have 4 employees in your database
        Employee employee1 = new Employee("Poxos", "Poxosyan", "1234A", 120000, "Service Titan", "Junior software developer");
        Employee employee2 = new Employee("Petros", "Petrosyan", "4321B", 180000, "Lexington brothers", "Middle software developer");
        Employee employee3 = new Employee("Martiros", "Martirosyan", "0001C", 220000, "ITSpace", "Senior software developer");
        Employee employee4 = new Employee("Narek", "Galstyan", "2020D", 1000, "Titan utilities", "Junior web developer");
        employeeStorage.add(employee1);
        employeeStorage.add(employee2);
        employeeStorage.add(employee3);
        employeeStorage.add(employee4);

        boolean isRun = true;

        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addEmployee();
                    break;
                case "2":
                    printAllEmployees();
                    break;
                case "3":
                    searchEmployeeById();
                    break;
                case "4":
                    searchEmployeeByCompany();
                    break;
                case "5":
                    searchEmployeeBySalary();
                    break;
                case "6":
                    changeEmployeeName();
                    break;
                case "7":
                    changeEmployeeSurname();
                    break;
                case "8":
                    changeEmployeeCompany();
                    break;
                case "9":
                    changeEmployeePosition();
                    break;
                case "10":
                    changeEmployeeSalary();
                    break;
                case "11":
                    deleteEmployee();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    private static void deleteEmployee() {
        System.out.println("Please enter employee ID to delete employee");
        String idForDelete = scanner.nextLine();
        employeeStorage.deleteEmployee(idForDelete);
    }

    private static void changeEmployeeSalary() {
        System.out.println("Please enter employee ID to change the salary");
        String salaryKeyword = scanner.nextLine();
        System.out.println("Please enter the new salary");
        double newSalary = Double.parseDouble(scanner.nextLine());
        employeeStorage.changeSalary(salaryKeyword, newSalary);
    }

    private static void changeEmployeePosition() {
        System.out.println("Please enter employee ID to change the position");
        String positionKeyword = scanner.nextLine();
        System.out.println("Please enter the new company");
        String newPosition = scanner.nextLine();
        employeeStorage.changePosition(positionKeyword, newPosition);
    }

    private static void changeEmployeeCompany() {
        System.out.println("Please enter employee ID to change the company");
        String companyKwrd = scanner.nextLine();
        System.out.println("Please enter the new company");
        String newCompany = scanner.nextLine();
        employeeStorage.changeCompany(companyKwrd, newCompany);
    }

    private static void changeEmployeeSurname() {
        System.out.println("Please enter employee ID to change the surname");
        String surnameKeyword = scanner.nextLine();
        System.out.println("Please enter the new surname");
        String changedSurname = scanner.nextLine();
        employeeStorage.changeSurname(surnameKeyword, changedSurname);
    }

    private static void changeEmployeeName() {
        System.out.println("Please enter employee ID to change the name");
        String nameKeyword = scanner.nextLine();
        System.out.println("Please enter the new name");
        String changedName = scanner.nextLine();
        employeeStorage.changeName(nameKeyword, changedName);
    }

    private static void searchEmployeeBySalary() {
        System.out.println("Please enter employee minimal salary");
        double minSalary = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter employee maximal salary");
        double maxSalary = Double.parseDouble(scanner.nextLine());
        employeeStorage.searchBySalary(minSalary, maxSalary);
    }

    private static void searchEmployeeByCompany() {
        System.out.println("Please input employee company");
        String companyKeyword = scanner.nextLine();
        employeeStorage.searchByCompany(companyKeyword);
    }

    private static void searchEmployeeById() {
        System.out.println("Please input employee ID");
        String idKeyword = scanner.nextLine();
        employeeStorage.searchById(idKeyword);
    }

    private static void printAllEmployees() {
        System.out.println("-------------");
        employeeStorage.print();
        System.out.println("-------------");
    }

    private static void addEmployee() {
        System.out.println("Please input employee name");
        String name = scanner.nextLine();
        System.out.println("Please input employee surname");
        String surname = scanner.nextLine();
        System.out.println("Please input employee id");
        String id = scanner.nextLine();
        System.out.println("Please input salary");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input employee company");
        String company = scanner.nextLine();
        System.out.println("Please input employee position");
        String position = scanner.nextLine();
        Employee employee = new Employee(name, surname, id, salary, company, position);
        employeeStorage.add(employee);
        System.out.println("The employee is created!");
    }

    public static void printCommands() {
        System.out.println("Please input 0 to EXIT");
        System.out.println("Please input 1 to ADD EMPLOYEE");
        System.out.println("Please input 2 to PRINT ALL EMPLOYEES");
        System.out.println("Please input 3 to SEARCH EMPLOYEE BY ID");
        System.out.println("Please input 4 to SEARCH EMPLOYEE BY COMPANY");
        System.out.println("Please input 5 to SEARCH EMPLOYEE BY SALARY");
        System.out.println("Please input 6 to CHANGE EMPLOYEE NAME");
        System.out.println("Please input 7 to CHANGE EMPLOYEE SURNAME");
        System.out.println("Please input 8 to CHANGE EMPLOYEE COMPANY");
        System.out.println("Please input 9 to CHANGE EMPLOYEE POSITION");
        System.out.println("Please input 10 to CHANGE EMPLOYEE SALARY");
        System.out.println("Please input 11 to DELETE EMPLOYEE");
    }
}
