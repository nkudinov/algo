package f;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class q34 {
    public static  int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() == 0){
            return 0;
        }
        if (k == 1 && s.length() == 1){
            return 1;
        }
        int r = 0;
        int l = 0;
        int ret = 1;
        Map<Character,Integer> map = new HashMap<>();
        //m,m,m,m,e
        //0,1
        while( r < s.length()){
            map.put(s.charAt(r),r);

            if ( map.size() == k +1 ){
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                l = index+1;
            }
            ret = Math.max(ret, r-l+1);
            r++;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("aa",1));
    }

}
