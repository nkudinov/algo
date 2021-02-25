package l100;

public class q46 {
    public static boolean canThreePartsEqualSum(int[] arr) {
        int N = arr.length;
        int s = 0;
        for(int i = 0; i < N; i++){
            s += arr[i];
        }
        if ( s%3 != 0){
            return false;
        }
        int ans  = 0;
        int cnt  = 0;
        for(int i = 0; i < N; i++){
            ans += arr[i];
            if (ans == s/3 && cnt < 2){
                ans = 0;
                cnt++;
            }
        }
        return ans == s/3 && cnt >= 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,-4,16,-5,9,-3,3,8,0};
        System.out.println(canThreePartsEqualSum(arr));
    }

}
