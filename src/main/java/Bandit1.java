import java.util.Random;

public class Bandit1 {
    static final int ARMS = 5;
    static double[] trueRewards = {0.1, 0.5, 0.9, 0.1, 0.1};
    static double[] qValues = new double[ARMS];
    static int[] counts = new int[ARMS];
    static double epsilon = 0.1;
    static Random rand = new Random();


    public static void main(String[] args) {
        for (int i = 0; i < 100000000; i++) {
            int action = 0;
            if (rand.nextDouble() < epsilon) {
                action = rand.nextInt(ARMS);
            } else {
                action = bestChoise(qValues);
            }
            double reward = rand.nextDouble() <= trueRewards[action] ? 1.0 : 0.0;
            counts[action]++;
            // avg = ((n-1)*old + reward)/n
            // n*old - old + reward

            qValues[action] = qValues[action] + (reward - qValues[action]) / counts[action];
        }
        for (double f : qValues) {
            System.out.println("%f".formatted(f));
        }
    }

    private static int bestChoise(double[] qValues) {
        int bestIndex = 0;
        for (int i = 1; i < qValues.length; i++) {
            if (qValues[i] > qValues[bestIndex]) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }


}
