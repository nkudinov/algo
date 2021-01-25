package l100;

public class q21 {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while( i < j ){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if  (!(ch1 >= '0' && ch1 <='z')){
                i++;
                continue;
            }
            if  (!(ch2 >= '0' && ch2 <='z')){
                j--;
                continue;
            }
            if (ch1 != ch2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
