package l100;

public class q63 {

    static class Solution {
        public boolean check(int[] arr, int max, int index){
            for(int i = index; i < arr.length; i++){
                if (arr[i] < max){
                    return false;
                }
            }
            return true;
        }
        public int helper( int[] arr, int max, int index){
            if ( check( arr, max, index)){
                return index;
            }
            return helper( arr, Math.max( max, arr[index]), index + 1);

        }
        public int partitionDisjoint(int[] A) {
            return helper( A, A[0], 1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{5,0,3,8,6};
        System.out.println(s.partitionDisjoint(arr));
    }

}
