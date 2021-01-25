package l100;

public class q18 {
    static public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 1;
        int r = x;
        while( l <= r){
            int m = l + (r-l)/2;
            System.out.println("["+l+", "+m+"=("+l+"+"+"("+r+"-"+l+")/2), "+r+"]"+ " x/m = " +x/m);
            if (m*m == x){
                return m;
            } else if ( m < (double)x/m){
                l = m + 1;
            } else {
                r = m - 1;
            }
            System.out.println("["+l+","+r+"]");
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
