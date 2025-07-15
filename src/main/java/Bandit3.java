import java.util.Random;

public class Bandit3 {
    public static void main(String[] args) {
        double[] trueProbability = new double[]{0.1, 0.3, 0.1};
        double[] guessProbability = new double[3];
        int[] counts = new int[3];
        double epsilon = 0.01;
        Random rand = new Random();
        for (int i = 0; i < 100000; i++) {
            int index = 0;
            if (rand.nextDouble() < epsilon) {
                index = rand.nextInt(3);
            } else {
                index = takeBest(guessProbability);
            }
            counts[index]++;
            // ((n-1)*old + r)/n =>old + (r-old)/n
            int reward = rand.nextDouble() <= trueProbability[index] ? 1 : 0;
            guessProbability[index] += (reward - guessProbability[index]) / counts[index];
        }
        for(double guess : guessProbability) {
            System.out.printf("%.4f\n", guess);
        }
    }

    private static int takeBest(double[] trueProbability) {
        int bestIndex = 0;
        for (int i = 0; i < trueProbability.length; i++) {
            if (trueProbability[i] > trueProbability[bestIndex]) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }
}
