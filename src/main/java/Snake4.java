import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Snake4 {

    public static final int COLS = 10;
    public static final int ROWS = 10;

    public static void main(String[] args) {
        int[][] board = new int[ROWS][COLS];
        placeObstacles(board, 3);
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0, 0});
        char op = '?';
        Scanner scanner = new Scanner(System.in);
        while (op != 'x') {
            display(board, snake);
            System.out.println("enter, x = exit, l = left, r = right, u = up, d = down:");
            op = scanner.nextLine().charAt(0);
            if (op == 'x') {
                break;
            } else {
                moveSnake(board, snake, op);
            }
        }
    }

    public static void display(int[][] board, List<int[]> snake) {
        int rows = board.length;
        int cols = board[0].length;
        char[][] disp = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    disp[i][j] = 'O';
                } else {
                    disp[i][j] = '.';
                }
            }
        }
        for (int[] part : snake) {
            disp[part[0]][part[1]] = 's';
        }
        for (int r = 0; r < rows; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                sb.append(disp[r][c]);
            }
            System.out.println(sb.toString());
        }
    }

    static boolean isValid(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    static void moveSnake(int[][] board, List<int[]> snake, char op) {
        int len = snake.size();
        int[] head = snake.get(len - 1);
        int newRow = head[0];
        int newCol = head[1];
        if (op =='l') {
            newCol--;
        } else if (op == 'r') {
            newCol++;
        } else if (op =='u') {
            newRow--;
        } else {
            newRow++;
        }
        if (isValid(board, newRow, newCol)) {
            if (board[newRow][newCol] == 0) {
                snake.remove(0);
            } else {
                board[newRow][newCol] = 0;
            }
            snake.add(new int[]{newRow, newCol});

        }
    }

    private static void placeObstacles(int[][] board, int count) {
        Random random = new Random();
        int rows = board.length;
        int cols = board[0].length;

        while (count > 0) {
            int row = random.nextInt(1, rows); // avoid 0th row
            int col = random.nextInt(1, cols); // avoid 0th col

            if (board[row][col] == 0) {
                board[row][col] = 1; // place obstacle
                count--;
            }
        }
    }
}
