import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.util.Scanner;

public class Tetris {
    static boolean canPlace(int leftRow, int leftCol, int[][] figure, int[][] board) {

        return true;

    }
    static void place(int leftRow, int leftCol, int[][] figure, int[][] board) {



    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char op = '?';
        int[][] figure = new int[][]{{1, 1}, {1, 1}};
        int[][] board = new int[10][10];
        int col = 0;
        while (op != 'x') {
            display(col, figure, board);
            System.out.println("print: x-exit, l- left, r- right, d - drop:");
            op = scanner.nextLine().charAt(0);
            switch (op) {
                case 'x':
                    break;
                case 'l':
                    col = Math.max(0, col--);
                    break;
                case 'r':
                    col = Math.min(col+1, board[0].length - 1);
                    break;
                case 'd':
                    drop(col, figure, board);
            }
        }
    }

    private static void display(int col, int[][] figure, int[][] board) {
        for (int r = 0; r < board.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < board[0].length; c++) {
                sb.append(" ");
                int val = board[r][c];
                if (val == 1) {
                    sb.append('1');
                    continue;
                }
                int figureCol = c - col;
                if (r < figure.length && figureCol >= 0 && figureCol < figure[0].length) {
                    if (figure[r][figureCol] == 1) {
                        sb.append('1');
                        continue;
                    }
                }
                sb.append('0');
            }
            System.out.println(sb.toString());
        }
    }

    private static void drop(int col, int[][] figure, int[][] board) {
       int h = 0;
       while (canPlace(h, col, figure, board)) {
           h++;
       }
       h--;
       place(h, col, figure, board);
    }
}
