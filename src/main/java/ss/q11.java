package ss;

import java.util.Arrays;

public class q11 {
    public static int maxScore(String s) {
        //011101
        //111122
        //443211
        // [0, 0, 0, 0, 1, 0]
        //[0, 3, 2, 1, 0, 0]
        int N = s.length();
        int[] z = new int[N];
        for(int i = 0; i < N; i++){
            char ch = s.charAt(i);
            if (ch=='0'){
                z[i]= ( (i==0)? 0:z[i-1]) + 1;
            }
        }
        int[] o = new int[N];
        for(int i = N-1; i >= 0; i--){
            char ch = s.charAt(i);

                o[i]= ((i==N-1)?0:o[i+1]) + 1;

        }
        int ans = 0;
        System.out.println(Arrays.toString(z));
        System.out.println(Arrays.toString(o));
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, z[i] + o[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }

}
