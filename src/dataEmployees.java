public class dataEmployees {
    public static EmployeeBook book = initBook(16);

    public static EmployeeBook initBook(int size) {
        dataEmployees.book = new EmployeeBook(size);
        int countOfEmployees = 0;
        while (countOfEmployees <= size) {
            book.addEmployee(new Employee("Иванов", "Иван", "Иванович", 1, 150000));
            countOfEmployees++;
            //1
            book.addEmployee(new Employee("Петров", "Петр", 2, 140000));
            countOfEmployees++;
            //2
            book.addEmployee(new Employee("Шишкин", "Михаил", "Валентинович", 3, 100000));
            countOfEmployees++;
            //3
            book.addEmployee(new Employee("Шишкин", "Геннадий", "Валентинович", 3, 105000));
            countOfEmployees++;
            //4
            book.addEmployee(new Employee("Травинова", "Ирина", "Семеновна", 3, 104000));
            countOfEmployees++;
            //5
            book.addEmployee(new Employee("Сидорова", "Кристина", "Дмитриевна", 4, 110000));
            countOfEmployees++;
            //6
            book.addEmployee(new Employee("Тушкевич", "Максим", "Николаевич", 1, 142000));
            countOfEmployees++;
            //7
            book.addEmployee(new Employee("Крутов", "Дмитрий", 5, 180000));
            countOfEmployees++;
            //8
            book.addEmployee(new Employee("Харитонов", "Илья", "Владимирович", 5, 155000));
            countOfEmployees++;
            //9
            book.addEmployee(new Employee("Кругляшова", "Ирина", "Борисовна", 2, 145210));
            countOfEmployees++;
            //10
            book.addEmployee(new Employee("Кругляшова", "Анастасия", "Борисовна", 2, 135000));
            countOfEmployees++;
            //11
            book.addEmployee(new Employee("Смирнова", "Ольга", "Ивановна", 4, 115000));
            countOfEmployees++;
            //12
            book.addEmployee(new Employee("Макарова", "Анастасия", "Сергеевна", 4, 117000));
            countOfEmployees++;
            //13
            book.addEmployee(new Employee("Макарова", "Анастасия", "Сергеевна", 4, 119000));
            countOfEmployees++;
            //14
            countOfEmployees = Integer.MAX_VALUE;
        }
        return book;
    }
}
