package l100;

public class q61 {
    public static boolean hasAlternatingBits(int n) {
        System.out.println(Math.log10(n)/Math.log10(2.0));
        int N = (int)(Math.ceil(Math.log(n)));
        int prev = -1;
        int curr = -1;
        System.out.println(N);
        for( int i = 0 ;i <= N;i++){
            if (curr == -1){
                curr = n&1;
            } else {
                curr = (n>>i)&1;
                if (prev == curr){
                    return false;
                }
            }
            prev = curr;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(53));
        System.out.println(hasAlternatingBits((53)));
    }

}
