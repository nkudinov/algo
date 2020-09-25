package p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1 {
    static String minPath = "";
    static int  minEdits = Integer.MAX_VALUE;
    static void helper( String source, String target, int edits, String path){
        if ( source.length() == 0 || target.length() == 0) {
            edits += target.length();
            for( char ch:target.toCharArray()){
                path = path + "," + "+" + ch;
            }
            if (minEdits > edits && source.length() == 0){
                minEdits = edits;
                minPath  = path;
            }
        } else if( edits < minEdits){
            char ch1 = source.charAt(0);
            char ch2 = target.charAt(0);
            if ( ch1 != ch2){
                helper( source.substring(1), target, edits + 1, path + "," + "-" + ch1);
                helper( source, target.substring(1), edits + 1, path + "," + "+" + ch2);
            } else {
                helper( source.substring(1), target.substring(1), edits, path +","+ ch1);
            }
        }
    }
    static String[] diffBetweenTwoStrings(String source, String target) {
        minPath = "";
        minEdits = Integer.MAX_VALUE;
        helper( source, target, 0, "");
        String[] ret = minPath.split(",");
        return Arrays.copyOfRange(ret, 1, ret.length);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(diffBetweenTwoStrings("CBAAABBC","CBBC")));
    }

}
