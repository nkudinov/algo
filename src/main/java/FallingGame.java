import java.util.Random;
import java.util.Scanner;
public class FallingGame {

    // Игровое поле
    static int[][] pit = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1}
    };

    // Фигура
    static int[][] fig = {
            {1, 1},
            {1, 0}
    };
    static Random random = new Random();
    static int x = 2; // Начальная позиция фигуры (столбец)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;

        System.out.println("Игра началась! Используйте 'l' для движения влево, 'r' для движения вправо, 'd' чтобы отпустить.");
        while (isPlaying) {
            printPit(); // Отображаем игровое поле
            System.out.print("Введите команду (l/r/d): ");
            char command = scanner.next().charAt(0);

            switch (command) {
                case 'l':
                    moveLeft();
                    break;
                case 'r':
                    moveRight();
                    break;
                case 'd':
                    dropFigure();
                    //isPlaying = false; // Игра заканчивается, когда фигура отпущена
                    fig = getNextFig();
                    break;
                default:
                    System.out.println("Неверная команда! Пожалуйста, используйте 'a', 'd' или 's'.");
            }
        }
        System.out.println("Игра окончена! Итоговое состояние поля:");
        printPit();
    }

    // Метод для отображения игрового поля
    static void printPit() {
        int[][] preview = new int[pit.length][pit[0].length];

        for(int r = 0; r < fig.length; r++) {
            StringBuilder sb = new StringBuilder();
            for(int c = 0; c < pit[0].length; c++) {
                if ( (c < x) || (c >= x + fig[0].length) ) {
                    sb.append("  ");
                } else {
                    sb.append(fig[r][c-x]+" ");
                }
            }
            System.out.println(sb.toString());
        }
        // Копируем текущее состояние поля
        for (int i = 0; i < pit.length; i++) {
            for (int j = 0; j < pit[0].length; j++) {
                preview[i][j] = pit[i][j];
            }
        }

//        // Временно добавляем фигуру в поле для отображения
//        for (int r = 0; r < fig.length; r++) {
//            for (int c = 0; c < fig[0].length; c++) {
//                int row = r;
//                int col = x + c;
//                if (row < pit.length && col < pit[0].length && fig[r][c] == 1) {
//                    preview[row][col] = 1;
//                }
//            }
//        }

        // Печатаем поле
        for (int[] row : preview) {
            for (int cell : row) {
                System.out.print(cell + " " );
            }
            System.out.println();
        }
        System.out.println();
    }
    static int[][]  getNextFig(){
        int[][] res = new int[fig.length][fig[0].length];
        for(int r = 0; r < fig.length;r++) {
            for(int c = 0; c < fig[0].length; c++) {
                res[r][c] = random.nextInt(0,2);
            }
        }
        return res;
    }
    // Движение фигуры влево
    static void moveLeft() {
        if (x > 0) {
            x--;
        } else {
            System.out.println("Движение влево невозможно.");
        }
    }

    // Движение фигуры вправо
    static void moveRight() {
        if (x + fig[0].length < pit[0].length) {
            x++;
        } else {
            System.out.println("Движение вправо невозможно.");
        }
    }

    // Отпускание фигуры
    static void dropFigure() {
        int y = 0;

        // Найти максимальную высоту, на которую фигура может упасть
        while (canPlace(fig, pit, x, y)) {
            y++;
        }
        y--; // Откат на последний корректный уровень

        // "Приземлить" фигуру на поле
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 1) {
                    pit[y + r][x + c] = 1;
                }
            }
        }
    }

    // Проверка возможности размещения фигуры
    static boolean canPlace(int[][] fig, int[][] pit, int x, int y) {
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                int pitRow = y + r;
                int pitCol = x + c;

                // Проверяем границы
                if (pitRow >= pit.length || pitCol >= pit[0].length || pitRow < 0 || pitCol < 0) {
                    return false;
                }

                // Проверяем пересечение
                if (fig[r][c] == 1 && pit[pitRow][pitCol] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}