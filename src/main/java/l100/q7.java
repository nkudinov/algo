package l100;

import java.util.Stack;

public class q7 {

   public  static void printPrevSmaller(int arr[], int n) {
        // Create an empty stack
        Stack<Integer> S = new Stack<>();

        // Traverse all array elements
        for (int i = 0; i < n; i++) {
            // Keep removing top element from S while the top
            // element is greater than or equal to arr[i]
            while (!S.empty() && S.peek() >= arr[i]) {
                S.pop();
            }

            // If all elements in S were greater than arr[i]
            if (S.empty()) {
                System.out.print("_, ");
            } else //Else print the nearest smaller element
            {
                System.out.print(S.peek() + ", ");
            }

            // Push this element
            S.push(arr[i]);
        }
    }

    /* Driver program to test insertion sort */
    public static void main(String[] args) {
        int arr[] = {1,8,9,10,21,20};
        int n = arr.length;
        printPrevSmaller(arr, n);
    }


}
