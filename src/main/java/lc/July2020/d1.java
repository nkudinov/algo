package lc.July2020;

public class d1 {
    static public int arrangeCoins(int n) {
      int level = 0;
      int cnt   = 0;
      while(n >= 0){
          cnt++;
          if ( n - cnt >= 0){
              level++;
          }
          n = n - cnt;
      }
      return level;
    }
    static public double Sn(int n){
        return (2+(n-1))/2.0*n;
    }
    static public int arrangeCoins2(int n) {
      int ret = 1;
      while(Sn(ret) <= n){
          ret++;
      }
      return ret-1;
    }
    public static void main(String[] args) {
        System.out.println(arrangeCoins2(8));
        System.out.println(arrangeCoins2(5));
    }
}
