package ss;

import javafx.util.Pair;

public class q17 {
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        int cnt = 0;
        Pair<Character,Character> pair = null;
        for(int i = 0; i < s1.length();i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                cnt++;
                if (cnt > 2) {
                    return false;
                }
                if (pair == null) {
                    pair = new Pair<>( s1.charAt(i) , s2.charAt(i));
                } else if ( pair.getKey() != s2.charAt(i) || pair.getValue()!= s1.charAt(i)) {
                    return false;
                }
            }
        }
        return pair==null;
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank"
                ,"kanb"));
    }
}
