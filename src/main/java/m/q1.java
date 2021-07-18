package m;

public class q1 {
    public static double solution(int[] A) {
        int sum = 0;
        for(int x:A){
            sum += x;
        }
        double avg =  1.0*sum/A.length;
        System.out.println(avg);
        double ans = 0;
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
