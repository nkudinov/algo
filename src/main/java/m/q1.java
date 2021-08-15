package m;

public class q1 {
    public static int solution(int[] A) {
        int sum = 0;
        for(int x:A){
            sum += x;
        }
        int avg = (int)Math.ceil(1.0*sum/A.length);
        int ans = 0;
        for(int x:A){
            ans += Math.abs(avg-x);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,1,2,3,1};
        System.out.println(solution(arr));
        arr = new int[]{4,1,4,1};
        System.out.println(solution(arr));

        arr = new int[]{3,3,3};
        System.out.println(solution(arr));

        arr = new int[]{1,4};
        System.out.println(solution(arr));
    }

}
