package c5;

public class q5 {
    public static int  getOnes(int n){
        int ret = 0;
        while(n != 0){
           ret += n&0x1;
           n = n>>1;
        }
        return ret;
    }
    public static int getNum(int a,int b){
        // x1 x2 x3 x4 x5
        // y1 y2 y3 y3 y5
        return getOnes(a^b);
    }
    public static void main(String[] args) {
        System.out.println( getNum(31,14));
    }
}
