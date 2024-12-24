import java.util.Objects;

public class Employee {
    private static int count = 0;
    private String lastName;
    private String firstName;
    private String middleName;
    private double salary;
    private int department;
    private int id;
    private int place;

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
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
        this.id = ++count;
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
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.department = department;
        this.id = ++Employee.count;
        this.middleName = null;
    }

    public Employee(String lastName, String firstName, String middleName, int department, double salary) {
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.salary = salary;
        this.id = ++Employee.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getAClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(middleName, employee.middleName);
    }

    private Class<? extends Employee> getAClass() {
        return getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, salary, department);
    }

    @Override
    public String toString() {
        String info = "\n";
        info += String.format("ФИО: %s %s %s\n", lastName, firstName, middleName == null ? "" : middleName);
        info += "Отдел: " + department;
        info += String.format("\nЗарплата сотрудника: %.2f\n", salary);
        return info;
    }

    public String getFullName() {
        return lastName + " " + firstName + (middleName == null ? "" : " " + middleName);
    }

    public void printName() {
        System.out.printf("%s %s %s\n", lastName, firstName, middleName == null ? "" : middleName);
    }

    public void printEmployeeWithOutDepartment() {
        System.out.printf("id: %d\nФИО: %s %s %s\nЗарплата: %.2f\n", id, lastName, firstName, middleName == null ? "" : middleName, salary);
    }


}
