public class dataEmployees {
    public static EmployeesBook book;

    public static EmployeesBook main(int size) {
        dataEmployees.book = new EmployeesBook(size);

        book.addEmployee(new Employee("Иванов", "Иван", "Иванович", 1, 150000));          //1
        book.addEmployee(new Employee("Петров", "Петр", 2, 140000));                                //2
        book.addEmployee(new Employee("Шишкин", "Михаил", "Валентинович", 3, 100000));   //3
        book.addEmployee(new Employee("Шишкин", "Геннадий", "Валентинович", 3, 105000));  //4
        book.addEmployee(new Employee("Травинова", "Ирина", "Семеновна", 3, 104000));   //5
        book.addEmployee(new Employee("Сидорова", "Кристина", "Дмитриевна", 4, 110000));//6
        book.addEmployee(new Employee("Тушкевич", "Максим", "Николаевич", 1, 142000));  //7
        book.addEmployee(new Employee("Крутов", "Дмитрий", 5, 180000));                            //8
        book.addEmployee(new Employee("Харитонов", "Илья", "Владимирович", 5, 155000)); //9
        book.addEmployee(new Employee("Кругляшова", "Ирина", "Борисовна", 2, 145210));  //10
        book.addEmployee(new Employee("Кругляшова", "Анастасия", "Борисовна", 2, 135000)); //11
        book.addEmployee(new Employee("Смирнова", "Ольга", "Ивановна", 4, 115000));   //
        book.addEmployee(new Employee("Макарова", "Анастасия", "Сергеевна", 4, 117000)); //13
        book.addEmployee(new Employee("Макарова", "Анастасия", "Сергеевна", 4, 119000)); //14

        return book;
    }
}
