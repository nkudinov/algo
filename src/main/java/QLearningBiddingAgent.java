import java.util.*;
import java.util.stream.IntStream;

public class QLearningBiddingAgent {

    static final int TOTAL_MINUTES = 24 * 60 - 1;
    static final double TOTAL_BUDGET = 50000;
    static final double VALUE_PER_VIEW = 1.0;
    static final int NUM_EPISODES = 800;
    static final int N_BINS = 15;
    static final int ACTION_SIZE = 7;

    static final double[] HOURLY_FORECAST = {
            0.0067, 0.0042, 0.0035, 0.0055, 0.0141, 0.027, 0.0366, 0.0438, 0.046, 0.0535, 0.0523, 0.0514,
            0.0576, 0.0565, 0.0536, 0.0555, 0.0613, 0.0702, 0.0794, 0.0799, 0.0648, 0.0414, 0.0229, 0.0123
    };
    static final int N_OPPORTUNITIES = 1000 * 24 * 60;

    static final double[] ACTIONS = {-0.08, -0.03, -0.01, 0.0, 0.01, 0.03, 0.08};

    static final double ALPHA = 0.05;
    static final double GAMMA = 0.9;

    static double[][][] Q = new double[N_BINS][N_BINS][ACTION_SIZE];
    static Random rand = new Random(0);

    public static void main(String[] args) {
        trainAgent();
        runInference();
    }

    static double getTrafficPortion(int minute, boolean tillEnd) {
        int hour = minute / 60;
        if (!tillEnd) {
            return HOURLY_FORECAST[hour] / 60.0;
        } else {
            double remainingThisHour = HOURLY_FORECAST[hour] * (60 - (minute % 60)) / 60.0;
            double sumAfter = Arrays.stream(HOURLY_FORECAST, hour + 1, HOURLY_FORECAST.length).sum();
            return remainingThisHour + sumAfter;
        }
    }

    static int[] simulateMinute(double bid, int minute) {
        double viewsPer100 = Math.pow((bid * 100 / 12 / 5), 4);
        double trafficPortion = getTrafficPortion(minute, false);
        int views = (int) Math.round(N_OPPORTUNITIES * trafficPortion * viewsPer100 / 100);
        double spent = views * bid * 0.95;
        return new int[]{views, (int) spent};
    }

    static int discretize(double ratio) {
        ratio = Math.min(1.0 - 1e-5, Math.max(0, ratio));
        return (int) Math.floor(ratio * N_BINS);
    }

    static int[] getState(double budgetLeft, int minute) {
        double timePassed = minute / (double) TOTAL_MINUTES;
        double budgetSpent = 1 - budgetLeft / TOTAL_BUDGET;
        return new int[]{discretize(timePassed), discretize(budgetSpent)};
    }

    static int chooseAction(int[] state, int episode, boolean isTrain) {
        double epsilon = Math.max(0.1, 0.5 / (1 + 0.05 * episode));
        if (isTrain && rand.nextDouble() < epsilon) {
            return rand.nextInt(ACTION_SIZE);
        }
        double[] qRow = Q[state[0]][state[1]];
        return argMax(qRow);
    }

    static double computeReward(int views, double spent, int minute, double budgetLeft) {
        double opportunitiesArrived = 1 - getTrafficPortion(minute + 1, true);
        double budgetSpent = 1 - budgetLeft / TOTAL_BUDGET;
        double error = Math.abs(budgetSpent - opportunitiesArrived);
        return -Math.pow(error, 4);
    }

    static void trainAgent() {
        for (int episode = 0; episode < NUM_EPISODES; episode++) {
            double lambda = 1.0;
            double budgetLeft = TOTAL_BUDGET;

            for (int minute = 1; minute < TOTAL_MINUTES; minute++) {
                if (budgetLeft <= 0) break;

                int[] state = getState(budgetLeft, minute);
                int actionIndex = chooseAction(state, episode, true);
                double action = ACTIONS[actionIndex];

                lambda *= (1 + action);
                lambda = Math.max(0.1, Math.min(lambda, 10.0));

                double bid = VALUE_PER_VIEW / lambda;
                int[] result = simulateMinute(bid, minute);
                int views = result[0];
                double spent = result[1];

                budgetLeft = Math.max(0, budgetLeft - spent);

                double reward = computeReward(views, spent, minute, budgetLeft);
                int[] nextState = getState(budgetLeft, minute + 1);

                double bestNext = Arrays.stream(Q[nextState[0]][nextState[1]]).max().getAsDouble();
                double currentAlpha = ALPHA * (1 - (double) episode / NUM_EPISODES);

                Q[state[0]][state[1]][actionIndex] += currentAlpha * (reward + GAMMA * bestNext - Q[state[0]][state[1]][actionIndex]);
            }

            if (episode % 100 == 0) {
                System.out.println("Episode: " + episode);
            }
        }
        System.out.println("Training complete.");
    }

    static void runInference() {
        double lambda = 1.0;
        double budgetLeft = TOTAL_BUDGET;

        List<Double> overspent = new ArrayList<>();
        overspent.add(lambda);

        for (int minute = 1; minute < TOTAL_MINUTES; minute++) {
            if (budgetLeft <= 0) break;

            int[] state = getState(budgetLeft, minute);
            int actionIndex = chooseAction(state, -1, false);
            double action = ACTIONS[actionIndex];

            lambda *= (1 + action);
            lambda = Math.max(0.1, Math.min(lambda, 10.0));
            overspent.add(lambda);

            double bid = VALUE_PER_VIEW / lambda;
            int[] result = simulateMinute(bid, minute);
            double spent = result[1];

            budgetLeft = Math.max(0, budgetLeft - spent);
        }

        System.out.println("Inference complete. Final lambda: " + lambda);
        System.out.printf("Remaining budget: %.2f\n", budgetLeft);
    }

    static int argMax(double[] array) {
        double maxVal = Double.NEGATIVE_INFINITY;
        int maxIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}