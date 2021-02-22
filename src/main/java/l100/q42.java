package l100;

public class q42 {
    static boolean f(String s, int i, int j){
        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);
        if (ch1 == ch2){
            return false;
        }
        while(i < j){
            if (s.charAt(i) != ch1 || s.charAt(j) != ch2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int countBinarySubstrings(String s) {
        int cnt = 0;
        int N = s.length();
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if ( (i - j +1 )%2==0 && f(s, i, j) ) {
                    cnt++;
                }
            }

        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(f("0011",0,1));
    }

}
