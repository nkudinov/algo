package c7;

public class q4 {
    public static int negate(int a){
        int ret =0;
        int d = a > 0?-1:1;
        while( a !=0 ){
           ret += d;
           a  += d;
        }
        return ret;
    }
    public static int minus(int a, int b){
        return a + negate(b);
    }
    public static void main(String[] args) {
        System.out.println(negate(10));
        System.out.println(minus(1,10));
    }
}
