package c3;

class Stack3 {

    int stackSize;
    int buffer[];
    int [] pointer = new int[] {-1,-1,-1};

    public Stack3(int stackSize) {
        this.stackSize = stackSize;
        this.buffer = new int[stackSize*3];
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
      Stack2 stack = new Stack2(10);
      stack.push(0,1);
      stack.push(0,2);
      stack.pop(0);
      stack.pop(0);
      stack.push(0,3);

      stack.push(1,1);
      stack.push(1,2);
      stack.pop(1);
      stack.pop(1);
      stack.push(1,1);
      stack.push(1,2);

      stack.print();
    }
}
