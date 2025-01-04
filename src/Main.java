import java.util.Scanner;

public class Main {
    static EmployeeBook book1 = dataEmployees.book;

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
        int choice = scan.nextInt();
        choiceMenu(choice);
    }

    static boolean isNotString(String str) {
        return !(str.matches("^[a-zA-Zа-яА-я]*+[-.\\s]?[a-zA-Zа-яА-Я]*?$") && !str.isEmpty() && !str.startsWith(" "));
    }

    static boolean isNotRightDepartment(String str) {
        return !str.matches("^[1-5]$");
    }

    static boolean isNotDoubleDigit(String str) {
        if (str.matches("^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$")) {
            return !(Double.parseDouble(str) >= 0);
        }
        return true;
    }

    static boolean isNotIntPositiveDigit(String str) {
        if (str.matches("^[0-9]+$")) {
            return !(Integer.parseInt(str) >= 0);
        }
        return true;
    }


    static void choiceMenu(int choice) {
        String back = "0";
        Scanner sc = new Scanner(System.in);
        String tempString;
        String tempInt;
        String tempDouble;
        double indexSalary;
        double salary;
        int depAdd;
        switch (choice) {
            case 1:
                book1.printAllInfo();
                System.out.println("0. Выйти в главное меню ");
                System.out.println("Нажмите любую клавишу для выхода");
                tempInt = sc.nextLine();
                if (tempInt != null) {
                    if (tempInt.equals("0")) {
                        mainMenu();
                    }
                    return;
                }
                return;
            case 2:
                System.out.println(book1.getSumSalary());
                System.out.println("0. Выйти в главное меню ");
                System.out.println("Нажмите любую клавишу для выхода.");
                tempInt = sc.nextLine();
                if (tempInt != null) {
                    if (tempInt.equals("0")) {
                        mainMenu();
                    }
                    return;
                }
                return;
            case 3:
                Employee found3 = book1.findMinSalary();
                found3.printName();
                System.out.println("Зарплата минимальная: " + found3.getSalary());
                System.out.println("\n0. Выйти в главное меню ");
                tempInt = sc.nextLine();
                if (isNotIntPositiveDigit(tempInt)) {
                    if (sc.nextInt() == 0) {
                        mainMenu();
                        return;
                    }
                }
                return;
            case 4:
                Employee found4 = book1.findMaxSalary();
                found4.printName();
                System.out.println("Зарплата максимальная: " + found4.getSalary());
                System.out.println("0. Выйти в главное меню ");
                System.out.println("Нажмите любую клавишу для выхода.");
                tempInt = sc.nextLine();
                if (tempInt != null) {
                    if (tempInt.equals("0")) {
                        mainMenu();
                    }
                    return;
                }
                return;
            case 5:
                System.out.printf("Средняя зарплата: %.2f\n", book1.getAverageSalary());
                System.out.println("0. Выйти в главное меню ");
                System.out.println("Нажмите любую клавишу для выхода.");
                tempInt = sc.nextLine();
                if (tempInt != null) {
                    if (tempInt.equals("0")) {
                        mainMenu();
                    }
                    return;
                }
                return;
            case 6:
                book1.printNames();
                System.out.println("0. Выйти в главное меню ");
                System.out.println("Нажмите любую клавишу для выхода.");
                tempInt = sc.nextLine();
                if (tempInt != null) {
                    if (tempInt.equals("0")) {
                        mainMenu();
                    }
                    return;
                }
                return;
            case 7:
                do {
                    System.out.println("Введите процент индексации");
                    tempDouble = sc.nextLine();
                    if (tempDouble.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotDoubleDigit(tempDouble));
                indexSalary = Double.parseDouble(tempDouble);
                book1.indexSalary(indexSalary);
                System.out.println("0. Выйти в главное меню ");
                System.out.println("Нажмите любую клавишу для выхода.");
                tempInt = sc.nextLine();
                if (tempInt != null) {
                    if (tempInt.equals("0")) {
                        mainMenu();
                    }
                    return;
                }
                return;
            case 8:
                do {
                    System.out.println("Введите номер отдела (от 1 до 5). Введите 0 для выхода");
                    tempInt = sc.nextLine();
                    if (tempInt.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotRightDepartment(tempInt));
                depAdd = Integer.parseInt(tempInt);
                System.out.println("Минимальная зарплата в отделе " + depAdd + " у сотрудника: " + book1.findMinSalaryByDepartment(depAdd).getFullName());
                System.out.println("Зарплата составляет: " + book1.findMinSalary().getSalary() + " рублей.");
                System.out.println("0. Выйти в главное меню ");
                System.out.println("9. Найти максимальную зарплату в этом же отделе");
                System.out.println("8. Выбрать другой отдел ");
                System.out.println("Нажмите любую клавишу для выхода.");
                tempInt = sc.nextLine();
                if (!isNotIntPositiveDigit(tempInt)) {
                    if (Integer.parseInt(tempInt) == 0) {
                        mainMenu();
                        return;
                    } else if (Integer.parseInt(tempInt) == 9) {
                        System.out.println("Максимальная зарплата в отделе " + depAdd + " у сотрудника: " + book1.findMaxSalaryByDepartment(depAdd).getFullName());
                        System.out.println("Зарплата составляет: " + book1.findMaxSalaryByDepartment(depAdd).getSalary() + " рублей.");
                        System.out.println("0. Выйти в главное меню ");
                        System.out.println("Нажмите любую клавишу для выхода.");
                        tempInt = sc.nextLine();
                        if (tempInt != null) {
                            if (tempInt.equals("0")) {
                                mainMenu();
                            }
                            return;
                        }

                    } else if (Integer.parseInt(tempInt) == 8) {
                        choiceMenu(8);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 9:
                do {
                    System.out.println("Введите номер отдела (от 1 до 5). Введите 0 для выхода");
                    tempInt = sc.nextLine();
                    if (tempInt.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotRightDepartment(tempInt));
                depAdd = Integer.parseInt(tempInt);
                System.out.println("Максимальная зарплата в отделе " + depAdd + " у сотрудника: " + book1.findMaxSalaryByDepartment(depAdd).getFullName());
                System.out.println("Зарплата составляет: " + book1.findMaxSalaryByDepartment(depAdd).getSalary() + " рублей.");
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                    return;
                }
            case 10:
                do {
                    System.out.println("Введите номер отдела (от 1 до 5). Введите 0 для выхода");
                    tempInt = sc.nextLine();
                    if (tempInt.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotRightDepartment(tempInt));
                depAdd = Integer.parseInt(tempInt);
                System.out.println("Средняя зарплата в отделе: " + book1.averageSalaryByDepartment(depAdd));
                System.out.println("Что бы выйти в главное меню, введите любой символ");
                if (sc.next() != null) {
                    mainMenu();
                }
                return;
            case 11:
                do {
                    System.out.println("Введите номер отдела (от 1 до 5). Введите 0 для выхода");
                    tempInt = sc.nextLine();
                    if (tempInt.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotRightDepartment(tempInt));
                depAdd = Integer.parseInt(tempInt);
                do {
                    System.out.println("Введите процент индексации");
                    tempDouble = sc.nextLine();
                    if (tempDouble.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotDoubleDigit(tempDouble));
                indexSalary = Double.parseDouble(tempDouble);
                book1.indexSalaryByDepartment(depAdd, indexSalary);
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 12:
                do {
                    System.out.println("Введите номер отдела (от 1 до 5). Введите 0 для выхода");
                    tempInt = sc.nextLine();
                    if (tempInt.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotRightDepartment(tempInt));
                depAdd = Integer.parseInt(tempInt);
                book1.printNamesByDepartment(depAdd);
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 13:
                do {
                    System.out.println("Введите сумму, для вывода сотрудников с зарплатой ниже указанной");
                    tempDouble = sc.nextLine();
                    if (tempDouble.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotDoubleDigit(tempDouble));
                salary = Double.parseDouble(tempDouble);
                book1.printEmployeesWithSalaryLessThan(salary);
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 14:
                do {
                    System.out.println("Введите сумму, для вывода сотрудников с зарплатой выше указанной");
                    tempDouble = sc.nextLine();
                    if (tempDouble.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotDoubleDigit(tempDouble));
                salary = Double.parseDouble(tempDouble);
                book1.printEmployeesWithSalaryMoreThan(salary);
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 15:
                if (!book1.isHavePlace()) {
                    System.out.println("Книга переполнена");
                    mainMenu();
                    return;
                }
                System.out.println("Введите имя");
                tempString = sc.nextLine();
                while (isNotString(tempString)) {
                    System.out.println("Недопустимые символы.");
                    System.out.println("Введите имя");
                    tempString = sc.nextLine();
                }
                String firstName = tempString;
                System.out.println("Введите фамилию");
                tempString = sc.nextLine();
                while (isNotString(tempString)) {
                    System.out.println("Недопустимые символы.");
                    System.out.println("Введите фамилию");
                    tempString = sc.nextLine();
                }
                String lastName = tempString;
                System.out.println("Введите отчество. Если отчества нет, введите 0");
                tempString = sc.nextLine();
                if (!tempString.equals("0")) {
                    while (isNotString(tempString)) {
                        System.out.println("Недопустимые символы.");
                        System.out.println("Введите отчество");
                        tempString = sc.nextLine();
                    }
                }
                String middleName = tempString;
                System.out.println("Введите номер отдела");
                tempInt = sc.nextLine();
                while (isNotRightDepartment(tempInt)) {
                    System.out.println("Введите номер отдела от 1 до 5");
                    tempInt = sc.nextLine();
                }
                depAdd = Integer.parseInt(tempInt);
                System.out.println("Введите зарплату работника");
                tempDouble = sc.nextLine();
                while (isNotDoubleDigit(tempDouble)) {
                    System.out.println("Недопустимые символы");
                    System.out.println("Введите зарплату работника");
                    tempDouble = sc.nextLine();
                }
                double salAdd = Double.parseDouble(tempDouble);
                if (middleName.equals("0")) {
                    book1.addEmployee(new Employee(lastName, firstName, depAdd, salAdd));
                } else {
                    book1.addEmployee(new Employee(lastName, firstName, middleName, depAdd, salAdd));
                }
                System.out.println("Работник добавлен");
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 16:
                do {
                    System.out.println("Введите id сотрудника. Для выхода в главное меню введите \"0\"");
                    tempInt = sc.nextLine();
                    if (tempInt.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotIntPositiveDigit(tempInt));

                book1.removeEmployeeFromId(Integer.parseInt(tempInt));
                System.out.println("Работник удален");
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;

            case 17:
                do {
                    System.out.println("Введите id сотрудника. Введите \"0\" для выхода в главное меню.");
                    tempInt = sc.nextLine();
                    if (tempInt.equals("0")) {
                        mainMenu();
                        return;
                    }
                } while (isNotIntPositiveDigit(tempInt));
                book1.printNameById(Integer.parseInt(tempInt));
                System.out.println("0. Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 18:
                return;
            default:
                System.out.println("Нет такой команды. Для возврата нажмите 0");
                int defaultChoice = sc.nextInt();
                if (back.equals("" + defaultChoice)) {
                    mainMenu();
                }
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }
}