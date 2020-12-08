package y;

import scala.Int;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class q2 {
    static Iterator<Integer> arr2iter(int[] arr){
        return IntStream.of(arr).boxed().iterator();
    }
    static Iterator<Integer> filterNot(Iterator<Integer> i1, Iterator<Integer> i2){
        Iterator<Integer> ans = new Iterator<Integer>() {
            List<Integer> buff1 = new ArrayList<>();
            List<Integer> buff2 = new ArrayList<>();
            private void fill(){
                if ( buff2.size() == 0 && i2.hasNext()){
                     buff2.add(i2.next());
                }
                if ( buff2.size() == 0 && i1.hasNext()){
                    buff1.add(i1.next());
                } else if (i1.hasNext()){
                   Integer curr1 = i1.next();
                   Integer curr2 = buff2.remove(0);
                   while(curr2 < curr1 && i2.hasNext()){
                       curr2 = i2.next();
                   }
                   if ( curr1 == curr2){
                       buff2.add(curr2);
                       fill();
                   } else {
                      buff1.add(curr1);
                   }
                }
              }
            public boolean hasNext(){
                if (buff1.size() == 0){
                    fill();
                }
                return buff1.size() > 0;
            }
            public Integer next() {
                if (buff1.size() == 0) {
                    fill();
                }
                return buff1.remove(0);
            }
        };
        return ans;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{1 , 1, 2,2, 3, 3, 4, 5, 6};
        int[] arr2 = new int[]{-2, -1, 0,1,2};
        Iterator<Integer> it =  filterNot(arr2iter(arr1), arr2iter(arr2));
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
