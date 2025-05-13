import java.util.*;

public class Snake6 {


    static final int ROWS = 20;
    static final int COLS = 20;
    static final char SNAKE_HEAD = 'H';
    static final char SNAKE_BODY = 'o';
    static final char FOOD = '*';
    static final char EMPTY = '.';

    static class Snake {
        private final LinkedList<int[]> body = new LinkedList<>();

        public Snake() {
            body.add(new int[]{ROWS / 2, COLS / 2}); // Start in center
        }

        public int[] getHead() {
            return body.getFirst();
        }

        public List<int[]> getBody() {
            return body;
        }

        public void move(int[] newHead, boolean grow) {
            body.addFirst(newHead);
            if (!grow) {
                body.removeLast(); // Remove tail unless eating
            }
        }

        public boolean occupies(int r, int c) {
            for (int[] part : body) {
                if (part[0] == r && part[1] == c) return true;
            }
            return false;
        }

        public boolean collides(int[] pos) {
            for (int i = 1; i < body.size(); i++) {
                int[] part = body.get(i);
                if (Arrays.equals(part, pos)) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Snake snake = new Snake();
        int[] food = spawnFood(snake);
        Scanner scanner = new Scanner(System.in);
        char direction = 'r';

        while (true) {
            displayBoard(snake, food);

            System.out.println("Enter direction (w=up, s=down, a=left, d=right, x=exit):");
            String input = scanner.nextLine().toLowerCase();
            if (!input.isEmpty()) {
                char newDir = input.charAt(0);
                if ("wasdx".indexOf(newDir) != -1) direction = newDir;
            }
            if (direction == 'x') break;

            int[] newHead = getNextHead(snake.getHead(), direction);
            if (newHead == null || isOutOfBounds(newHead) || snake.collides(newHead)) {
                System.out.println("Game Over! Collision detected.");
                break;
            }

            boolean eat = Arrays.equals(newHead, food);
            snake.move(newHead, eat);
            if (eat) food = spawnFood(snake);
        }

        System.out.println("Final Length: " + snake.getBody().size());
    }

    private static int[] getNextHead(int[] head, char dir) {
        int r = head[0], c = head[1];
        return switch (dir) {
            case 'w' -> new int[]{r - 1, c};
            case 's' -> new int[]{r + 1, c};
            case 'a' -> new int[]{r, c - 1};
            case 'd' -> new int[]{r, c + 1};
            default -> null;
        };
    }

    private static boolean isOutOfBounds(int[] pos) {
        return pos[0] < 0 || pos[0] >= ROWS || pos[1] < 0 || pos[1] >= COLS;
    }

    private static int[] spawnFood(Snake snake) {
        Random rand = new Random();
        int r, c;
        do {
            r = rand.nextInt(ROWS);
            c = rand.nextInt(COLS);
        } while (snake.occupies(r, c));
        return new int[]{r, c};
    }

    private static void displayBoard(Snake snake, int[] food) {
        char[][] board = new char[ROWS][COLS];
        for (char[] row : board) Arrays.fill(row, EMPTY);

        for (int i = 0; i < snake.getBody().size(); i++) {
            int[] part = snake.getBody().get(i);
            board[part[0]][part[1]] = (i == 0) ? SNAKE_HEAD : SNAKE_BODY;
        }

        board[food[0]][food[1]] = FOOD;

        for (char[] row : board) {
            for (char cell : row) System.out.print(" " + cell);
            System.out.println();
        }
        System.out.println();
    }
}
