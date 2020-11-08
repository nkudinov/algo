package am;

public class q5 {
    public static  int compareVersion(String version1, String version2) {
       String[] arr1 = version1.split("\\.");
       String[] arr2 = version2.split("\\.");
       int N1 = arr1.length;
       int N2 = arr2.length;
       for( int i = 0; i < Math.max(N1,N2);i++){
           int n1 = ( i>= N1 ) ?0: Integer.parseInt(arr1[i]);
           int n2 = ( i>= N2 ) ?0: Integer.parseInt(arr2[i]);
           if ( n1 != n2){
               return (n1 - n2)>0?1:-1;
           }
       }
       return 0;
    }

    public static void main(String[] args) {
        String s1 = "0.1";
        String s2 = "1.1";
        System.out.println(compareVersion(s1, s2));
    }
}
