package sp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q1 {

    public static Set<String> comb(Set<Character> src, Set<String> acc, String elm){
        if (elm.length() == src.size()){
            acc.add(elm);
        } else {
            for (Character c : src) {
                Set<Character> tmp = new HashSet<>();
                tmp.addAll(src);
                tmp.remove(c);
                comb(src,acc,elm+c);
            }
        }
        return acc;
    }
    public static Set<String> rec( int idx, int n, int m,Set<String> acc, String cur){
        if (idx == n) {
           acc.add(cur);
        } else {
            for (int i = 1; i <= m; i++) {
                 rec( idx +1 , n, m,acc,cur+i);
            }
        }
        return acc;
    }
    public static void main(String[] args) {
        Set<Character> src = new HashSet<>();
        src.addAll(Arrays.asList('a','b','c'));
        Set<String> ret = comb(src,new HashSet<>(),"");
        System.out.println(ret);
        System.out.println(ret.size());
        System.out.println(rec(0,3,3,new HashSet<>(),""));
    }
}
