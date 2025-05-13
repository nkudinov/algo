import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Snake6 {


    static class Snake {
        private final List<int[]> body;

        public Snake() {
            this.body = new ArrayList<>();
            body.add(new int[]{0, 0});
        }

        public int[] getHead() {
            return body.getFirst();
        }

        public List<int[]> getPoints() {
            return body;
        }
        public List<int[]> getTail(){
            return body.subList(1, body.size());
        }

        public void setNewHead(int[] h) {
            body.set(0, h);
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[20][20];
        Snake snake = new Snake();
        char op = '?';
        Scanner scanner = new Scanner(System.in);
        while (op != 'x') {
            display(board, snake);
            System.out.println(" enter , x - exit, l - left, r - right:");
            op = scanner.nextLine().charAt(0);
            switch (op) {
                case 'r' -> moveRight(board, snake);
                case 'l' -> moveLeft(board, snake);
                case 'd' -> moveDown(board, snake);
                case 'u' -> moveUp(board, snake);
            }
        }
    }

    private static void moveUp(int[][] board, Snake snake) {
        int[] h = snake.getHead();
        h[0]--;
        if (isNewHeadValid(h, snake)) {
            snake.setNewHead(h);
        }
    }

    private static void moveDown(int[][] board, Snake snake) {
        int[] h = snake.getHead();
        h[0]++;
        if (isNewHeadValid(h, snake)) {
            snake.setNewHead(h);
        }
    }

    private static void moveLeft(int[][] board, Snake snake) {
        int[] h = snake.getHead();
        h[1]--;
        if (isNewHeadValid(h, snake)) {
            snake.setNewHead(h);
        }
    }

    private static void moveRight(int[][] board, Snake snake) {
        int[] h = snake.getHead();
        h[1]++;
        if (isNewHeadValid(h, snake)) {
            snake.setNewHead(h);
        }
    }

    private static boolean isNewHeadValid(int[] h, Snake snake) {
        if (h[1] < 0  || h[0] < 0 ) {
            return false;
        }
        for(int[] tail:snake.getTail()) {
            if (h[0] == tail[0] && h[1] == tail[1]) {
                return false;
            }
        }
        return true;
    }

    private static void display(int[][] board, Snake snake) {
        char[][] display = new char[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            Arrays.fill(display[r], '.');
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0) {
                    continue;
                }
                display[r][c] = 'o';
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
