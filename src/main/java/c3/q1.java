package c3;

class Stack3 {

    int size;
    int arr[];
    int index1;
    int index2;
    int index3;
    int [] pointer = new int[] {-1,-1,-1};

    public Stack3(int size) {
        this.size = size;
        this.arr  = new int[this.size];
        index1 = -1;
        index2 = -1;
        index3 = size;
    }

    public void shift(int delat){

    }

    public void push(int index, int value){
        if (index == 0 ){
           shift(+1);
           arr[index1++] = value;
        }
        else if (index == 1){
            if (index2 + 1 <= index3){
                arr[++index2] = value;
            } else
                throw new IllegalStateException("stack is full(2)");
        } else {
            if (index3 - 1 > index2){
                arr[--index3] = value;
            } else
                throw new IllegalStateException("stack is full (3)");
        }
    }
    public int pop(int index){
        if (index == 0) {
            shift(-1);
            return arr[index1--];
        } else if ( index == 1 ) {
            if (index2 >= 0){
                return arr[index2--];
            } else
                throw new IllegalStateException("stack is empty(2)");
        }
        else {
            if (index3 <= size -1 ){
                return arr[index3++];
            } else
                throw new IllegalStateException("stack is empty(3)");
        }
    }
    public void print(){
        if (index2 >= 0 ) {
            for (int i = index1 + 1; i <= index2; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println(" ");
        if (index3 < size) {
            for (int i = size-1; i >= index3; i--) {
                System.out.print(arr[i] + " ");
            }
        }
    }

}
class Stack2 {
    int size;
    int [] arr;
    int index0;
    int index1;
    public Stack2(int size) {
        this.size = size;
        this.arr  = new int[this.size];
        index0 = -1;
        index1 = size;
    }
    public void push(int index, int value){
        if (index == 0){
           if (index0 + 1 <= index1){
               arr[++index0] = value;
           } else
               throw new IllegalStateException("stack is full(0)");
        } else {
           if (index1 - 1 > index0){
               arr[--index1] = value;
           } else
               throw new IllegalStateException("stack is full (1)");
        }
    }
    public int pop(int index){
        if (index == 0){
            if (index0 >= 0){
                return arr[index0--];
            } else
                throw new IllegalStateException("stack is empty(0)");
        } else {
            if (index1 <= size -1 ){
                return arr[index1++];
            } else
                throw new IllegalStateException("stack is empty(1)");
        }
    }
    public void print(){
        if (index0 >= 0 ) {
            for (int i = 0; i <= index0; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println(" ");
        if (index1 < size) {
            for (int i = size-1; i >= index1; i--) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
public class q1 {
    public static void main(String[] args) {
      Stack3 stack = new Stack3(10);

      stack.push(1,1);
      stack.push(1,1);


      stack.push(2,2);
      stack.push(2,2);

      stack.print();
    }
}
