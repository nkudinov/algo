package gci;

public class MaxSubstring {
   public static int maxSubstring(String s1,String s2) {
       int ret = 0;
       int [][] m = new int[s1.length()][s2.length()];
       for(int i=0; i< m.length;i++){
           for(int j = 0; j < m[0].length;j ++) {
              int value;
              if (s1.charAt(i) != s2.charAt(j)){
                  value = 0;
              } else {
                  if ( i == 0 || j==0 )
                      value = 1;
                  else
                      value = m[i-1][j-1] +1;
              }
              m[i][j] = value;
              ret = Math.max(ret,value);
           }
       }
       return ret;
   }

    public static void main(String[] args) {
        System.out.println(maxSubstring("fish","zishg"));
    }
}
