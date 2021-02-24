package l100;

public class q43 {
    public static boolean isMonotoneIncreasing(int n){
        int prev = n%10;
        n = n/10;
        while(n > 0){
            if (prev < n%10){
                return false;
            }
            prev = n%10;
            n = n/10;
        }
        return true;
    }
    public static int monotoneIncreasingDigits(int N) {
        for(int i = N ;i >=0; i--){
            if (isMonotoneIncreasing(i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(777616726));
    }
}
