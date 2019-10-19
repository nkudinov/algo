package c1;

import java.util.HashSet;

public class q1 {
    static boolean isAllUnique(String str){
        HashSet<Character> hs = new HashSet<>();
        for( Character e: str.toCharArray()){
            if (hs.contains(e)){
                return false;
            } else {
                hs.add(e);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAllUnique("hi"));
    }
}
