import java.util.Scanner;

public class Main {
    static EmployeesBook book1 = dataEmployees.main(10);

    static void mainMenu() {
        System.out.println("Добро пожаловать в главное меню. Выберите действие:");
        System.out.println("1. Вывести всех сотрудников");
        System.out.println("2. Вывести суммарную зарплату всех сотрудников");
        System.out.println("3. Найти сотрудника с минимальной зарплатой");
        System.out.println("4. Найти сотрудника с максимальной зарплатой");
        System.out.println("5. Подсчитать среднее значение зарплаты всех сотрудников");
        System.out.println("6. Вывести ФИО всех сотрудников");
        System.out.println("7. Проиндексировать зарплату всех сотрудников в %%");
        System.out.println("8. Найти сотрудника с минимальной зарплатой в отделе");
        System.out.println("9. Найти сотрудника с максимальной зарплатой в отделе");
        System.out.println("10. Расчитать среднюю ЗП в отделе");
        System.out.println("11. Проиндексировать зарплату сотрудников в отделе в %");
        System.out.println("12. Вывести всех сотрудников отдела");
        System.out.println("13. Вывести всех сотрудников с зарплатой ниже указанной");
        System.out.println("14. Вывести всех сотрудников с зарплатой выше указанной");
        System.out.println("15. Добавить нового сотрудника");
        System.out.println("16. Удалить сотрудника по id");
        System.out.println("17. Найти сотрудника по id");
        System.out.println("18. Выйти");
        Scanner scan = new Scanner(System.in);
        int choise = scan.nextInt();
        choiseMenu(choise);
    }

    static void choiseMenu(int choise) {
        String back = "0";
        Scanner sc = new Scanner(System.in);
        //System.out.println("Введите число");
        switch (choise) {
            case 1:
                book1.printAllInfo();
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 2:
                System.out.println(book1.getSumSalary());
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 3:
                Employee found3 = book1.findMinSalary();
                found3.printName();
                System.out.println("Зарплата минимальная: " + found3.getSalary());
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 4:
                Employee found4 = book1.findMaxSalary();
                found4.printName();
                System.out.println("Зарплата максимальная: " + found4.getSalary());
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 5:
                System.out.printf("Средняя зарплата: %.2f\n", book1.getAverageSalary());
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 6:
                book1.printNames();
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 7:
                System.out.println("Введите процент индексации");
                int index7 = sc.nextInt();
                book1.indexSalary(index7);
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 8:
                System.out.println("Введите номер отдела");
                int dep8 = sc.nextInt();
                System.out.println(book1.findMinSalaryByDepratment(dep8));
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 9:
                System.out.println("Введите номер отдела");
                int dep9 = sc.nextInt();
                System.out.println(book1.findMaxSalarybyDepratment(dep9));
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 10:
                System.out.println("Введите номер отдела");
                int dep10 = sc.nextInt();
                System.out.println(book1.averageSalaryByDepartment(dep10));
                System.out.println("Что бы выйти в главное меню, нажмите любую кнопку");
                if (sc.next() != null) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 11:
                System.out.println("Введите номер отдела");
                int dep11 = sc.nextInt();
                System.out.println("Введите процент индексации");
                int index11 = sc.nextInt();
                book1.indexSalaryByDepartment(dep11, index11);
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 12:
                System.out.println("Введите номер отдела");
                int dep12 = sc.nextInt();
                book1.printNamesByDepartment(dep12);
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 13:
                System.out.println("Введите сумму, для вывода сотрудников ниже указанной");
                double sal13 = sc.nextDouble();
                book1.printEmployeesWithSalaryLessThan(sal13);
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 14:
                System.out.println("Введите сумму, для вывода сотрудников выше указанной");
                double sal14 = sc.nextDouble();
                book1.printEmployeesWithSalaryMoreThan(sal14);
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 15:
                if (!book1.isHavePlace()) {
                    System.out.println("Книга переполнена");
                    mainMenu();
                    choiseMenu(sc.nextInt());
                    break;

                }
                System.out.println("Введите имя");
                String firstName = sc.nextLine();
                System.out.println("Введите фамилию");
                String lastName = sc.nextLine();
                System.out.println("Введите отчество. Если отчества нет, введите 0");
                String middleName = sc.nextLine();
                System.out.println("Введите номер отдела");
                int depAdd = sc.nextInt();
                System.out.println("Введите зарплату работника");
                double salAdd = sc.nextDouble();
                if (middleName.equals("0")) {
                    book1.addEmployee(new Employee(lastName, firstName, depAdd, salAdd));
                } else {
                    book1.addEmployee(new Employee(lastName, firstName, middleName, depAdd, salAdd));
                }
                System.out.println("Работник добавлен");
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 16:
                System.out.println("Введите id сотрудника");
                book1.removeEmployeeFromId(sc.nextInt());
                System.out.println("Работник удален");
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
                break;
            case 17:
                System.out.println("Введите id сотрудника");
                int intChoise17 = sc.nextInt();
                System.out.println(book1.getNameFromID(intChoise17));
                break;
            case 18:
                return;
            default:
                System.out.println("Нет такой команды. Для возврата нажмите 0");
                int defaultChoise = sc.nextInt();
                if (back.equals("" + defaultChoise)) {
                    mainMenu();
                    choiseMenu(sc.nextInt());
                }
        }
    }

    public static void main(String[] args) {
        //      EmployeesBook book = new EmployeesBook(10);
        //      book.addEmployee(new Employee("Иванов", "Иван", "Иванович", 1, 150000));          //1
        //      book.addEmployee(new Employee("Петров", "Петр", 2, 140000));                                //2
        //      book.addEmployee(new Employee("Шишкин", "Михаил", "Валентинович", 3, 100000));   //3
        //      book.addEmployee(new Employee ("Шишкин", "Геннадий", "Валентинович", 3, 105000));  //4
        //      book.addEmployee(new Employee ("Травинова", "Ирина", "Семеновна", 3, 104000));   //5
        //      book.addEmployee(new Employee ("Сидорова", "Кристина", "Дмитриевна", 4, 110000));//6
        //      book.addEmployee(new Employee ("Тушкевич", "Максим", "Николаевич", 1, 142000));  //7
        //      book.addEmployee(new Employee ("Крутов", "Дмитрий", 5, 180000));                            //8
        //      book.addEmployee(new Employee ("Харитонов", "Илья", "Владимирович", 5, 155000)); //9
        //      book.addEmployee(new Employee ("Кругляшова", "Ирина", "Борисовна", 2, 145210));  //10

        mainMenu();
        //System.out.println(book);
        //EmployeesBook book1 = dataEmployees.main(10);

        //book1.printEmployees();


//        book.printAllInfo();
//        book.printNames();
//        System.out.println(book.getSumSalary());
//        book.findMinSalary().printName();
//        book.findMaxSalary().printName();
//        System.out.println(book.getNameFromID(1));
//        book.removeEmployeeFromId(2);

//        book.addEmployee(new Employee("Петров", "Петр", 2, 140000));
//        System.out.println(book.getNameFromID(2));
//        System.out.println(book.getAverageSalary());
//        System.out.println(book.findMinSalary());
//        System.out.println(book.findMaxSalary());
//        book.printNames();
//        book.indexSalary(7);
//        book.printNamesByDepartment(1);
//        book.printEmployeesWithSalaryLessThan(120000);
//        book.printEmployeesWithSalaryMoreThan(120000);


    }
}