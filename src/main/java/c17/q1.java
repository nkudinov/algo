package c17;

public class q1 {
    static  public void swap1(int a, int b){
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println(a);
        System.out.println(b);
    }
    static  public void swap2(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
    }
    public static void main(String[] args) {
      int a = 10;
      int b = 11;
      swap1(a,b);
      swap2(a,b);
    }
}
