package homework.employeemanagemenet;

import homework.employeemanagemenet.model.Company;
import homework.employeemanagemenet.model.Employee;
import homework.employeemanagemenet.storage.CompanyStorage;
import homework.employeemanagemenet.storage.EmployeeStorage;
import homework.employeemanagemenet.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManagementMain implements Command {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();
    private static CompanyStorage companyStorage = new CompanyStorage();


    public static void main(String[] args) throws ParseException {

        Date dateOfB = DateUtil.stringToDate("20-10-1990");
        Date registerDate = new Date();
        Company company1 = new Company("C001", "Hemmersbach", "Van Nuys");
        Company company2 = new Company("C002", "ITBrothers", "Glendale");
        Company company3 = new Company("C003", "ITSpace", "Gyumri");
        Employee employee1 = new Employee("E001", "Narek", "Galstyan", "123456", 123, "Manager", company1, dateOfB, registerDate);
        Employee employee2 = new Employee("E002", "Poxos", "Poxosyan", "654321", 321, "Tech support", company2, dateOfB, registerDate);
        Employee employee3 = new Employee("E003", "Petros", "Petrosyan", "136245", 1200, "Call Center", company3, dateOfB, registerDate);
        companyStorage.add(company1);
        companyStorage.add(company2);
        companyStorage.add(company3);
        employeeStorage.add(employee1);
        employeeStorage.add(employee2);
        employeeStorage.add(employee3);
        boolean isRun = true;

        while (isRun) {
            Command.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_COMPANY:
                    addCompany();
                    break;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case PRINT_ALL_COMPANIES:
                    companyStorage.print();
                    break;
                case PRINT_ALL_EMPLOYEES:
                    employeeStorage.print();
                    break;
                case SEARCH_EMPLOYEE_BY_ID:
                    searchEmployeeById();
                    break;
                case SEARCH_EMPLOYEE_BY_COMPANY:
                    searchEmployeeByCompany();
                    break;
                case DELETE_COMPANY:
                    deleteCompany();
                    break;
                case DELETE_EMPLOYEE:
                    deleteEmployee();
                    break;
                case CHANGE_COMPANY:
                    changeCompany();
                    break;
                case CHANGE_EMPLOYEE:
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

    private static void addEmployee() throws ParseException {
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
        System.out.println("Please input employee date of birthday (dd-MM-yyyy)");
        String dateOfBirthdayStr = scanner.nextLine();
        Date dateOfB = DateUtil.stringToDate(dateOfBirthdayStr);
        Date registerDate = new Date();
        Employee employee = new Employee(employeeId, employeeName, employeeSurname, employeePhone, employeeSalary, employeePosition, companyFromStorage, dateOfB, registerDate);
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


}
