package c11;

import java.util.Arrays;

public class q3 {
    static int binarySearch(int[] a, int x, int l, int h){

        int start = l;
        int end   = h;
        int m = 0;
        while( start <= end) {
            m = (start + end)/2;
            if (a[m] == x)
                return m;
            else if ( a[m] < x) {
                start = m+1;
            }
            else {
                end = m-1;
            }

        }
        return -1;
    }

    static int find(int[] a, int x, int l, int h) {

        if (l > h)
            return -1;
        else {
            int m = (l + h) / 2;
            if (a[l] < a[m] && a[l] <= x && x <= a[m]) {
                return binarySearch(a, x, l, m);
            } else if (a[m] < a[h] && a[m] <= x && x <= a[h]) {
                return binarySearch(a, x, m, h);
            } else if (a[l] > a[m]) {
                return find(a, x, l, m);

            } else if (a[m] > a[h]) {
                return find(a, x, m+1, h);
            }
            return -1;
        }

    }
    public static void main(String[] args) {

        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println( find(arr,10,0, arr.length-1));

    }
}
