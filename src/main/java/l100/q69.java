package l100;

public class q69 {
    public static int majorityElement(int[] nums) {
        int count   = 0;
        int element = 0;
        for(int e:nums){
            if (count == 0){
                element = e;
            }
            count += (e == element)?1:-1;
        }
        return element;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2};
        System.out.println(majorityElement(arr));
    }

}
