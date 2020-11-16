package am;

public class q14 {
    public static int kth(int[] nums1, int[] nums2, int k){
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        while ( i < n || j < m) {
            if (i < n && (j >= m || nums1[i] < nums2[j])) {
                if (  i + j == k ){
                    return nums1[i];
                }
                i++;
            } else {
                if ( i + j == k ){
                    return nums2[j];
                }
                j++;
            }
        }
        return  -1;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int mid = (n+m)/2;
        if ((n + m) %2 == 1){
            return kth(nums1, nums2, mid )*1.0;
        } else {
            return (kth(nums1, nums2, mid - 1) + kth(nums1 , nums2 , mid))/2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
