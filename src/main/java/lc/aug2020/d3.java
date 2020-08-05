package lc.aug2020;

public class d3 {
    public static boolean isPalindrome(String s) {
       StringBuilder sb = new StringBuilder();
       for(Character ch:s.toCharArray()){
           if (Character.isAlphabetic(ch) || Character.isDigit(ch)){
               sb.append(Character.toLowerCase(ch));
           }
       }
       return sb.toString().equals(sb.reverse().toString());
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
