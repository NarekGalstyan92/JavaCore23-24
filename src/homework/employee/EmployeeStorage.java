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
            System.out.println(employees[i].toString());
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

    public void searchBySalary(double minSalary, double maxSalary) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() <= maxSalary && employees[i].getSalary() >= minSalary) {
                System.out.println("Name: " + employees[i].getName() + ", Surname: " + employees[i].getSurname() +
                        ", ID: " + employees[i].getId() + ", Salary: " + employees[i].getSalary() + ",  Company: " +
                        employees[i].getCompany() + ", Position: " + employees[i].getPosition());
            }
        }
    }

    public void changeName(String nameKeyword, String changedName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equals(nameKeyword)) {
                employees[i].setName(changedName);
                System.out.println("Name was changed");
                break;
            }
        }
    }

    public void changeSurname(String surnameKeyword, String changedSurname) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equals(surnameKeyword)) {
                employees[i].setSurname(changedSurname);
                System.out.println("Surname was changed");
                break;
            }
        }
    }

    public void changeCompany(String companyKwrd, String newCompany) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equals(companyKwrd)) {
                employees[i].setCompany(newCompany);
                System.out.println("Company was changed");
                break;
            }
        }
    }

    public void changePosition(String positionKeyword, String newPosition) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equals(positionKeyword)) {
                employees[i].setPosition(newPosition);
                System.out.println("Position was changed");
                break;
            }
        }
    }

    public void changeSalary(String salaryKeyword, Double newSalary) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equals(salaryKeyword)) {
                employees[i].setSalary(newSalary);
                System.out.println("Salary was changed");
                break;
            }
        }
    }

    public void deleteEmployee(String idForDelete) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equals(idForDelete)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                size--;
                System.out.println("Employee was deleted!");
                System.out.println("The list of employees was updated");
                print();
            }
        }
    }

    private void extend() {
        Employee[] tmp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, tmp, 0, employees.length);
        employees = tmp;
    }
}
