package c11;

public class q5 {
    static int correctIndex(String[] a, int i, int start, int end){
        while(a[i].equals("") && i> start){
            i--;
        }
        while(a[i].equals("") && i< end){
            i++;
        }
        return i;
    }
    static int binarySearch(String[] a, String x, int l, int h){

        int start = l;
        int end   = h;
        int m = 0;
        while( start <= end) {
            m = (start + end)/2;
            m = correctIndex(a , m, start, end);
            if (a[m].equals(x))
                return m;
            else if ( a[m].compareTo(x) <= 0) {
                start = m+1;
            }
            else {
                end = m-1;
            }

        }
        return -1;

    }
    public static void main(String[] args) {
      String[] arr = {"a","","","","","b","","","","c","","","d","e"};
      System.out.println(binarySearch(arr,"a",0,arr.length-1));
      System.out.println(binarySearch(arr,"b",0,arr.length-1));
      System.out.println(binarySearch(arr,"c",0,arr.length-1));
      System.out.println(binarySearch(arr,"d",0,arr.length-1));
      System.out.println(binarySearch(arr,"e",0,arr.length-1));
    }

}
