package lc;

public class q5 {
    static public String longestPalindrome(String s) {
      String ret = "";
      for(int i =0; i < s.length(); i++){
          StringBuilder sb = new StringBuilder();
          for(int j = i; j < s.length(); j++){
            sb.append(s.charAt(j));
            String tmp = sb.toString();
            if (tmp.charAt(0) == s.charAt(j) && tmp.length() > ret.length()) {
                if (new StringBuilder(tmp).reverse().toString().equals(tmp)) {
                        ret = tmp;
                }
            }
          }

      }
      return ret;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
