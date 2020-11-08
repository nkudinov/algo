package am;

import java.util.Arrays;
import java.util.Comparator;

public class q3 {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split(" ",2);
                String[] arr2 = o2.split(" ",2);
                char ch1 = arr1[1].charAt(0);
                char ch2 = arr2[1].charAt(0);
                boolean isDigit1 = Character.isDigit(ch1);
                boolean isDigit2 = Character.isDigit(ch2);
                if ( !isDigit1 && !isDigit2){
                    int cmp = arr1[1].compareTo(arr2[1]);
                    if (cmp!=0){
                        return cmp;
                    }
                    return arr1[0].compareTo(arr2[0]);
                } else {
                  if (isDigit1 && !isDigit2)
                       return -1;
                  else if (!isDigit1 && isDigit2){
                      return 1;
                  } else {
                      return 0;
                  }
                }
            }
        };
        Arrays.sort(logs, comparator);
        return logs;
    }

    public static void main(String[] args) {

    }
}
