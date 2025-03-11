import java.util.Scanner;

public class Tetris {
    boolean canPlace(int leftRow, int leftCol, int[][] figure, int[][] board) {
        /*

         */

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char op = '?';
        int[][] figure = new int[][]{{1, 1}, {1, 1}};
        int[][] board = new int[10][10];
        int row = 0;
        while (op != 'x') {
            display(row, figure, board);
            System.out.println("print: x-exit, l- left, r- right, d - drop:");
            op = scanner.nextLine().charAt(0);
            switch (op) {
                case 'x':
                    break;
                case 'l':
                    row = Math.max(0, row--);
                    break;
                case 'r':
                    row = Math.min(row++, board.length-1);
                    break;
                case 'd':
                    drop(row, figure, board);
            }
        }
    }

    private static void display(int row, int[][] figure, int[][] board) {

    }

    private static void drop() {
        drop(row, figure, board);
    }
}
