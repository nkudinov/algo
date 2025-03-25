import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake2 {
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void main(String[] args) {
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0, 0});
        Scanner scanner = new Scanner(System.in);
        char op = '?';
        int[][] board = new int[10][10];
        board[2][2] = 1;
        displayBoard(board, snake);
        while (op != 'x') {
            System.out.println("enter x - exit, l - left, r - right, d-down, u-up:");
            op = scanner.nextLine().charAt(0);
            moveSnake(board, snake, op);
            displayBoard(board, snake);
        }
    }

    static void displayBoard(int[][] board, List<int[]> snake) {
        char[][] display = new char[10][10];
        for(int r = 0; r < board.length;r++) {
            for(int c = 0; c < board[0].length;c++) {
                if (board[r][c] ==0) {
                    display[r][c] = '.';
                } else {
                    display[r][c] = 'X';
                }
            }
        }
        for(int[] part:snake) {
            display[part[0]][part[1]] = 's';
        }
        for(int r = 0; r < display.length; r++) {
            StringBuilder sb = new StringBuilder();
            for(int c = 0; c < display[0].length;c++) {
                sb.append(display[r][c]);
            }
            System.out.println(sb.toString());
        }
    }

    static boolean isValid(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        return true;
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
}
