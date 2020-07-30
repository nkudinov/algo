package f;

import java.util.*;

public class q12 {

    class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


    int countDistinctTriangles(ArrayList<Sides> arr) {
         Set<String> set = new HashSet<>();
         for(Sides s:arr){
             int[] sides = new int[]{s.a,s.b,s.c};
             Arrays.sort(sides);
             set.add(sides[0]+"."+sides[1]+"."+sides[2]);
         }
         return set.size();
    }
}
