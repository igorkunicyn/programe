package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (!isMapFull()) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил искусственный интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static void aiTurn() {
        int x=0;
        int y=0;
           do {
               boolean flag = false;
               for (int i = 0; i < SIZE&&!flag;i++ ) {
                    for (int j = 0; j <SIZE ;j++ ) {
                        if (map[i][j]==DOT_EMPTY){
                        map[i][j]=DOT_X;
                            if (checkWin(DOT_X)) {
                                x = i;
                                y = j;
                                map[i][j] = DOT_EMPTY;
                                flag = true;
                                break;
                            } else {
                            map[i][j]=DOT_EMPTY;
                            }
                        }
                    }
               }
               if (!flag){
                   x = rand.nextInt(SIZE);
                   y = rand.nextInt(SIZE);
               }
           } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[x][y]=DOT_O;
    }

    public static boolean checkWin(char symbol) {

//        Проверка для поля 5х5 и 4 фишек
            int count;
            //Проверяем строки
            for (int i = 0; i < SIZE; i++) {
                count = 0;
                for (int j = 0; j < SIZE - 1; j++) {
                    if (map[i][j] == symbol && map[i][j + 1] == symbol) count++;
                }
                if (count >= DOTS_TO_WIN - 1) return true;
            }
        // Проверяем столбцы
        for (int i = 0; i < SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[j][i] == symbol && map[j + 1][i] == symbol) count++;
            }
            if (count >= DOTS_TO_WIN - 1) return true;
        }
//        Проверяем большую диагональ /
        for (int i = 0; i < SIZE - 1; ) {
            count = 0;
            for (int j = SIZE - 1; j >= 1; j--) {
                if (map[i][j] == symbol && map[i + 1][j - 1] == symbol) count++;
                i++;
            }
            if (count >= DOTS_TO_WIN - 1) return true;
        }
//        Проверяем большую диагональ \
        for (int i = 0; i < SIZE - 1; ) {
            count = 0;
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[i][j] == symbol && map[i + 1][j + 1] == symbol) count++;
                i++;
            }
            if (count >= DOTS_TO_WIN - 1) return true;
        }
        int n = SIZE - DOTS_TO_WIN;
//        n - число диагоналей, которые нужно дополнительно проверить вверх и вниз
//        от 2-х главных диагоналей
//
//        Проверяем дополнительные диагонали вверх/
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < SIZE - k - 1; ) {
                count = 0;
                for (int j = SIZE - 1 - k; j >= 1; j--) {
                    if (map[i][j] == symbol && map[i + 1][j - 1] == symbol) count++;
                    i++;
                }
                if (count >= DOTS_TO_WIN - 1) return true;
            }
        }
//        Проверяем дополнительные диагонали / вниз
        for (int k = 1; k <= n; k++) {
            for (int i = k; i < SIZE - 1; ) {
                count = 0;
                for (int j = SIZE - 1; j >= k + 1; j--) {
                    if (map[i][j] == symbol && map[i + 1][j - 1] == symbol) count++;
                    i++;
                }
                if (count >= DOTS_TO_WIN - 1) return true;
            }
        }
//        Проверяем дополнительные диагонали \ вверх
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < SIZE - k - 1; ) {
                count = 0;
                for (int j = k; j < SIZE - 1; j++) {
                    if (map[i][j] == symbol && map[i + 1][j + 1] == symbol) count++;
                    i++;
                }
                if (count >= DOTS_TO_WIN - 1) return true;
            }
        }
//        Проверяем дополнительные диагонали \ вниз
        for (int k = 1; k <= n; k++) {
            for (int i = k; i < SIZE - 1; ) {
                count = 0;
                for (int j = 0; j < SIZE - k - 1; j++) {
                    if (map[i][j] == symbol && map[i + 1][j + 1] == symbol) count++;
                    i++;
                }
                if (count >= DOTS_TO_WIN - 1) return true;
            }
        }

//       Проверка условия победы для поля 3х3 и трех фишек
//        int count, count1;
//        for (int i = 0; i < SIZE; i++ ) {
//            count=0;
//            count1=0;
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][j] == symbol) count++;
//                if (map[j][i]== symbol) count1++;
//            }
//            if (count == 3||count1==3) return true;
//        }
//        count=0;
//        count1=0;
//        for (int i=0; i < SIZE; i++) {
//            if (map[i][i] == symbol) count++;
//            if (map[i][SIZE-1-i] == symbol) count1++;
//        }
//        if (count==3||count1==3) return true;

//
//        if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
//        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
//        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;
//        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
//        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
//        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;
//        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
//        if (map[2][0] == symbol && map[1][1] == symbol && map[0][2] == symbol) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}