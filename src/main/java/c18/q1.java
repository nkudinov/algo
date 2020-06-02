package c18;

public class q1 {
    public static int add(int a, int b){
        int x = a^b;
        int y = a|b;
        return y<<x;
    }
    public static void main(String[] args) {
        System.out.println(add(1,0));
        System.out.println(add(0,1));
        System.out.println(add(1,1));
    }
}
