package rest;

import java.util.PriorityQueue;

public class Heap {
  private int size;
  private int[] arr;
  private int index;
  Heap(int size){
     this.size  = size;
     this.arr   = new int[size];
     this.index = 0;
  }
  private int parentIndex(int i){
      return i/2;
  }
  private void swap(int i, int j){
      int tmp = arr[i];
      arr[i]  = arr[j];
      arr[j]  = tmp;
  }
  public void insert(int value){
     if (index >= size ) {
         throw new IllegalStateException("can not add more elemnts");
     } else {
       arr[index] = value;
       int i = index;
       while(arr[i] < arr[parentIndex(i)]){
           swap(i, parentIndex(i));
           i = parentIndex(i);
       }
     }
     index++;
  }

  public int peek(){
      return arr[0];
  }
  private int leftIndex(int i){
      return i*2+1;
  }
  private int rightIndex(int i){
      return i*2+2;
  }
  private void shiftDown(int i){
     int l = leftIndex(i);
     int r = rightIndex(i);
     if ( l >= index && r >= index){
         return;
     }
     int smallest = -1;
     if ( l < index && r <index){
         if ( arr[l] < arr[r]){
             smallest = l;
         } else {
             smallest = r;
         }
     } else if (l < index){
         smallest = l;
     }  else if (r < index){
         smallest = r;
     } else {
         throw new IllegalStateException("bug");
     }
     if ( arr[i] > arr[smallest]){
         swap(i, smallest);
         shiftDown(smallest);
     }

  }
  public int pool(){
      int ret = arr[0];
      //0,1,2
      //     ^
      arr[0] = arr[--index];
      arr[index] = -1;
      shiftDown( 0);
      return ret;
  }
  public static void main(String[] args) {
        Heap h = new Heap(10);
        h.insert(200);
        h.insert(1);
        h.insert(300);
        h.insert(0);
        System.out.println(h.pool());
        System.out.println(h.pool());
        System.out.println(h.pool());
        System.out.println(h.pool());
  }

}
