import java.util.Random;

public class Bandit4 {
    static double[] trueProbability = new double[]{0.1, 0.9, 0.1, 0.3};
    static double[] guessProbability = new double[trueProbability.length];
    static double epsilon = 0.01;
    static Random rand = new Random();
    static int[] actions = new int[trueProbability.length];
    static int[] counts = new int[trueProbability.length];

    public static void main(String[] args) {
        for (int i = 0; i < 100000000; i++) {
            int action = 0;
            if (rand.nextDouble() <= epsilon) {
                action = rand.nextInt(actions.length);

            } else {
                action = takeBest(guessProbability);
            }
            counts[action]++;

            int reward = rand.nextDouble() <= trueProbability[action] ? 1 : 0;
            counts[action]++;
            // avg = (old*(n-1) + new)/n => old + (new-old)/n
            guessProbability[action] += (reward - guessProbability[action]) / counts[action];
        }
        for (double prob : guessProbability) {
            System.out.println("%.4f".formatted(prob));
        }
    }

    private static int takeBest(double[] guessProbability) {
        int bestCandidate = 0;
        for (int i = 1; i < guessProbability.length; i++) {
            if (guessProbability[i] > guessProbability[bestCandidate]) {
                bestCandidate = i;
            }
        }
        return bestCandidate;
    }
}
