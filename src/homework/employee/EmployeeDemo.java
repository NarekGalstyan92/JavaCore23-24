package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeStorage employeeStorage = new EmployeeStorage();


        // When you run the program, you will already have 4 employees in your database
        Employee employee1 = new Employee("Poxos", "Poxosyan", "1234A", 120000, "Service Titan", "Junior software developer");
        Employee employee2 = new Employee("Petros", "Petrosyan", "4321B", 180000, "Lexington brothers", "Middle software developer");
        Employee employee3 = new Employee("Martiros", "Martirosyan", "0001C", 220000, "ITSpace", "Senior software developer");
        Employee employee4 = new Employee("Narek", "Galsyan", "2020D", 1000, "Titan utilities", "Junior web developer");
        employeeStorage.add(employee1);
        employeeStorage.add(employee2);
        employeeStorage.add(employee3);
        employeeStorage.add(employee4);

        boolean isRun = true;

        while (isRun) {

            System.out.println("Please input 0 to EXIT");
            System.out.println("Please input 1 to ADD EMPLOYEE");
            System.out.println("Please input 2 to PRINT ALL EMPLOYEES");
            System.out.println("Please input 3 to SEARCH EMPLOYEE BY ID");
            System.out.println("Please input 4 to SEARCH EMPLOYEE BY COMPANY");
            System.out.println("Please input 5 to SEARCH EMPLOYEE BY SALARY");
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
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
                    break;
                case "2":
                    System.out.println("-------------");
                    employeeStorage.print();
                    System.out.println("-------------");
                    break;
                case "3":
                    System.out.println("Please input employee ID");
                    String idKeyword = scanner.nextLine();
                    employeeStorage.searchById(idKeyword);
                    break;
                case "4":
                    System.out.println("Please input employee company");
                    String companyKeyword = scanner.nextLine();
                    employeeStorage.searchByCompany(companyKeyword);
                    break;
                case "5":
                    System.out.println("Please enter employee minimal salary");
                    double minSalary = Double.parseDouble(scanner.nextLine());
                    System.out.println("Please enter employee maximal salary");
                    double maxSalary = Double.parseDouble(scanner.nextLine());
                    employeeStorage.searchBySalary(minSalary, maxSalary);
                    break;
                default:
                    System.out.println("Wrong input");

            }
        }


    }
}
