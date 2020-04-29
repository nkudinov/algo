package c17;

public class q4 {
    static public int sign(int x){
       //if x > 0 then 1 else 0
      return ~(x >> 31)&0x1;
    }
    static public int max(int a, int b){
       int k = sign(a-b);
       int q = sign(b-a);
       return a*k+b*q;
    }
    public static void main(String[] args) {
        System.out.println(max(11,10));
        System.out.println(max(1,10));
        System.out.println(max(-1,10));
    }

}
