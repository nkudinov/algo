package am;

import java.util.Arrays;

public class q22 {
    public static double kth2(int[] nums1, int start1,  int[] nums2, int start2, int k){
        if (start1 > nums1.length -1){
            return nums2[start2 + k -1];
        } else if ( start2 > nums2.length -1){
            return nums1[start1 + k -1];
        } else if ( k == 1){
            return Math.min( nums1[start1], nums2[start2]);
        } else {
            int mid1 = Integer.MAX_VALUE;
            int mid2 = Integer.MAX_VALUE;

            if(start1 + k/2 - 1 < nums1.length){
                mid1 = nums1[start1 + k/2 - 1];
            }
            if(start2 + k/2 - 1 < nums2.length){
                mid2 = nums2[start2 + k/2 - 1];
            }
            if (mid1 < mid2){
                return kth2(nums1, start1 + k/2, nums2, start2, k - k/2);
            } else {
                return kth2(nums1, start1 , nums2, start2 + k/2, k - k/2);
            }
        }
    }
    public static double kth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return kth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return kth(A, aStart, B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int mid = (n+m)/2;
        if ((n + m) % 2 == 1) {
            // 1,2,3,4,5
            return kth( nums1, 0, nums2, 0, mid + 1 )*1.0;
        } else {
            double v1 = kth2(nums1, 0, nums2, 0, mid  );
            double v2 = kth2(nums1 , 0, nums2, 0 , mid +1);
            return (v1+v2)/2.0;
        }
    }
    public static void main(String[] args) {
        int arr1[] = { 1,3};
        int arr2[] = { 2,7};
        //1,2,3,4,6,8,9,10
        //0,1,2,3.
        // 1, 2, 3, 4, 7, 8, 12, 15, 18, 20, 33
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
     //   System.out.println(kth( arr1, 0 ,arr2, 0, 3));
       // System.out.println(kth2( arr1, 0 ,arr2, 0, 3));
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
