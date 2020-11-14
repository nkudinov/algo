package am;

import java.util.Arrays;

public class q13 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i  = 0;
        int j  = 0;
        int k = 0;
        int[] arr = new int[n+m];
        while ( i < n || j < m){
            if ( i>= n){
                arr[k] = nums1[i];
            } if (j >=m ){
                arr[k] = nums2[j];
            } else if (nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        System.out.println(Arrays.toString(arr));
        int mid = arr.length/2;
        if ( arr.length %2 == 0){
            //0,1,2,3
            return (arr[mid]+arr[mid-1])/2.0;
        } else {
            return arr[mid]*1.0;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
