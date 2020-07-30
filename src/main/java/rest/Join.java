package rest;

import scala.Int;

import java.util.Arrays;
import java.util.Iterator;


public class Join {
    private static  Integer internalNext(Iterator<Integer> iter){
        if (iter.hasNext()){
            return iter.next();
        }
        return null;
    }
    public static Iterator<Integer> join(Iterator<Integer> left, Iterator<Integer> right){

          return new Iterator<Integer> () {



              Integer leftRow = left.next();
              Integer righRow = right.next();
              @Override
              public boolean hasNext() {
                  return leftRow != null & righRow!= null;
              }

              @Override
              public Integer next() {
                  Integer ret = null;
                  if ( leftRow == righRow) {

                      ret = leftRow;


                  } else if (leftRow > righRow){
                      righRow = internalNext( right);
                      while ( leftRow > righRow ){
                          righRow = internalNext( right);
                      }
                      ret = leftRow;
                      righRow = internalNext( right);
                  } else {
                      leftRow = internalNext(left);
                      while ( leftRow < righRow ){
                          leftRow = internalNext(left);
                      }
                      ret = leftRow;
                      righRow = internalNext( right);
                  }
                  return ret;
              }
          };
    }
    public static void main(String[] args) {
        Iterator<Integer> l = Arrays.stream(new int[]{1,3}).iterator();
        Iterator<Integer> r = Arrays.stream(new int[]{1,2,3}).iterator();
        Iterator<Integer> o = join(l, r);
        while(o.hasNext()){
            System.out.println(o.next());
        }

    }
}
