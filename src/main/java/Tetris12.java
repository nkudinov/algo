import java.util.Arrays;
import java.util.Scanner;

public class Tetris12 {
    private static final int BOARD_ROWS = 10;
    private static final int BOARD_COLS = 10;
    private static final int FILLED = 1;
    private static final int EMPTY = 0;
    private static final int START_COLUMN = 0;

    private static final char EMPTY_CHAR = '.';
    private static final char LOCKED_BLOCK_CHAR = 'x';
    private static final char ACTIVE_BLOCK_CHAR = '0';
    private static final char EXIT_COMMAND = 'x';

    public static void main(String[] args) {
        int[][] board = new int[BOARD_ROWS][BOARD_COLS];
        int[][] figure = createFigure();
        int currentColumn = START_COLUMN;
        char command = EMPTY_CHAR;

        try (Scanner scanner = new Scanner(System.in)) {
            while (command != EXIT_COMMAND) {
                process(board);
                display(currentColumn, board, figure);

                command = scanner.next().charAt(0);
                currentColumn = applyCommand(command, currentColumn, figure, board);
            }
        }
    }

    private static int[][] createFigure() {
        return new int[][]{{FILLED, FILLED, FILLED, FILLED, FILLED}};
    }

    private static int applyCommand(char command, int currentColumn, int[][] figure, int[][] board) {
        return switch (command) {
            case 'l' -> moveLeft(currentColumn, figure, board);
            case 'r' -> moveRight(currentColumn, figure, board);
            case 'd' -> {
                dropFigure(currentColumn, figure, board);
                yield START_COLUMN;
            }
            default -> currentColumn;
        };
    }

    private static void process(int[][] board) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (!isRowFull(board[row])) {
                continue;
            }

            shiftRowsDownFrom(board, row);
            row++;
        }
    }

    private static boolean isRowFull(int[] row) {
        for (int cell : row) {
            if (cell != FILLED) {
                return false;
            }
        }
        return true;
    }

    private static void shiftRowsDownFrom(int[][] board, int fromRow) {
        for (int row = fromRow; row > 0; row--) {
            System.arraycopy(board[row - 1], 0, board[row], 0, board[0].length);
        }
        Arrays.fill(board[0], EMPTY);
    }

    private static void dropFigure(int currentColumn, int[][] figure, int[][] board) {
        int row = 0;
        while (canPlace(row, currentColumn, figure, board)) {
            row++;
        }
        place(row - 1, currentColumn, figure, board);
    }

    private static void place(int row, int col, int[][] figure, int[][] board) {
        for (int figureRow = 0; figureRow < figure.length; figureRow++) {
            for (int figureCol = 0; figureCol < figure[0].length; figureCol++) {
                if (figure[figureRow][figureCol] == EMPTY) {
                    continue;
                }
                board[row + figureRow][col + figureCol] = FILLED;
            }
        }
    }

    private static int moveRight(int currentColumn, int[][] figure, int[][] board) {
        if (currentColumn + figure[0].length > board[0].length
                || !canPlace(0, currentColumn + 1, figure, board)) {
            return currentColumn;
        }
        return currentColumn + 1;
    }

    private static int moveLeft(int currentColumn, int[][] figure, int[][] board) {
        if (currentColumn - 1 < 0 || !canPlace(0, currentColumn - 1, figure, board)) {
            return currentColumn;
        }
        return currentColumn - 1;
    }

    private static boolean canPlace(int row, int col, int[][] figure, int[][] board) {
        for (int figureRow = 0; figureRow < figure.length; figureRow++) {
            for (int figureCol = 0; figureCol < figure[0].length; figureCol++) {
                if (figure[figureRow][figureCol] == EMPTY) {
                    continue;
                }
                if (row + figureRow >= board.length || col + figureCol >= board[0].length) {
                    return false;
                }
                if (board[row + figureRow][col + figureCol] == FILLED) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(int currentColumn, int[][] board, int[][] figure) {
        char[][] screen = new char[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            Arrays.fill(screen[row], EMPTY_CHAR);
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == EMPTY) {
                    continue;
                }
                screen[row][col] = LOCKED_BLOCK_CHAR;
            }
        }

        for (int row = 0; row < figure.length; row++) {
            for (int col = 0; col < figure[0].length; col++) {
                if (figure[row][col] == EMPTY) {
                    continue;
                }
                screen[row][currentColumn + col] = ACTIVE_BLOCK_CHAR;
            }
        }

        for (int row = 0; row < screen.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < screen[0].length; col++) {
                sb.append(screen[row][col]).append(' ');
            }
            System.out.println(sb);
        }
    }
}
