package am;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class q30 {
    public static void main(String[] args) {
        String[] arr = new String[]{"a1","a2"};
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals("a1") && o2.equals("a2")){
                    return -1;
                }else {
                    return 1;
                }
            }
        };
        Arrays.sort(arr,cmp);
        System.out.println(Arrays.toString(arr));
    }
}
