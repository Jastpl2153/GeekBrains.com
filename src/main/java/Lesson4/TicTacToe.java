package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final int SIZE = 3;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_TURN = 'X';
    public static final char DOT_OI = 'O';
    public static char[][] MAP = new char[SIZE][SIZE];
    public static Scanner SCANNER = new Scanner(System.in);
    public static Random RANDOM = new Random(SIZE);
    public static int WIN = 3;

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            stepTurn();
            printMap();
            if (checkWin(DOT_TURN)) {
                System.out.println("Победил человек");
                break;
            }
            if (fullMap()) {
                System.out.println("Ничья");
                break;
            }
            stepIO();
            printMap();
            if (checkWin(DOT_OI)) {
                System.out.println("Победил ИИ");
                break;
            }
            if (fullMap()) {
                System.out.println("Ничья");
                break;
            }
        }
        SCANNER.close();
    }

    public static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE && y < 0 || y >= SIZE)
            return false;
        return MAP[x][y] == DOT_EMPTY;
    }

    public static void stepTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты X и Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));
        MAP[x][y] = DOT_TURN;
    }

    public static void stepIO() {
        int x, y;
        do {
            System.out.println("Введите координаты X и Y");
            x = RANDOM.nextInt(SIZE);
            y = RANDOM.nextInt(SIZE);
        } while (!isCellValid(x, y));
        MAP[x][y] = DOT_OI;
    }

    public static boolean fullMap() {
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[i].length; j++) {
                if (MAP[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char dot) {
        for (int i = 0; i < WIN; i++) {
            if ((MAP[i][0] == dot && MAP[i][1] == dot && MAP[i][2] == dot) ||
                    (MAP[0][i] == dot && MAP[1][i] == dot && MAP[2][i] == dot))
                return true;
            if ((MAP[0][0] == dot && MAP[1][1] == dot && MAP[2][2] == dot) ||
                    (MAP[0][2] == dot && MAP[1][1] == dot && MAP[2][0] == dot))
                return true;
        }
        return false;
    }

    /*попытка реализации поля 5 на 5 проверка победы!!!*/
//    public static boolean checkWinDiagonal (char dot){
//        boolean toRight, toLeft;
//        toRight = true;
//        toLeft = true;
//        for (int i = 0; i < WIN ; i++) {
//            toRight &= MAP[i][i] == dot;
//            toLeft &= MAP[WIN - i - 1][i] == dot;
//            toRight &= MAP[i][i + 1] == dot;
//            toLeft &= MAP[WIN - i - 1][i + 1] == dot;
//            toRight &= MAP[i + 1][i] == dot;
//            toLeft &= MAP[4 - 1][i] == dot;
//            toRight &= MAP[i + 1][i + 1] == dot;
//            toLeft &= MAP[4 - i][i + 1] == dot;
//        }
//
//        return toRight || toLeft;
//    }
//
//    public static boolean checkWinLanes (char dot, int setX, int setY){
//        boolean row, col;
//        row = true;
//        col = true;
//        int block = 4;
//        for (int i = setX ; i < WIN; i++) {
//            for (int j = setY ; j < WIN; j++) {
//                row &= MAP[i][j] == dot;
//                col &= MAP[j][i] == dot;
//            }
//        }
//        return col || row;
//    }
//
//    public static boolean checkWins (char dot){
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (checkWinDiagonal(dot) || checkWinLanes( dot, 1, 1))
//                    return true;
//            }
//        }
//        return false;
//    }
}
