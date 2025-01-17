import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static EmployeeBook book1 = dataEmployees.book;

    static void mainMenu() throws MyException {
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
        System.out.println("0. Выйти");
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            choiceMenu(0);
        }
        choiceMenu(choice);
    }

    static boolean isNotIntPositiveDigit(String str) {
        if (str.matches("^[0-9]+$")) {
            return !(Integer.parseInt(str) >= 0);
        }
        return true;
    }

    static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    static void choiceMenu(int choice) throws MyException {
        Scanner sc = new Scanner(System.in);
        String tempInt;
        String tempDouble = "notInit";
        String firstName, lastName, middleName;
        String EXIT_MAIN_MENU = "\"0\". для выхода в главное меню. ";
        String EXIT = "Нажмите любую клавишу для выхода. ";

        boolean flag;
        int depAdd;
        int addId;
        double indexSalary;
        double salary;
        switch (choice) {
            case 1:
                book1.printAllInfo();
                System.out.println(EXIT_MAIN_MENU);
                System.out.println(EXIT);
                if (input().equals("0")) {
                    mainMenu();
                }
                return;

            case 2:
                System.out.println(book1.getSumSalary());
                System.out.println(EXIT_MAIN_MENU);
                System.out.println(EXIT);
                if (input().equals("0")) {
                    mainMenu();
                }
                return;

            case 3:
                Employee found3 = book1.findMinSalary();
                found3.printName();
                System.out.println("Зарплата минимальная: " + found3.getSalary());
                System.out.println("\n" + EXIT_MAIN_MENU);
                System.out.println(EXIT);
                if (input().equals("0")) {
                    mainMenu();
                }
                return;

            case 4:
                Employee found4 = book1.findMaxSalary();
                found4.printName();
                System.out.println("Зарплата максимальная: " + found4.getSalary());
                System.out.println(EXIT_MAIN_MENU);
                System.out.println(EXIT);
                if (input().equals("0")) {
                    mainMenu();
                }
                return;

            case 5:
                System.out.printf("Средняя зарплата: %.2f\n", book1.getAverageSalary());
                System.out.println(EXIT_MAIN_MENU);
                System.out.println(EXIT);
                if (input().equals("0")) {
                    mainMenu();
                }
                return;

            case 6:
                book1.printNames();
                System.out.println(EXIT_MAIN_MENU);
                System.out.println(EXIT);
                if (input().equals("0")) {
                    mainMenu();
                }
                return;

            case 7:
                do {
                    flag = false;
                    try {
                        System.out.println("Введите процент индексации");
                        tempDouble = input();
                        if (tempDouble.equals("0")) {
                            mainMenu();
                            return;
                        }
                        Validator.checkPositiveDigit(tempDouble);
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                        flag = true;
                    }
                } while (flag);
                book1.indexSalary(Double.parseDouble(tempDouble));
                System.out.println(EXIT_MAIN_MENU);
                System.out.println(EXIT);
                if (input().equals("0")) {
                    mainMenu();
                }
                return;

            case 8:
                depAdd = Validator.inputDepartment();
                System.out.println("Минимальная зарплата в отделе " + depAdd + " у сотрудника: " + book1.findMinSalaryByDepartment(depAdd).getFullName());
                System.out.println("Зарплата составляет: " + book1.findMinSalaryByDepartment(depAdd).getSalary() + " рублей.");
                System.out.println(EXIT_MAIN_MENU);
                System.out.println("9. Найти максимальную зарплату в этом же отделе");
                System.out.println("8. Выбрать другой отдел ");
                System.out.println(EXIT);
                tempInt = sc.nextLine();
                if (!isNotIntPositiveDigit(tempInt)) {
                    if (Integer.parseInt(tempInt) == 0) {
                        mainMenu();
                        return;
                    } else if (Integer.parseInt(tempInt) == 9) {
                        System.out.println("Максимальная зарплата в отделе " + depAdd + " у сотрудника: " + book1.findMaxSalaryByDepartment(depAdd).getFullName());
                        System.out.println("Зарплата составляет: " + book1.findMaxSalaryByDepartment(depAdd).getSalary() + " рублей.");
                        System.out.println(EXIT_MAIN_MENU);
                        System.out.println(EXIT);
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
                depAdd = Validator.inputDepartment();
                System.out.println("Максимальная зарплата в отделе " + depAdd + " у сотрудника: " + book1.findMaxSalaryByDepartment(depAdd).getFullName());
                System.out.println("Зарплата составляет: " + book1.findMaxSalaryByDepartment(depAdd).getSalary() + " рублей.");
                System.out.println(EXIT_MAIN_MENU);
                System.out.println(EXIT);
                tempInt = sc.nextLine();
                if (tempInt != null) {
                    if (tempInt.equals("0")) {
                        mainMenu();
                    }
                    return;
                }
            case 10:
                System.out.println("Средняя зарплата в отделе: " + book1.averageSalaryByDepartment(Validator.inputDepartment()));
                System.out.println("Что бы выйти в главное меню, введите любой символ");
                if (sc.next() != null) {
                    mainMenu();
                }
                return;
            case 11:
                depAdd = Validator.inputDepartment();
                do {
                    flag = false;
                    System.out.println("Введите процент индексации. \"0\". Для выхода в главное меню.");
                    tempDouble = sc.nextLine();
                    if (tempDouble.equals("0")) {
                        mainMenu();
                        return;
                    }
                    try {
                        Validator.checkPositiveDigit(tempDouble);
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                        flag = true;
                    }
                } while (flag);
                indexSalary = Double.parseDouble(tempDouble);
                book1.indexSalaryByDepartment(depAdd, indexSalary);
                System.out.println("\"0\". Выбрать другой отдел ");
                System.out.println(EXIT);
                if (input().equals("0")) {
                    choiceMenu(11);
                }
                break;
            case 12:
                depAdd = Validator.inputDepartment();
                book1.printNamesByDepartment(depAdd);
                System.out.println("\"0\". Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 13:
                System.out.println("Введите сумму, для вывода сотрудников с зарплатой ниже указанной");
                book1.printEmployeesWithSalaryLessThan(Validator.inputSalary());
                System.out.println("\"0\". Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 14:
                System.out.println("Введите сумму, для вывода сотрудников с зарплатой выше указанной");
                book1.printEmployeesWithSalaryMoreThan(Validator.inputSalary());
                System.out.println("\"0\". Выйти в главное меню ");
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
                firstName = Validator.inputName();
                lastName = Validator.inputLastName();
                middleName = Validator.inputMiddleName();
                depAdd = Validator.inputDepartment();
                salary = Validator.inputSalary();
                if (middleName.equals("0")) {
                    book1.addEmployee(new Employee(lastName, firstName, depAdd, salary));
                } else {
                    book1.addEmployee(new Employee(lastName, firstName, middleName, depAdd, salary));
                }
                System.out.println("Работник добавлен");
                System.out.println(EXIT_MAIN_MENU);
                System.out.println(EXIT);
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 16:
                addId = Validator.inputId();
                if (book1.isHaveEmployee(addId)) {
                    book1.removeEmployeeFromId(addId);
                    System.out.println("Работник удален");
                } else {
                    System.out.println("Нет работника с таким Id");
                }
                System.out.println(EXIT_MAIN_MENU);
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;

            case 17:
                addId = Validator.inputId();
                book1.printNameById(addId);
                System.out.println("\"0\". Выйти в главное меню ");
                if (sc.nextInt() == 0) {
                    mainMenu();
                }
                return;
            case 0:
                return;


            default:
                System.out.println("Нет такой команды. Для возврата нажмите \"0\".");
                System.out.println(EXIT);
                try {
                    if (sc.nextInt() == 0) {
                        mainMenu();
                    }
                } catch (InputMismatchException e) {
                    return;
                }

        }
    }

    public static void main(String[] args) throws MyException {
        mainMenu();
    }
}