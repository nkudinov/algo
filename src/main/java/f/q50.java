package f;

public class q50 {
    static public String  findPalindrom(String s, int i, int j){
        String ret = "";
        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            ret = s.substring(i,j+1);
            i--;
            j++;
        }
        return ret;
    }
    static public String longestPalindrome(String s) {
       String ret = "";
       for(int i = 0; i < s.length();i++){
           String p1 = findPalindrom(s,i,i);
           String p2 = findPalindrom(s,i,i+1);
           if (ret.length() < p1.length()){
               ret = p1;
           }
           if (ret.length() < p2.length()){
               ret = p2;
           }
       }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
