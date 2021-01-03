package l100;

import java.util.Random;

public class q5 {
    static double  sqrt(int n){
       double l = 1.0;
       double r = n;
       int i = 0;
       double delta = 0.000000001;
       while( l <= r){
           i++;
           double m = l + (r-l)/2;
           if ( m*m == n){
               return m;
           } else if ( m > n/m){
               r = m - delta;
           } else {
               l = m + delta;
           }
       }
       return l;
    }
    public static void main(String[] args) {
        int N =1000;
        Random rnd = new Random();
        for(int i = 0 ; i < N ;i++){
            int tmp = rnd.nextInt();
            if (tmp > 0){
                System.out.println(tmp+" " + Math.sqrt(tmp) + " "+sqrt(tmp));
            }

        }
    }

}
