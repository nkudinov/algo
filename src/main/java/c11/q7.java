package c11;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q7 {
    static class Person implements Comparable<Person> {
        private Integer h;
        private Integer w;

        public Person(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(@NotNull Person o) {
            if (this.h!=o.h){
                return h.compareTo(o.h);
            } else {
                return w.compareTo(o.w);
            }
        }
        public boolean isBefore(Person other) {
             if (this.h < other.h && this.w < other.w)
                 return true;
            else
                return false;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "h=" + h +
                    ", w=" + w +
                    '}';
        }
    }

    static List<Person> getIncreasingSequence(List<Person> arr){
        Collections.sort(arr);
        return longestlncreasingSubsequence(arr);
    }

    static List<Person>  longestlncreasingSubsequence(List<Person> arr){
        List<Person>[] solutions = new ArrayList[arr.size()];
        longestIncreasingSubsequence( arr, solutions, 0);
        List<Person> best_sequence = null;
        for (int i = 0; i < arr.size(); i++) {
            best_sequence = seqWithMaxLength( best_sequence, solutions[i]);
        }

        return best_sequence;

    }
     static List<Person> seqWithMaxLength( List<Person> seql, List<Person> seq2) {
        if (seql == null)
            return seq2;
        if (seq2 == null)
            return seql;
        return seql.size() > seq2.size() ? seql : seq2;
    }
    static void longestIncreasingSubsequence(List<Person> arr, List<Person>[] solutions, int index){
        if (index >= arr.size() || index < 0){
            return;
        }
        Person p = arr.get(index);
        List<Person> best_sequence = null;
        for ( int i = 0; i < index; i++){
           if ( arr.get(i).isBefore(p)){
               best_sequence = seqWithMaxLength( best_sequence, solutions[i]);
           }
        }
        List<Person> new_solution = new ArrayList<Person>();
        if (best_sequence != null) {
            new_solution.addAll(best_sequence);
        }
        new_solution.add(p);

        solutions[index] = new_solution;
        longestIncreasingSubsequence( arr, solutions, index+1);
    }
    public static void main(String[] args) {
        Person p1 = new Person(65,100);
        Person p2 = new Person(70,150);
        Person p3 = new Person(56, 90);
        Person p4 = new Person(75, 190);
        Person p5 = new Person(60, 95);
        Person p6 = new Person(68, 110);

        List<Person> array = new ArrayList<Person>();
        array.add(p1);
        array.add(p2);
        array.add(p3);
        array.add(p4);
        array.add(p5);
        array.add(p6);
        System.out.println(getIncreasingSequence(array).toString());

    }
}
