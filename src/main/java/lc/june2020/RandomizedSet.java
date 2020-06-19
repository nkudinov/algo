package lc.june2020;

import java.util.*;

public class RandomizedSet {
    List<Integer> lst;
    Random rnd;
    /** Initialize your data structure here. */
    public RandomizedSet() {
      lst = new ArrayList<>();
      rnd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (lst.contains(val)){
            return false;
        }
        return lst.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
       return  lst.remove((Integer)val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
      int ind = rnd.nextInt(lst.size());
      return lst.get(ind);
   }

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        randomSet.insert(1);
        randomSet.insert(2);
        System.out.println(randomSet.getRandom());
    }
}
