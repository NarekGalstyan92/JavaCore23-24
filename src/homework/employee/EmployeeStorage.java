package homework.employee;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size;

    public void add(Employee employee) {
        if (size == employees.length) {
            extend();
        }
        employees[size++] = employee;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("Name: " + employees[i].getName() + ", Surname: " + employees[i].getSurname() +
                    ", ID: " + employees[i].getId() + ", Salary: " + employees[i].getSalary() + ",  Company: " +
                    employees[i].getCompany() + ", Position: " + employees[i].getPosition());
        }
    }

    public void searchById(String idKeyword) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().contains(idKeyword)) {
                System.out.println("Name: " + employees[i].getName() + ", Surname: " + employees[i].getSurname() +
                        ", ID: " + employees[i].getId() + ", Salary: " + employees[i].getSalary() + ",  Company: " +
                        employees[i].getCompany() + ", Position: " + employees[i].getPosition());
            }
        }
    }

    public void searchByCompany(String companyKeyword) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().contains(companyKeyword)) {
                System.out.println("Name: " + employees[i].getName() + ", Surname: " + employees[i].getSurname() +
                        ", ID: " + employees[i].getId() + ", Salary: " + employees[i].getSalary() + ",  Company: " +
                        employees[i].getCompany() + ", Position: " + employees[i].getPosition());
            }
        }
    }

    private void extend() {
        Employee[] tmp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, tmp, 0, employees.length);
        employees = tmp;
    }
}
