package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q2 {

    static public double median1(List<Integer> lst){
        Collections.sort(lst);
        int len = lst.size();
        if (len %2 == 1){
            return lst.get(len/2);
        }
        return (lst.get(len/2-1)+lst.get(len/2))/2.0;
    }

    static private int partition(List<Integer> lst, int start, int end){
       System.out.println("before :"+lst +" start = "+start+" end="+end);
       int pivot = lst.get(end);
       int pivotloc = start;
       for(int i = start; i <= end;i++) {
          if (lst.get(i) < pivot){
              Collections.swap( lst, i, pivotloc);
              pivotloc++;
          }
       }
       Collections.swap( lst, pivotloc, end);
       System.out.println("after :"+lst);
       return pivotloc;
    }

    static private int quickSelect(List<Integer> lst, int start, int end, int k){
        int part = partition( lst, start, end);
        if ( k == part){
            return lst.get( part);
        } else if ( part > k ){
            return quickSelect( lst, start, part - 1, k );
        }
        return quickSelect( lst, part + 1, end, k );
    }
    static public double median2( List<Integer> lst){

        int len = lst.size();
        if (len%2 == 1){
            return quickSelect(lst,0, len-1,len/2);
        }
        return (quickSelect(lst,0, len-1,len/2-1)+quickSelect(lst,0, len-1,len/2))/2.0;
    }
    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>(Arrays.asList(7, 10, 4, 3, 20, 15));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(median2(l1));
        System.out.println(median2(l2));

    }
}
