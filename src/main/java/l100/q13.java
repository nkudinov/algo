package l100;

import scala.Int;

import java.util.ArrayList;
import java.util.List;

public class q13 {
    public static List<String> ambiguousCoordinates(String s) {
        s = s.substring(1,s.length()-1);
        int N = s.length();
        List<String> ans = new ArrayList<>();
        for(int i = 1 ; i < N; i++){
            String left  = s.substring(0, i);
            String right = s.substring(i, N);
            for(String str1: makeValid(left)){
                for(String str2: makeValid(right)){
                    ans.add("(" + str1 + "," + str2 + ")");
                }
            }
        }
        return ans;
    }
    public static List<String> makeValid(String s){
        int N = s.length();
        List<String> ans = new ArrayList<>();
        ans.add(s);
        for(int i = 1; i < N; i++){
            String s1 = s.substring(0,i);
            String s2 = s.substring(i,N);
            ans.add(s1+"."+s2);
        }
        return ans;
    }
    public static void main(String[] args) {
       for(String str:ambiguousCoordinates("(123)")){
           System.out.println(str);
       }
    }
}
