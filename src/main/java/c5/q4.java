package c5;

public class q4 {
    public static boolean isPowerOfTwo(int n){
        //x y 1 0 0
        //x y 0 1 1
        return (n&(n-1))==0;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2*2));
        System.out.println(isPowerOfTwo(2*3));
    }
}
