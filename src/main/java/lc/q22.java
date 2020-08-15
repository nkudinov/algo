package lc;

import java.util.Arrays;

public class q22 {
    private static void insert(int[] nums1, int index, int value){
        for( int i = nums1.length-1; i > index ; i--){
            nums1[i] = nums1[i-1];
        }
        nums1[index] = value;

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = n + m -1;
        while ( i >=0 && j >= 0 && k >0){
            if( nums1[i] <= nums2 [j] ){
                int value = nums2[j];
                nums1[k] = value;
                j--;
                k--;
            } else {
                nums1[k--] = nums2[i];
                i--;
            }
        }
        while( j >= 0){
            nums1[k] = nums2[j];
            j--;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1,0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
