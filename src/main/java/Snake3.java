import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Snake3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0,0});
        int[][] board = new int[10][10];
        placeObstacles(board, snake);
        char op = '?';
        while(op !='x') {
            displayBoardAndSnake(board, snake);
            System.out.println("press , x - exit, l - left, r - right, d - down, u - up:");
            op = scanner.nextLine().charAt(0);
            moveSnakeOneStep(snake, board, op);
        }
    }

    private static void moveSnakeOneStep(List<int[]> snake, int[][] board, char op) {
    }

    private static void displayBoardAndSnake(int[][] board, List<int[]> snake) {
        
    }

    private static void placeObstacles(int[][] board, List<int[]> snake) {
        Random random  = new Random();
        int row = random.nextInt(0, board.length);
        int col  =-1;
        while (row <0 || row > board.length || col <0 || col > board[0].length ) {
            row = random.nextInt();
        }
    }


}
