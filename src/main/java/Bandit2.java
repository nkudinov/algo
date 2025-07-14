import java.util.Random;

public class Bandit2 {

    public static void main(String[] args) {
        double[] trueProbability = new double[]{0.1, 0.7, 0.1};
        double[] guessProbability = new double[3];
        int[] counts = new int[3];
        double epsilon = 0.01;
        Random rand = new Random();
        double decayRate = 0.9999999;
        for (int i = 0; i < 100000; i++) {
            int index;
            epsilon *= decayRate;
            if (rand.nextDouble() < epsilon) {
                index = rand.nextInt(3); // Explore
            } else {
                index = takeBest(guessProbability); // Exploit
            }

            int reward = rand.nextDouble() < trueProbability[index] ? 1 : 0;
            counts[index]++;
            guessProbability[index] = guessProbability[index] + (reward - guessProbability[index]) / counts[index];
        }

        for (double guess : guessProbability) {
            System.out.printf("%.4f\n", guess);
        }
    }

    private static int takeBest(double[] guessProbability) {
        int bestIndex = 0;
        for (int i = 1; i < guessProbability.length; i++) {
            if (guessProbability[i] > guessProbability[bestIndex]) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }
}
