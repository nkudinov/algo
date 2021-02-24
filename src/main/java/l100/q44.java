package l100;

import java.util.Arrays;

public class q44 {
    static class BIT {
        int[] arr;
        BIT(int N){
            arr = new int[N+1];
        }
        public void update(int i, int delta){
            while(i < arr.length){
                arr[i] += delta;
                i += (i&-i);
            }
        }
        public int getSum(int i){
            int ans = 0;
            while( i > 0){
                ans += arr[i];
                i -= (i &-i);
            }
            return ans;
        }
        //2 10
        //1 01
        //0 00
        void print(){
            System.out.println(Arrays.toString(arr));
        }
    }
    BIT bit;
    int[] arr;
    int N;
    public q44(int[] nums) {
        N = nums.length;
        bit = new BIT(N);
        arr = new int[N+1];
        for(int i = 1; i <= N; i++ ){
            arr[i] = nums[i-1];
        }
        System.out.println(Arrays.toString(arr));
        for(int i = 1; i <= N; i++){
            bit.update( i, arr[i]);
        }
        bit.print();
    }

    public void update(int index, int val) {
        bit.update(index+1, val-arr[index+1] );
        arr[index+1] = val;
        bit.print();
     }

    public int sumRange(int left, int right) {
        int a = bit.getSum(right+1);
        int b = bit.getSum(left);
        System.out.println("a="+a+" b="+b);
        return  a - b;
    }
    public static void main(String[] args) {
        //1,3,5
        int[] arr = new int [] {9,-8};
        q44 q = new q44(arr);
        System.out.println("(1,1)=="+q.sumRange(1,1));
        q.update(0,3);
        System.out.println("(1,1)=="+q.sumRange(1,1));
        System.out.println("(0,0)=="+q.sumRange(0,0));
    }

}
