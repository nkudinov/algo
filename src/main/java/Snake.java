import java.util.*;

public class Snake {
    enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    private static final int BOARD_SIZE = 10;
    private static final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private static final List<int[]> snake = new ArrayList<>();
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        snake.add(new int[]{0, 0});
        char input = '?';
        placeObstacle();
        while (input != 'x') {
            System.out.println("Enter command: x - exit, l - left, r - right, u - up, d - down");
            displayBoard();
            input = scanner.nextLine().charAt(0);
            moveSnake(input);
        }
    }

    private static void placeObstacle() {
        int row, col;
        do {
            row = random.nextInt(BOARD_SIZE);
            col = random.nextInt(BOARD_SIZE);
        } while (board[row][col] == 1);
        board[row][col] = 1; // Mark obstacle
    }

    private static void moveSnake(char command) {
        Direction direction;
        switch (command) {
            case 'l': direction = Direction.LEFT; break;
            case 'r': direction = Direction.RIGHT; break;
            case 'u': direction = Direction.UP; break;
            case 'd': direction = Direction.DOWN; break;
            default: return;
        }
        move(direction);
    }

    private static void move(Direction direction) {
        int[] head = snake.get(0);
        int newRow = head[0], newCol = head[1];

        switch (direction) {
            case LEFT -> newCol--;
            case RIGHT -> newCol++;
            case UP -> newRow--;
            case DOWN -> newRow++;
        }

        if (isValidMove(newRow, newCol)) {
            snake.add(0, new int[]{newRow, newCol}); // Move head
            snake.remove(snake.size() - 1); // Remove tail
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == 0;
    }

    private static void displayBoard() {
        char[][] display = new char[BOARD_SIZE][BOARD_SIZE];
        for (int r = 0; r < BOARD_SIZE; r++) {
            Arrays.fill(display[r], '.');
        }

        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                if (board[r][c] == 1) {
                    display[r][c] = 'X';
                }
            }
        }

        for (int i = 0; i < snake.size(); i++) {
            int[] pos = snake.get(i);
            display[pos[0]][pos[1]] = (i == 0) ? 'H' : 'O';
        }

        for (char[] row : display) {
            System.out.println(new String(row));
        }
    }

}
