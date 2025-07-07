import java.util.Random;

public class QLearningGridWorld {

    private static final int GRID_SIZE = 40;
    private static final int ACTIONS = 4; // up, down, left, right
    private static final int EPISODES = 50000;
    private static final int MAX_STEPS = 100;

    private static final double ALPHA = 0.1;    // learning rate
    private static final double GAMMA = 0.9;    // discount factor
    private static final double EPSILON = 0.1;  // exploration rate

    private static final int GOAL_X = 0;
    private static final int GOAL_Y = 0;

    // Q[stateX][stateY][action]
    private static double[][][] Q = new double[GRID_SIZE][GRID_SIZE][ACTIONS];
    private static Random rand = new Random();

    enum Action {
        UP, DOWN, LEFT, RIGHT
    }

    public static void main(String[] args) {
        // Обучение
        for (int episode = 0; episode < EPISODES; episode++) {
            int x = GRID_SIZE-1, y = GRID_SIZE-1;

            for (int step = 0; step < MAX_STEPS; step++) {
                Action action = chooseAction(x, y);

                int[] nextPos = move(x, y, action);
                int nextX = nextPos[0], nextY = nextPos[1];

                int reward = (nextX == GOAL_X && nextY == GOAL_Y) ? 10 : -1;

                // Q-learning update
                double maxQ = maxQ(nextX, nextY);
                Q[x][y][action.ordinal()] += ALPHA * (reward + GAMMA * maxQ - Q[x][y][action.ordinal()]);

                x = nextX;
                y = nextY;

                if (x == GOAL_X && y == GOAL_Y) break;
            }
        }

        // Тест после обучения: агент идёт по наилучшей стратегии
        System.out.println("\nТестовая траектория после обучения:");
        int x = GRID_SIZE-1, y = GRID_SIZE-1;
        int steps = 0;

        while (x != GOAL_X || y != GOAL_Y) {
            Action bestAction = bestAction(x, y);
            System.out.printf("(%d, %d) -> %s\n", x, y, bestAction);
            int[] pos = move(x, y, bestAction);
            x = pos[0];
            y = pos[1];
            steps++;
            if (steps > 50) break; // на случай зацикливания
        }
        System.out.printf("Достиг цели за %d шагов\n", steps);
    }

    // Выбор действия по ε-greedy
    private static Action chooseAction(int x, int y) {
        if (rand.nextDouble() < EPSILON) {
            return Action.values()[rand.nextInt(ACTIONS)];
        } else {
            return bestAction(x, y);
        }
    }

    private static Action bestAction(int x, int y) {
        double bestQ = Double.NEGATIVE_INFINITY;
        int bestIndex = 0;
        for (int i = 0; i < ACTIONS; i++) {
            if (Q[x][y][i] > bestQ) {
                bestQ = Q[x][y][i];
                bestIndex = i;
            }
        }
        return Action.values()[bestIndex];
    }

    private static double maxQ(int x, int y) {
        double max = Q[x][y][0];
        for (int i = 1; i < ACTIONS; i++) {
            if (Q[x][y][i] > max) {
                max = Q[x][y][i];
            }
        }
        return max;
    }

    // Переход агента
    private static int[] move(int x, int y, Action action) {
        switch (action) {
            case UP:    x = Math.max(0, x - 1); break;
            case DOWN:  x = Math.min(GRID_SIZE - 1, x + 1); break;
            case LEFT:  y = Math.max(0, y - 1); break;
            case RIGHT: y = Math.min(GRID_SIZE - 1, y + 1); break;
        }
        return new int[]{x, y};
    }
}
