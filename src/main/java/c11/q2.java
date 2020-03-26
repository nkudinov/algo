package c11;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static c11.q2.sort;

public class q2 {
    static String toSortString(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    static void sort2(String[] arr){
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                 return toSortString(o1).compareTo(toSortString(o2));
            }
        };
       Arrays.sort( arr, c);
    }
    static void sort(String[] strings){

        Arrays.sort(strings, (left, right) -> {
            if (left.length() != right.length()) {
                return left.compareTo(right);
            }
            List<Character> leftChars = new ArrayList<>();
            List<Character> rightChars = new ArrayList<>();

            for (int i = 0; i < left.length(); i++) {
                leftChars.add(left.charAt(i));
                rightChars.add(right.charAt(i));
            }
            Collections.sort(leftChars);
            Collections.sort(rightChars);

            for (int i = 0; i < left.length(); i++) {
                int res = leftChars.get(i).compareTo(rightChars.get(i));

                if (res != 0) {
                    return res;
                }
            }
            return 0;
        });
    }
    public static void main(String[] args) {
        String[] arr1 = {"ABC","B","D","BAC","z"};
        sort2(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
