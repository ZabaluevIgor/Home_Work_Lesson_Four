package Lesson_4;


import java.util.Random;
import java.util.Scanner;
    public class Home_Work_Lesson4 {
        public static int SIZE = 3;
        public static final char DOT_EMPTY = '•';
        public static final char DOT_X = 'X';
        public static final char DOT_O = 'O';
        public static char[][] map;
        public static Scanner sc = new Scanner(System.in);
        public static Random rand = new Random();
        public static void main(String[] args) {

            initMap();
            printMap();
            while (true) {
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
                    System.out.println("Победил Искусственный Интеллект");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
            System.out.println("Конец игры. До новых встреч.");
            sc.close();                                                  // Не уверен, что сканер закрыт, поправьте меня, если не прав.
        }

        public static boolean checkWin(char symbol) {
            for (int i = 0; i < 3; i++)                                                         // Циклом for меняем переменную i от 0 до 2 (включительно)
                if ((map[i][0] == symbol && map[i][1] == symbol && map[i][2] == symbol) ||      //Подставляя значения переменной i мы перебираем координаты
                    (map[0][i] == symbol && map[1][i] == symbol && map[2][i] == symbol))        //ячеек и если в трех последовательных ячейках находим значение
                    return true;                                                                //DOT_X или DOT_O, то возвращаем true.
            return (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) ||
                    (map[2][0] == symbol && map[1][1] == symbol && map[0][2] == symbol);
        }

          public static boolean isMapFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) return false;
                }
            }
            return true;
        }
        public static void aiTurn() {
            int x, y;
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (isCellValid1(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
        public static void humanTurn() {
            int x, y;
            do {
                System.out.println("Введите координаты в формате X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (isCellValid1(x, y));
            map[y][x] = DOT_X;
        }
        public static boolean isCellValid1(int x, int y) {
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return true;
            return map[y][x] != DOT_EMPTY;
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
    }


