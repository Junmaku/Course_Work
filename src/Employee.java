import java.util.Objects;

public class Employee {
    private static int count = 0;
    private String lastName;
    private String firstName;
    private String middleName;
    private double salary;
    private int department;
    private int id;

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Employee(String lastName, String firstName, int department, double salary) {
        setLastName(lastName);
        setFirstName(firstName);
        setSalary(salary);
        setDepartment(department);
        setId(++count);
    }

    public Employee(String lastName, String firstName, String middleName, int department, double salary) {
        setLastName(lastName);
        setFirstName(firstName);
        setSalary(salary);
        setDepartment(department);
        setId(++count);
        setMiddleName(middleName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getMiddleName(), getSalary(), getDepartment());
    }

    @Override
    public String toString() {
        String info = "\n";
        info += String.format("ФИО: %s %s %s\n", getLastName(), getFirstName(), getMiddleName() == null ? "" : getMiddleName());
        info += "Отдел: " + getDepartment();
        info += String.format("\nЗарплата сотрудника: %.2f\n", getSalary());
        return info;
    }

    public String getFullName() {
        return getLastName() + " " + getFirstName() + (getMiddleName() == null ? "" : " " + getMiddleName());
    }

    public void printName() {
        System.out.println(getFullName());
    }

    public String getEmployeeWithoutDepartment() {
        return String.format("id: %d\nФИО: %s %s %s\nЗарплата: %.2f\n", getId(), getLastName(), getFirstName(), getMiddleName() == null ? "" : getMiddleName(), getSalary());
    }

    public void printEmployeeWithOutDepartment() {
        System.out.println(getEmployeeWithoutDepartment());
    }


}
