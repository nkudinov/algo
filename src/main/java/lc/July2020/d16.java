package lc.July2020;

public class d16 {
   static public double myPow(double x, int n) {
      double ret = 1;
      if (n == 0 || x==1){
          return ret;
      } else if (n > 0){
          double delta = ret;
          double prev;
          for(int i = 1; i <= n; i++){
              prev = ret;
              ret *= x;
              delta = Math.abs(ret - prev);

              if (delta <=0.00000001){
                  break;
              }

          }
      } else {
           if (n == Integer.MIN_VALUE){
               return 1 / myPow(x, Integer.MAX_VALUE);
           } else {
               return 1 / myPow(x, -1 * n);
           }
      }
      return ret;
    }
    public static void main(String[] args) {


        System.out.println(myPow(2.00000,-2147483648));
    }
}
