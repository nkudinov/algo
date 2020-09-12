package g;

public class q7 {
    static public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if ( arr[m] > arr[m+1] ){
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));
    }

}
