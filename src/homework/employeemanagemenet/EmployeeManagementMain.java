package homework.employeemanagemenet;

import homework.employeemanagemenet.model.Company;
import homework.employeemanagemenet.model.Employee;
import homework.employeemanagemenet.storage.CompanyStorage;
import homework.employeemanagemenet.storage.EmployeeStorage;

import java.util.Scanner;

public class EmployeeManagementMain {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();
    private static CompanyStorage companyStorage = new CompanyStorage();


    public static void main(String[] args) {


        Company company1 = new Company("C001", "Hemmersbach", "Van Nuys");
        Company company2 = new Company("C002", "ITBrothers", "Glendale");
        Company company3 = new Company("C003", "ITSpace", "Gyumri");
        Employee employee1 = new Employee("E001", "Narek", "Galstyan", "123456", 123, "Manager", company1);
        Employee employee2 = new Employee("E002", "Poxos", "Poxosyan", "654321", 321, "Tech support", company2);
        Employee employee3 = new Employee("E003", "Petros", "Petrosyan", "136245", 1200, "Call Center", company3);
        companyStorage.add(company1);
        companyStorage.add(company2);
        companyStorage.add(company3);
        employeeStorage.add(employee1);
        employeeStorage.add(employee2);
        employeeStorage.add(employee3);
        boolean isRun = true;

        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addCompany();
                    break;
                case "2":
                    addEmployee();
                    break;
                case "3":
                    companyStorage.print();
                    break;
                case "4":
                    employeeStorage.print();
                    break;
                case "5":
                    searchEmployeeById();
                    break;
                case "6":
                    searchEmployeeByCompany();
                    break;
                case "7":
                    deleteCompany();
                    break;
                case "8":
                    deleteEmployee();
                    break;
                case "9":
                    changeCompany();
                    break;
                case "10":
                    changeEmployee();
                    break;
                default:
                    System.out.println("Invalid command. Try again!");
            }
        }

    }


    private static void changeEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("company with " + companyId + " does not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);
        System.out.println("please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if (employeeFromStorage == null) {
            System.out.println("employee with " + employeeId + " id does not exists!");
            return;
        }
        System.out.println("please input employee name");
        String employeeName = scanner.nextLine();
        System.out.println("please input employee surname");
        String employeeSurname = scanner.nextLine();
        System.out.println("please input employee phone");
        String employeePhone = scanner.nextLine();
        System.out.println("please input employee position");
        String employeePosition = scanner.nextLine();
        System.out.println("please input employee salary AMD");
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        employeeFromStorage.setName(employeeName);
        employeeFromStorage.setSurname(employeeSurname);
        employeeFromStorage.setPosition(employeePosition);
        employeeFromStorage.setSalary(employeeSalary);
        employeeFromStorage.setPhone(employeePhone);
        System.out.println("Employee updated!");
    }

    private static void changeCompany() {
        System.out.println("please input company id");
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + " does not exists!!!");
            return;
        }
        System.out.println("please input new company name");
        String companyName = scanner.nextLine();
        System.out.println("please input new company address");
        String companyAddress = scanner.nextLine();
        companyFromStorage.setName(companyName);
        companyFromStorage.setAddress(companyAddress);
        System.out.println("company updated");
    }

    private static void deleteEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("company with " + companyId + " does not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);

        System.out.println("please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if (employeeFromStorage == null) {
            System.out.println("employee does not exists!");
            return;
        }
        if (!employeeFromStorage.getCompany().equals(companyFromStorage)) {
            System.out.println("Wrong employee id.");
            return;
        }
        employeeStorage.deleteById(employeeId);
    }

    private static void deleteCompany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("company with " + companyId + " does not exists!!!");
            return;
        }
        companyStorage.deleteById(companyId);
    }

    private static void searchEmployeeByCompany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("company with " + companyId + " does not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);
    }

    private static void searchEmployeeById() {
        System.out.println("please input employee id");
        String employeeId = scanner.nextLine();
        Employee byId = employeeStorage.getById(employeeId);
        if (byId == null) {
            System.out.println("employee does not exists");
        } else {
            System.out.println(byId);
        }
    }

    private static void addEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("company with " + companyId + " does not exists!!!");
            return;
        }
        System.out.println("please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if (employeeFromStorage != null) {
            System.out.println("employee with " + employeeId + " id already exists!");
            return;
        }
        System.out.println("please input employee name");
        String employeeName = scanner.nextLine();
        System.out.println("please input employee surname");
        String employeeSurname = scanner.nextLine();
        System.out.println("please input employee phone");
        String employeePhone = scanner.nextLine();
        System.out.println("please input employee position");
        String employeePosition = scanner.nextLine();
        System.out.println("please input employee salary AMD");
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        Employee employee = new Employee(employeeId, employeeName, employeeSurname, employeePhone, employeeSalary, employeePosition, companyFromStorage);
        employeeStorage.add(employee);
        System.out.println("Employee registered!");
    }

    private static void addCompany() {
        System.out.println("please input company id");
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage != null) {
            System.out.println("Company with " + companyId + " already exists!!!");
            return;
        }
        System.out.println("please input company name");
        String companyName = scanner.nextLine();
        System.out.println("please input company address");
        String companyAddress = scanner.nextLine();
        Company company = new Company(companyId, companyName, companyAddress);
        companyStorage.add(company);
        System.out.println("company registered.");
    }

    private static void printCommands() {
        System.out.println("Please input 0 for EXIT");
        System.out.println("Please input 1 for ADD_COMPANY");
        System.out.println("Please input 2 for ADD_EMPLOYEE");
        System.out.println("Please input 3 for PRINT_ALL_COMPANIES");
        System.out.println("Please input 4 for PRINT_ALL_EMPLOYEES");
        System.out.println("Please input 5 for SEARCH_EMPLOYEE_BY_ID");
        System.out.println("Please input 6 for SEARCH_EMPLOYEE_BY_COMPANY");
        System.out.println("Please input 7 for DELETE_COMPANY");
        System.out.println("Please input 8 for DELETE_EMPLOYEE");
        System.out.println("Please input 9 for CHANGE_COMPANY");
        System.out.println("Please input 10 for CHANGE_EMPLOYEE");
    }
}
