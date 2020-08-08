package f;

import java.util.*;

public class q28 {
    static class Item {
        int[] arr;
        int count;

        public Item(int[] arr, int count) {
            this.arr = arr;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Item)) return false;
            Item item = (Item) o;
            return count == item.count &&
                    Arrays.equals(arr, item.arr);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(count);
            result = 31 * result + Arrays.hashCode(arr);
            return result;
        }
    }
    static boolean isSorted(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if (arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
    static int[] copy(int[] arr){
        return Arrays.copyOf(arr, arr.length);
    }
    static void reverse(int[] arr, int i, int j){
        int start = i;
        int end = j;
        while( i <= j && i < arr.length){
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
            i++;
            j--;
        }
    }
    static int minOperations(int[] arr) {
        Queue<Item> q = new LinkedList<>();
        q.add(new Item( arr,0));

        Set<Item> visited = new HashSet<>();
        while(!q.isEmpty()){
            Item item = q.poll();
            if (visited.contains(item)){
                continue;
            }
            visited.add(item);
            for(int i = 0 ; i < item.arr.length; i++){
                for(int j = i+1; j < item.arr.length; j++){
                      int[] current  = copy(item.arr);
                      reverse(current, i, j);
                      if (isSorted(current)){
                          return item.count+1;
                      }
                      q.add(new Item(current, item.count+1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2};
        //reverse(arr, 1,2);
        //System.out.println(Arrays.toString(arr));
          System.out.println(minOperations(arr));
    }

}
