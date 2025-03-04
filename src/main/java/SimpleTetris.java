import java.util.Random;
import java.util.Scanner;

public class SimpleTetris {
    private static final int BOARD_ROWS = 10;
    private static final int BOARD_COLS = 10;
    private static final char EMPTY = '.';
    private static final char BLOCK = 'O';
    private static final char FILLED = 'X';

    public static char[][] initializeBoard() {
        char[][] board = new char[BOARD_ROWS][BOARD_COLS];
        Random rand = new Random();

        // Fill the board with empty spaces
        for (int r = 0; r < BOARD_ROWS; r++) {
            for (int c = 0; c < BOARD_COLS; c++) {
                board[r][c] = EMPTY;
            }
        }

        // Add random blocks at the bottom 3 rows
        for (int r = BOARD_ROWS - 3; r < BOARD_ROWS; r++) {
            for (int c = 0; c < BOARD_COLS; c++) {
                if (rand.nextBoolean()) {
                    board[r][c] = FILLED;
                }
            }
        }
        return board;
    }

    public static boolean canPlacePiece(int[][] piece, char[][] board, int row, int col) {
        for (int r = 0; r < piece.length; r++) {
            for (int c = 0; c < piece[0].length; c++) {
                if (piece[r][c] == 1) {
                    int newRow = row + r;
                    int newCol = col + c;

                    if (newRow >= BOARD_ROWS || newCol < 0 || newCol >= BOARD_COLS || board[newRow][newCol] != EMPTY) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void placePiece(int[][] piece, char[][] board, int row, int col) {
        for (int r = 0; r < piece.length; r++) {
            for (int c = 0; c < piece[0].length; c++) {
                if (piece[r][c] == 1) {
                    board[row + r][col + c] = BLOCK;
                }
            }
        }
    }

    public static int findLandingRow(int[][] piece, char[][] board, int row, int col) {
        while (canPlacePiece(piece, board, row + 1, col)) {
            row++;
        }
        return row;
    }

    public static int movePiece(int[][] piece, char[][] board, int row, int col, int direction) {
        int newCol = col + direction;
        return canPlacePiece(piece, board, row, newCol) ? newCol : col;
    }

    public static void printBoard(char[][] board, int[][] piece, int row, int col) {
        char[][] tempBoard = new char[BOARD_ROWS][BOARD_COLS];

        // Copy board state
        for (int r = 0; r < BOARD_ROWS; r++) {
            System.arraycopy(board[r], 0, tempBoard[r], 0, BOARD_COLS);
        }

        // Add the current piece
        for (int r = 0; r < piece.length; r++) {
            for (int c = 0; c < piece[0].length; c++) {
                if (piece[r][c] == 1) {
                    tempBoard[row + r][col + c] = BLOCK;
                }
            }
        }

        // Print board
        System.out.println("\nTETRIS BOARD:");
        for (char[] rowArr : tempBoard) {
            for (char cell : rowArr) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkGameOver(int[][] piece, char[][] board) {
        return !canPlacePiece(piece, board, 0, BOARD_COLS / 2);
    }

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        char[][] board = initializeBoard();
        int[][] piece = { {1, 1}, {1, 1} }; // Simple 2x2 square piece
        int row = 0, col = BOARD_COLS / 2;

        while (true) {
            if (checkGameOver(piece, board)) {
                printBoard(board, piece, row, col);
                System.out.println("Game Over!");
                break;
            }

            printBoard(board, piece, row, col);
            System.out.println("\nControls: [A] Move Left | [D] Move Right | [Space] Drop");
            System.out.print("Enter move: ");
            String move = scanner.nextLine().toUpperCase();

            switch (move) {
                case "A":
                    col = movePiece(piece, board, row, col, -1);
                    break;
                case "D":
                    col = movePiece(piece, board, row, col, 1);
                    break;
                case " ":
                    row = findLandingRow(piece, board, row, col);
                    placePiece(piece, board, row, col);
                    row = 0;
                    col = BOARD_COLS / 2;
                    break;
                default:
                    System.out.println("Invalid move! Use A, D, or Space.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        runGame();
    }
}
