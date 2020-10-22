package f;

import java.util.HashMap;
import java.util.Map;

public class q69 {
    public static int compare(String s1, String s2, HashMap<Character,Integer> map) {
        int n = s1.length(), m = s2.length();
        for (int i = 0; i < n && i < m; ++i)
            if (s1.charAt(i) != s2.charAt(i))
                return map.get(s1.charAt(i)) - map.get(s2.charAt(i));
        return n - m;
    }
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put( order.charAt(i), i);
        }
        for(int i = 1; i <= words.length-1; i++){
            if ( compare( words[i-1], words[i], map) > 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words =  {"apple","app"};
        String order =  "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }
}
