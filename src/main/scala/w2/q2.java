package w2;

import java.util.Arrays;
import java.util.Scanner;

public class q2 {
    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static void sort(int[] d,int[] c){
        int n = c.length;
        for( int i = 0; i < n; i++){
            int index = i;
            for(int j = i+1; j < n;j++){
                if (c[j] > c[index]){
                    index = j;
                }
            }
            swap(c, i, index);
            swap(d, i, index);
        }
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(c));
    }
    static int calcMaxAmount(int[] d, int[] c){
        sort(d,c);

        boolean[] used = new boolean[d.length];
        for(int i = 0; i < c.length; i++){
            int k = d[i] - 1;
            while( k >= 1 && used[k])
                k--;
            if (k < 0)
                continue;
            used[k] = true;
        }
        int ret = 0;
        for(int i=0;i< used.length;i++)
            if (used[i] == true)
                ret += c[i];
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] d = new int[n];
        int[] c = new int[n];
        for(int i=0;i<n;i++){
            d[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }
        System.out.println(calcMaxAmount(d,c));

    }
}
