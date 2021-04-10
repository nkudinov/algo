package l100;

public class q65 {
    public static void helper( int[] A, int i, Integer delta, int curr, int[] max){
        for(int j = i+1; j < A.length;j++){
            helper( A , j, A[i] - A[j], 1, max);
            if (delta != null && A[i]- A[j] == delta){
                helper( A , j, A[i]- A[j], curr+1, max);
            }
        }
    }
    public static int longestArithSeqLength(int[] A) {
        if (A.length <=2){
            return A.length;
        }
        int[] ans = new int[]{0};
        helper( A, 0, null, 0, ans);
        return ans[0]+1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{ 3,6,9,12};
        System.out.println(longestArithSeqLength(arr));
    }

}
