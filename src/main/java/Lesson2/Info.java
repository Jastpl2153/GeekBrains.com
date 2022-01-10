package Lesson2;

public class Info {
//   1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма
//    лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном
//    случае – false.
//
//   2. Написать метод, которому в качестве параметра передается целое число, метод должен
//    напечатать в консоль, положительное ли число передали или отрицательное. Замечание:
//    ноль считаем положительным числом.
//
//   3. Написать метод, которому в качестве параметра передается целое число. Метод должен
//    вернуть true, если число отрицательное, и вернуть false если положительное.
//
//   4. Написать метод, которому в качестве аргументов передается строка и число, метод
//    должен отпечатать в консоль указанную строку, указанное количество раз;
//
//  *5. Написать метод, который определяет, является ли год високосным, и возвращает boolean
//   (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме
//   каждого 100-го, при этом каждый 400-й – високосный.

    public static void main(String[] args) {
        System.out.println(sumOfNumbers(10, 11));
        positiveOrNegative(-10);
        System.out.println(boolPositiveOrNegative(10));
        printToConsole("GeekBrains", 5);
        System.out.println(yearBoolean(500));
    }

    public static boolean sumOfNumbers(int value, int number) {
        return value + number >= 10 && value + number <= 20;
    }

    public static void positiveOrNegative(int number) {
        if (number >= 0)
            System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    public static boolean boolPositiveOrNegative(int value) {
        return value <= 0;
    }

    public static void printToConsole(String word, int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
            System.out.print(word + "! ");
        }
        System.out.println();
    }

    public static boolean yearBoolean(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
