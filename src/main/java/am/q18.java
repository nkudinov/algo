package am;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q18 {
    public static  List<Integer> partitionLabels(String S) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            map.put(ch, i);
        }
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int maxIndex = 0;
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            maxIndex = Math.max(maxIndex, map.get(ch));
            if ( i == maxIndex ){
                ans.add( i - l + 1);
                l = i+1;
            }
        }
        return ans;
    }
    // ababcbaca
    // defegde
    // hijhklij
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
