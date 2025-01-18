public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    /**
     * Возвращает количество сотрудников.
     * @return Размер массива с сотрудниками.
     */
    public int getSize() {
        return size;
    }

    /**
     * Конструктор книги сотрудников
     *
     * @param capacity максимальное количество сотрудников
     */
    public EmployeeBook(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    /**
     * Узнать, есть ли места в книге
     *
     * @return true, если есть места в книге, иначе false
     */
    public boolean isHavePlace() {
        for (Employee employee : employees) {
            if (employee == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isHaveEmployee(int id) {
        for (Employee e : employees) {
            if (e != null && e.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Добавить сотрудника в книгу
     *
     * @param employee сотрудник object
     */
    public void addEmployee(Employee employee) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                size++;
                return;
            }
        }
        //size++;
        System.out.println("Книга сотрудников переполнена!");
    }

    /**
     * Найти среднюю зарплату в книге
     *
     * @return число double value
     */
    public double getAverageSalary() {
        if (size == 0) {
            return 0;
        }
        return getSumSalary() / size;
    }


    /**
     * Печать имен всех сотрудников в книге
     */
    public void printNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.printName();
            }
        }
    }

    /**
     * Получить сумму зарплат всех сотрудников в книге
     *
     * @return число double value
     */
    public double getSumSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    /**
     * Печать суммы зарплат всех сотрудников в книге
     */
    public void printSumSalary() {
        System.out.printf("Сумма зарплат всех сотрудников: %.2f", getSumSalary());
    }

    /**
     * Получить сумму зарплат всех сотрудников в книге по отделу
     *
     * @param department отдел
     * @return число double value
     */
    public double getSumSalaryByDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    /**
     * Печать суммы зарплат всех сотрудников в книге по отделу
     *
     * @param department отдел
     */
    public void printSumSalaryByDepartment(int department) {
        System.out.printf("Сумма зарплат всех сотрудников в отделе %d: %.2f", department, getSumSalaryByDepartment(department));
    }

    /**
     * Найти сотрудника с минимальной зарплатой в книге
     *
     * @return сотрудник object
     */
    public Employee findMinSalary() {
        int found = 0;
        double minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (minSalary > employees[i].getSalary()) {
                    minSalary = employees[i].getSalary();
                    found = i;
                }
            }
        }
        return employees[found];
    }

    /**
     * Печать имя сотрудника с минимальной зарплатой в книге
     */
    public void printMinSalaryEmployee() {
        System.out.printf("Сотрудник с минимальной зарплатой: " + findMinSalary().getFullName());
    }

    /**
     * Найти сотрудника с максимальной зарплатой в книге
     *
     * @return сотрудника object
     */
    public Employee findMaxSalary() {
        int found = 0;
        double minSalary = Integer.MIN_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (minSalary < employees[i].getSalary()) {
                    minSalary = employees[i].getSalary();
                    found = i;
                }
            }
        }
        return employees[found];
    }

    /**
     * Печать имя сотрудника с максимальной зарплатой в книге
     */
    public void printMaxSalaryEmployee() {
        System.out.printf("Сотрудник с максимальной зарплатой: " + findMaxSalary().getFullName());
        System.out.println();
        System.out.printf("Зарплата сотрудника с максимальной зарплатой: %.2f\n", findMaxSalary().getSalary());
    }

    /**
     * Получить имя сотрудника по его ID
     *
     * @param id ID
     * @return ФИО работника String
     */
    public String getNameFromID(int id) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getId() == id) {
                    return employee.getFullName();
                }
            }
        }
        return "Нет работника с данным ID";
    }

    /**
     * Печать ФИО сотрудника по его ID     *
     *
     * @param id id сотрудника
     */
    public void printNameById(int id) {
        System.out.printf("Имя работника с ID %d: %s\n", id, getNameFromID(id));
    }

    /**
     * Удалить сотрудника по id
     *
     * @param id id сотрудника
     */
    public void removeEmployeeFromId(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                this.size--;
                return;
            }
        }
    }

    /**
     * Печать всех сотрудников со всей их информацией в книге
     */
    public void printAllInfo() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("id: %d", employee.getId());
                System.out.println(employee);
            }
        }
    }

    /**
     * Индексировать зарплату всех сотрудников на определенный процент
     *
     * @param index Процент индексации
     */
    public void indexSalary(double index) {
        double sum = getSumSalary();
        for (Employee employee : employees) {
            if (employee != null) {
                double salary = employee.getSalary();
                double newSalary = salary * (1 + (index / 100));
                employee.setSalary(newSalary);
            }
        }
        System.out.printf("Измененная сумма зарплат: %.2f\n", (sum * (1 + index)));
    }

    /**
     * Получить сотрудника с минимальной зарплатой в отделе
     *
     * @param department отдел
     * @return сотрудник object
     */
    public Employee findMinSalaryByDepartment(int department) {
        int found = 0;
        double minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                if (minSalary > employees[i].getSalary()) {
                    minSalary = employees[i].getSalary();
                    found = i;
                }
            }
        }
        return employees[found];
    }

    /**
     * Найти сотрудника с максимальной зарплатой в отделе
     *
     * @param department отдел
     * @return сотрудник object
     */
    public Employee findMaxSalaryByDepartment(int department) {
        int found = 0;
        double maxSalary = Integer.MIN_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                if (maxSalary < employees[i].getSalary()) {
                    maxSalary = employees[i].getSalary();
                    found = i;
                }
            }
        }
        return employees[found];
    }

    /**
     * Получить среднюю зарплату всех сотрудников в отделе
     *
     * @param department отдел
     * @return средняя зарплата double
     */
    public double averageSalaryByDepartment(int department) {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    /**
     * Индексировать зарплату всех сотрудников в отделе на определенный процент
     *
     * @param department отдел
     */
    public void indexSalaryByDepartment(int department, double index) {
        double sum = getSumSalaryByDepartment(department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double salary = employee.getSalary();
                double newSalary = salary * (1 + index / 100);
                employee.setSalary(newSalary);
            }
        }
        System.out.printf("Измененная сумма зарплат в отделе: %.2f\n", (sum * (1 + index)));
    }

    /**
     * Печать имен сотрудников в отделе
     *
     * @param department отдел
     */
    public void printNamesByDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.printEmployeeWithOutDepartment();
                System.out.println();
            }
        }
    }

    /**
     * Печать имен сотрудников с зарплатой меньше чем указанное число
     *
     * @param salary меньше чем это число
     */
    public void printEmployeesWithSalaryLessThan(double salary) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                employee.printEmployeeWithOutDepartment();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Работников с зарплатой ниже значения не найдено.");
        }
    }

    /**
     * Печать сотрудников с зарплатой больше указанного числа
     *
     * @param salary больше чем это число
     */
    public void printEmployeesWithSalaryMoreThan(double salary) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                employee.printEmployeeWithOutDepartment();
                count++;
            }
        }
        if (count == 0) {
            System.out.printf("Работников с зарплатой выше %.2f не найдено.", salary);
        }
    }
}