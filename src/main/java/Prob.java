import java.util.Random;

public class Prob {



    public static void main(String[] args) {
        int[] doors1 = new int[3];
        int[] doors2 = new int[2];
        Random rand = new Random();
        int n = 100_000_000;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < n; i++) {
            doors1[0] = doors1[1] = doors1[2] = 0;
            int autoIndex = rand.nextInt(0,3);
            //[0,1,2]
            doors1[autoIndex] = 1;
            int guess1 = rand.nextInt(0,3);
            doors2[0] = doors2[1] = 0;
            if (doors1[0] == 1 ) {
                doors2[0] = 1;
            } else  {
                doors2[1] = 1;
            }
            int guess2 = rand.nextInt(0,2);

            if (doors1[guess1] == 1) {
                cnt1++;
            }
            if (doors2[guess2] == 1) {
                cnt2++;
            }
        }
        System.out.println("cnt1="+cnt1+", cnt2= " +cnt2);
    }
}
