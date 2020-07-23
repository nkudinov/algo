package a;

public class q8 {
    static public int findIndex(int[] arr){
        int total = 0;
        for(int i =0; i<arr.length;i++){
            total += arr[i];
        }
        int i = 0;
        int lSum = 0;
        int rSum = total;
        while (lSum != rSum && i < arr.length){
           lSum += arr[i];
           rSum -= arr[i];
           i++;
        }
        if ( i == arr.length){
            return -1;
        }
        return i;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,10};
        System.out.println(findIndex(arr));
    }
}
