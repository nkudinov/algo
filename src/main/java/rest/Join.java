package rest;

import scala.Int;

import java.util.Arrays;
import java.util.Iterator;


public class Join {
    static class JoinIntegerIterator implements Iterator<Integer>{
        Integer leftRow;
        Integer righRow;
        Iterator<Integer> left;
        Iterator<Integer> right;
        private Integer AdvancedNext(Iterator<Integer> iter){
            if (iter.hasNext()){
                return iter.next();
            }
            return null;
        }
        private boolean findNextInnerJoinRows(){
          if ( leftRow == null){
              leftRow = AdvancedNext(left);
          }
          righRow = AdvancedNext(right);
          if (leftRow == null){
              return false;
          } else if (righRow == null){
              return false;
          } else {
              do {
                 int comp = leftRow.compareTo(righRow);
                 if (comp < 0){
                     leftRow = AdvancedNext(left);
                 } else if (comp >0){
                     righRow = AdvancedNext(right);
                 }
              } while ( leftRow != null && righRow != null && leftRow != righRow);
              if ( left!= null && right!= null & left == right){
                  return true;
              }
              return false;
          }
        }
        public JoinIntegerIterator(Iterator<Integer> left, Iterator<Integer> right) {
            this.left = left;
            this.right = right;
            findNextInnerJoinRows();
        }

        @Override
        public boolean hasNext() {
            return leftRow != null && righRow != null;
        }

        @Override
        public Integer next() {
            Integer ret = leftRow;
            findNextInnerJoinRows();
            return ret;
        }
    }

    public static Iterator<Integer> join(Iterator<Integer> left, Iterator<Integer> right){

          return new JoinIntegerIterator(left, right);

    }
    public static void main(String[] args) {
        Iterator<Integer> l = Arrays.stream(new int[]{1,1}).iterator();
        Iterator<Integer> r = Arrays.stream(new int[]{1,2,3,4}).iterator();
        Iterator<Integer> o = join(l, r);
        while(o.hasNext()){
            System.out.println(o.next());
        }

    }
}
