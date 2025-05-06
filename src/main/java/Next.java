import java.util.Arrays;

public class Next {

    public int[] nextPermuation(int[] arr) {
        // 1234
        int n = arr.length;
        for(int i = n-1; i >=0; i--) {
            boolean found = false;
            for(int j = i + i; j < n; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    return arr;
                }
            }
        }
        // just reverse
        int i = 0;
        int j = n-1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
}
