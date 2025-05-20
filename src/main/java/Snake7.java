import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Snake7 {
    private static class Snake {
        private List<int[]> points;

        public Snake(int[] head) {
            points = new ArrayList<>();
            points.add(head);
        }

        public List<int[]> getPoints() {
            return new ArrayList<>(points);
        }

        public int[] getHead() {
            return points.getFirst();
        }

        public void addNewHead(int[] head) {
            points.add(0, head);
        }

        public void removeTail() {
            points.remove(points.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[10][10];
        Snake snake = new Snake(new int[]{0, 0});
        char op = '?';
        Scanner scanner = new Scanner(System.in);
        while (op != 'x') {
            display(board, snake);
            op = scanner.nextLine().charAt(0);
            move(board, snake, op);
        }
    }

    private static void move(int[][] board, Snake snake, char op) {
        int[] head = snake.getHead();
        int[] newHead = getNewHead(head, op);
        if (!isValid(board, newHead)) {
            return;
        }
        if (biteItself(snake, newHead)) {
            return;
        }
        snake.addNewHead(newHead);
        snake.removeTail();
    }

    private static boolean biteItself(Snake snake, int[] newHead) {
        for (int[] point : snake.getPoints()) {
            if (point[0] == newHead[0] && point[1] == newHead[1]) {
                return true;
            }
        }
        return false;
    }

    private static int[] getNewHead(int[] head, char op) {
        if (op == 'l') {
            return new int[]{head[0], head[1] + 1};
        } else if (op == 'r') {
            return new int[]{head[0], head[1] - 1};
        } else if (op == 'u') {
            return new int[]{head[0] - 1, head[1]};
        } else if (op == 'd') {
            return new int[]{head[0] + 1, head[1]};
        }
        return head;
    }

    private static boolean isValid(int[][] board, int[] point) {
        int r = point[0];
        int c = point[1];
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        return true;
    }

    private static void display(int[][] board, Snake snake) {
        char[][] display = new char[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            Arrays.fill(display[r], '.');
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 1) {
                    display[r][c] = 'x';
                }
            }
        }
        for (int[] point : snake.getPoints()) {
            int r = point[0];
            int c = point[1];
            display[r][c] = 's';
        }
        for (int r = 0; r < display.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < display[0].length; c++) {
                sb.append(' ').append(display[r][c]);
            }
            System.out.println(sb.toString());
        }
    }

}
