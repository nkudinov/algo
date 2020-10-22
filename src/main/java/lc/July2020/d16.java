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
    static public double myPow2(double x, int n) {
        int N = n;
        if ( n > 0 ){
            N = -N;
        }
        double ans = 1.0;
        while ( N < 0 ){
            int count = 1;
            double temp = x;
            while ( -count > Integer.MIN_VALUE/2 && -count * 2 >= N){
                temp = temp * temp;
                count = count * 2;
            }
            N += count;
            ans = ans *temp;
        }
        if ( n < 0 ) {
            return 1/ans;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(myPow2(2,-2147483648));
        Integer.valueOf(1).compareTo()
//     System.out.println(myPow(2.00000,-2147483648));
    }
}
