import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Sanke5 {
    public static void main(String[] args) {

        int[][] board = new int[20][20];
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0, 0});
        char op = '?';
        Scanner scanner = new Scanner(System.in);
        placeSomeObstacles(board, snake);
        while (op != 'x') {
            displaySnakeAndBoard(board, snake);
            System.out.println("Please enter, x - exit, u - up, d - dow, l - left, r - right:");
            op = scanner.nextLine().charAt(0);
            if (op == 'l') {
                moveLeft(board, snake);
            } else if (op == 'r') {
                moreRight(board, snake);
            }
        }

    }

    private static void moreRight(int[][] board, List<int[]> snake) {
        int[] head = snake.get(0);
        int newRow = head[0];
        int newCol = head[1]+1;
        if (newCol > board[0].length -1) {
            return;
        }
        for(int[] part:snake) {
            if (part[0] == newRow && part[1] == newCol) {
                return;
            }
        }
        if (board[newRow][newCol] == 0) {
            snake.remove(0);
        }
        snake.add(0, new int[]{newRow, newCol});
    }

    private static void moveLeft(int[][] board, List<int[]> snake) {
        int[] head = snake.get(0);
        int newRow = head[0] - 1;
        int newCol = head[1];
        if (newRow < 0) {
            return;
        }
        if (board[newRow][newCol] == 0) {
            snake.remove(snake.size() - 1);
        }
        snake.add(0, new int[]{newRow, newCol});
    }

    private static void placeSomeObstacles(int[][] board, List<int[]> snake) {
        Random random = new Random();
        int cnt = 3;
        while (cnt > 0) {
            int r = random.nextInt(0, board.length);
            int c = random.nextInt(0, board[0].length);
            for (int[] part : snake) {
                if (r == part[0] && c == part[1]) {
                    continue;
                }
                board[r][c] = 1;
                cnt--;
            }
        }
    }

    public static void displaySnakeAndBoard(int[][] board, List<int[]> snake) {
        char[][] display = new char[board.length][board[0].length];
        for (int[] part : snake) {
            int row = part[0];
            int col = part[1];
            display[row][col] = 's';
        }
        for (int r = 0; r < board.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < board[0].length; c++) {
                if (display[r][c] != 's') {
                    display[r][c] = board[r][c] == 1 ? 'O' : '.';
                }
                sb.append(display[r][c]);
            }
            System.out.println(sb.toString());
        }
    }
}
