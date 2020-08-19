package f;

public class q31 {
    public static int maxProfit(int[] p) {
        int b = 0;
        int delta = 0;
        for(int i = 1; i < p.length; i++){
            int curr = p[i];
            int prev = p[i-1];
            if (curr < prev){
                b = i;
            } else {
                System.out.println( curr - p[b] );
                if (p[i-1] - p[b] > delta){
                    delta = p[i-1] - p[b];
                    b = i-1;
                }
            }
        }
        return delta;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};

        System.out.println(maxProfit(arr));
    }

}
