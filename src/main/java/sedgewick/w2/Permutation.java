import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;


public class Permutation {
    public static void main(String[] args){
        int k = StdIn.readInt();
        String[] arr = new String[k];
        for(int i = 1; i<=k; i++){
           arr[i] = StdIn.readString();
        }
        for(int i = 0; i <arr.length;i++){
            StdOut.println(arr[i]);
        }
    }
}
