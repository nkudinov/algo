import java.util.Scanner;

public class T {

    static boolean canPlace(int leftRow, int leftCol, int[][] figure, int[][] board) {
        int figureRows = figure.length;
        int figureCols = figure[0].length;
        for (int r = 0; r < figureRows; r++) {
            for (int c = 0; c < figureCols; c++) {
                int val = figure[r][c];
                if (val == 0) {
                    continue;
                }
                /*
                 0 0
                 1 1
                 1 1 1 1
                 */
                int boardRow = r + leftRow;
                int boardCol = c + leftCol;
                if (Math.min(boardRow, boardCol) >= 0 && boardRow < board.length && boardCol < board[0].length) {
                    int boardVal = board[boardRow][boardCol];
                    if (boardVal == 1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    static void drop(int leftCol, int[][] figure, int[][] board) {
        int curRow = 0;
        while (canPlace(curRow, leftCol, figure, board)) {
            curRow++;
        }
        curRow--;
        place(curRow, leftCol, figure, board);
    }

    static private void place(int curRow, int leftCol, int[][] figure, int[][] board) {
        for (int r = 0; r < figure.length; r++) {
            for (int c = 0; c < figure[0].length; c++) {
                int val = figure[r][c];
                int boardRow = curRow + r;
                int boardCol = leftCol + c;
                board[boardRow][boardCol] = Math.max(board[boardRow][boardCol], val);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char op = '?';
        int[][] figure = new int[][]{{1, 1}, {1, 1}};
        int[][] board = new int[10][10];
        int leftCol = 0;
        while (op != 'x') {
            display(leftCol, board, figure);
            System.out.println("press x-exit, d- drop");
            op = scanner.nextLine().charAt(0);
            if (op == 'd') {
                drop(leftCol, figure, board);
            } else if (op == 'l') {
                leftCol--;
                if (leftCol < 0) {
                    leftCol = 0;
                }
            } else if (op == 'r') {
                leftCol++;
            }
        }
    }

    private static void display(int lefCol, int[][] board, int[][] figure) {
        for (int r = 0; r < board.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < board.length; c++) {
                int val = board[r][c];
                int figureCol = c - lefCol;
                if (r < figure.length && figureCol >= 0 && figureCol < figure[0].length) {
                    val = Math.max(val, figure[r][figureCol]);
                }
                sb.append(' ').append(val);
            }
            System.out.println(sb.toString());
        }
    }
}