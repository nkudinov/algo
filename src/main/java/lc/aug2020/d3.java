package lc.aug2020;

public class d3 {
    public static boolean isPalindrome1(String s) {
       StringBuilder sb = new StringBuilder();
       for(Character ch:s.toCharArray()){
           if (Character.isAlphabetic(ch) || Character.isDigit(ch)){
               sb.append(Character.toLowerCase(ch));
           }
       }
       return sb.toString().equals(sb.reverse().toString());
    }
    static public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while( i <= j ){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if( !(Character.isDigit(ch1) || Character.isAlphabetic(ch1))){
                i++;
                continue;
            }
            if(!(Character.isDigit(ch2) || Character.isAlphabetic(ch2))){
                j--;
                continue;
            }
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
