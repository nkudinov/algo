package ss;

public class q13 {
    static void swap(int[] arr, int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static int fnn(int[] arr){
        int i = 0;
        int N = arr.length;
        //1,0,3,4,5
        //0,1,4,3,5
        //0,1,3,4,5
        while(i < N){
            if (arr[i] < N && arr[i] != i) {
                swap(arr, i, arr[i]);
            }
            if (arr[i] == i  || arr[i] > N-1){
                i++;
            }
        }
        for(i =0 ; i < N ;i++){
            if (arr[i] != i){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr =new int[]{1,0,3,4,5};
        System.out.println(fnn(arr));
    }

}
