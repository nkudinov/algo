package f;

public class q33 {
    public static boolean isPalindrom(String s){
        int i = 0;
        int j = s.length()-1;
        while( i <= j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        if (isPalindrom(s)){
            return true;
        }
        while( i<=j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if ( ch1 != ch2 ){
                boolean l = isPalindrom(s.substring(i,j));
                boolean r = isPalindrom(s.substring(i+1,j+1));
                if (l || r){
                    return true;
                } else {
                   return false;
                }
            }
            i++;
            j--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("cxcaac"));
    }
}
