package rest;

public class bits {
    public static int numOne(int x){
        int ret =0;
        while(x!=0){
           ret += x & 1;
           x = x>>1;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(numOne(3));
    }

}
