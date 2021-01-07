package l100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 06.01.2021.
 */
public class q10 {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries)
            res.add(isMatch(query, pattern));
        return res;
    }
    private static boolean isMatch(String query, String pattern) {
        int i = 0;
        for (char c: query.toCharArray()) {

            if ( i < pattern.length()) {
                char ch = pattern.charAt(i);
                if (c == ch)
                   i++;
            }
            else if (c < 'a')
                return false;
        }
        return i == pattern.length();
    }
    public static void main(String[] args) {
        String[] arr = new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        System.out.println(camelMatch(arr, "FB"));
    }

}
