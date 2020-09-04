package g;

import java.util.HashSet;
import java.util.Set;

public class q1 {
    private static String normilize(String email){
        String[] parts = email.split("@");
        String part1 = parts[0].replaceAll("\\.","");
        if (part1.indexOf('+') > 0){
            part1 = part1.substring(0,part1.indexOf('+'));
        }
        String part2 = parts[1];
        return part1+"@"+part2;
    }
    static public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email:emails){
            set.add(normilize(email));
        }
        return set.size();
    }
    public static void main(String[] args) {
        String[] arr = new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        System.out.println(numUniqueEmails(arr));
    }

}
