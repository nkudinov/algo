package c5;

public class q1 {

    public static int updateBits(int n, int m ,int i,int j){
       int l = ~0 << j+1;
       int r =  1 << (i-1);
       int mask = l | r;
       System.out.println(Integer.toBinaryString(l));
       System.out.println(Integer.toBinaryString(r));
       System.out.println(Integer.toBinaryString(mask));
       return n & mask| (m << i);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt("1111111111111111111111111111111",2);
        int m = Integer.parseInt("0000000000000000000000000000000",2);
        System.out.println(Integer.toBinaryString(updateBits(n,m,0,3)));
    }

}
