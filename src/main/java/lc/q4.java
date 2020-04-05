package lc;

import java.util.Arrays;

public class q4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length+nums2.length;
        int[] indexes = new int[]{0,0};
        double curr = 0;
        double[] values = new double[]{0,0};

        if (n%2 == 0){
            indexes[0] = n/2;
            indexes[1] = n/2+1;
        } else {
            indexes[0] = n/2;
            indexes[1] = n/2;
        }
        int k = 0;
        int i = 0;
        int j = 0;
        while( k < indexes[1]){
            if ( i < nums1.length && j < nums2.length){
                if (nums1[i] < nums2[j]){
                    curr = nums1[i++];
                } else {
                    curr = nums2[j++];
                }
            } else if (i < nums1.length){
                curr = nums1[i++];
            } else if (j < nums2.length) {
                curr = nums2[j++];
            }
           k++;
           if (k%2==0){
              values[0] = curr;
           } else {
              values[1] = curr;
           }
        }
        if (n%2 == 0)
          return (values[0]+values[1])/2;
        else
          return  values[1];
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3};
        int[] arr2 = new int[]{2};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
}
