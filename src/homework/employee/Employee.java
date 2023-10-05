package homework.employee;

public class Employee {

    private String name;
    private String surname;
    private String id;
    private double salary;
    private String company;
    private String position;

    public Employee(String name, String surname, String id, double salary, String company, String position) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.salary = salary;
        this.company = company;
        this.position = position;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return  "Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", Id='" + id + '\'' +
                ", Salary=" + salary +
                ", Company='" + company + '\'' +
                ", Position='" + position + '\'';
    }
}
