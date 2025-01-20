import java.util.Scanner;

public class Validator {

    public static void checkId(String str) throws MyException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new MyException("Ожидается положительное целое число. Введите число.");
        }
        if (Integer.parseInt(str) < 0) {
            throw new MyException("Ожидается число > 0");
        }
    }

    public static void checkDepartment(String s) throws MyException {
        try {
            Integer.parseInt(s);
            if (Integer.parseInt(s) > 5 || Integer.parseInt(s) < 1) {
                throw new MyException("Ожидается номер департамента от 1 до 5.");
            }
        } catch (NumberFormatException e) {
            throw new MyException("Ожидается номер департамента от 1 до 5. Введите число.");
        }
    }

    public static void checkPositiveDigit(String s) throws MyException {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new MyException("Ожидается положительное число. Введите число.");
        }
        if (Double.parseDouble(s) <= 0) {
            throw new MyException("Число должно быть положительным.");
        }
    }

    public static void checkNameVerification(String s) throws MyException {
        if (s.isEmpty() || s.startsWith(" ")) {
            throw new MyException("Поле не может быть пустым или начинаться с отступа.");
        } else if (!s.matches("^[a-zA-Zа-яА-я]*+[-.\\s]?[a-zA-Zа-яА-Я]*?$")) {
            throw new MyException("Не может содержать специальные символы и цифры.");
        }

    }

    public static int inputDepartment() throws MyException {
        Scanner sc = new Scanner(System.in);
        boolean flag;
        String tempInt;
        do {
            flag = false;
            System.out.println("Введите номер департамента. Введите 0 для выхода в главное меню. ");
            tempInt = sc.nextLine();
            if (tempInt.equals("0")) {
                Main.mainMenu();
                break;
            }
            try {
                Validator.checkDepartment(tempInt);
            } catch (MyException e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        } while (flag);
        return Integer.parseInt(tempInt);
    }

    public static double inputSalary() throws MyException {
        Scanner sc = new Scanner(System.in);
        boolean flag;
        String temp;
        do {
            flag = false;
            System.out.println("Введите зарплату работника");
            temp = sc.nextLine();
            try {
                Validator.checkPositiveDigit(temp);
            } catch (MyException e) {
                flag = true;
                System.out.println(e.getMessage());
            }

        } while (flag);
        return Double.parseDouble(temp);
    }

    public static String inputName() throws MyException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String firstName = "notInit";
        while (flag) {
            try {
                System.out.println("Введите имя");
                firstName = sc.nextLine();
                Validator.checkNameVerification(firstName);
                flag = false;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        return firstName;
    }

    public static String inputLastName() throws MyException {
        boolean flag = true;
        String lastName = "notInit";
        Scanner sc = new Scanner(System.in);
        while (flag) {
            flag = false;
            try {
                System.out.println("Введите фамилию");
                lastName = sc.nextLine();
                Validator.checkNameVerification(lastName);
            } catch (MyException e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        }
        return lastName;
    }

    public static String inputMiddleName() throws MyException {
        Scanner sc = new Scanner(System.in);
        String middleName = "0";
        boolean flag = true;
        while (flag) {
            flag = false;
            try {
                System.out.println("Введите отчество. Если отчества нет, введите 0 ");
                middleName = sc.nextLine();
                if (middleName.equals("0")) {
                    return middleName;
                } else {
                    Validator.checkNameVerification(middleName);
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        }
        return middleName;
    }

    public static int inputId() throws MyException {
        Scanner sc = new Scanner(System.in);
        boolean flag;
        String temp;
        do {
            flag = false;
            System.out.println("Введите id сотрудника.");
            temp = sc.nextLine();
            try {
                Validator.checkId(temp);
            } catch (MyException e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        } while (flag);
        return Integer.parseInt(temp);
    }


}
