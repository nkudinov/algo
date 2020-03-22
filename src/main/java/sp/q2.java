package sp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q2 {
    public static Set<String> perm(Set<Character> src, Set<String> acc, String elm){
        if (elm.length() == src.size()){
            acc.add(elm);
        } else {
            for (Character c : src) {
                if (! ( elm.contains(c+""))) {
                    Set<Character> tmp = new HashSet<>();
                    tmp.addAll(src);
                    tmp.remove(c);
                    perm(src, acc, elm + c);
                }
            }
        }
        return acc;
    }
    public static void main(String[] args) {
        Set<Character> src = new HashSet<>();
        src.addAll(Arrays.asList('a','b','c'));
        Set<String> ret = perm(src,new HashSet<>(),"");
        System.out.println(ret);
    }
}
