package Lesson3;

import java.util.Arrays;

public class Info {
//  1.  Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
//    [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
//
//  2.  Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями
//    1 2 3 4 5 6 7 8 … 100;
//
//  3.  Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие
//    6 умножить на 2;
//
//  4.  Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами.
//
//  5.  Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
//    одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
//
// *6. Задать одномерный массив и найти в нем минимальный и максимальный элементы;
//
//**7. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен
// вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
//
//***8. Написать метод, которому на вход подается одномерный массив и число n (может быть
// положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
// Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

    public static void main(String[] args) {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arrayHundredFor = new int[100];
        int[] arraySix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arraySquare = new int[6][6];
        int[] arrayMaxMin = {1, 15, 23, -2, 11, 34, 5, 203, -4, -8, 9, 51};
        int[] arrayBalance = {2, 2, 2, 1, 2, 2, 10, 1, 2};
        int[] arrayShift = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(arrayOneAndZero(array)));
        arrayHundred(arrayHundredFor);
        System.out.println(Arrays.toString(arraySixMultiplyTwo(arraySix)));
        squareArrayDiagonal(arraySquare);
        System.out.println(Arrays.toString(initialArray(5, 8)));
        maxMinArray(arrayMaxMin);
        System.out.println(arrayBalanceEqually(arrayBalance));
        System.out.println(Arrays.toString(shiftArray(arrayShift, 5)));

    }

    public static int[] arrayOneAndZero(int[] array) {
        System.out.println(Arrays.toString(array));
        System.out.println("Измененная версия.");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1)
                array[i] = 0;
            else if (array[i] == 0)
                array[i] = 1;
        }
        return array;
    }

    public static void arrayHundred(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.print(Arrays.toString(array));
        System.out.println();
    }

    public static int[] arraySixMultiplyTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
        return array;
    }

    public static void squareArrayDiagonal(int[][] array) {
        int diagonalOne = 1;
        int start = 0;
        int end = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array[i].length / 2 + 2) {
                array[i][start] = diagonalOne;
                array[i][end] = diagonalOne;
                start++;
                end--;
            } else if (array[i].length % 2 == 1 && i == array[i].length / 2) {
                array[i][start] = diagonalOne;
                start++;
                end--;
            } else if (i + 1 > array[i].length / 2 + 1 || i + 1 > array[i].length / 2) {
                array[i][start] = diagonalOne;
                array[i][end] = diagonalOne;
                start++;
                end--;
            }
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] initialArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    public static void maxMinArray(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
            else if (array[i] > max)
                max = array[i];
        }
        System.out.println("Минимальный элемент = " + min);
        System.out.println("Максимальный элемент = " + max);
    }

    public static boolean arrayBalanceEqually(int[] array) {
        int left = array[0];
        int right = array[array.length-1];
        for (int i = 1, j = array.length - 2; i != j; i++, j--) {
            if (left < right)
                left += array[i];
            else if (left > right)
                right += array[j];
            else {
                left += array[i];
                right += array[j];
            }
        }
        return left == right;
    }

    public static int[] shiftArray(int[] array, int n) {
        int index = 0;
        int[] copyArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            if (n > 0) {
                index = i + n;
                if (index > array.length - 1) {
                    index -= array.length;
                }
                copyArray[index] = array[i];
            }
            if (n < 0) {
                index = array.length + i + n;
                if (index > array.length - 1) {
                    index -= array.length;
                }
                copyArray[index] = array[i];
            }
        }
        return copyArray;
    }
}