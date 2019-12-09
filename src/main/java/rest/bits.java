package rest;

public class bits {
    public static int numOne(int x){
        int ret =0;
        while(x!=0){
           ret += x & 1;
           x = x >> 1;
        }
        return ret;
    }
    public static void main(String[] args) {
        Integer y = -8;
        Integer x = y >>>3;
        System.out.println(  Integer.toBinaryString( x));
        System.out.println( x);
        System.out.println(  Integer.toBinaryString( -8 >>>1));
    }

}
