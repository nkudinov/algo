package l100;

public class q40 {
    static boolean equals(char[] arr1,int i, int j, char[] arr2, int i2, int j2){
       if (j-i!=j2-i2){
           return false;
       }
       int k = 0;

       while(  i+k <= j){
           if (arr1[i+k] != arr2[i2+k]){
               return false;
           }
           k++;
       }
       return true;
    }
    static int calcHash(char[] arr, int i, int j){
        int ans = 0;
        for(int k = i ; k <=j; k++){
           ans = ans*10 + (arr[k]-'A'+1);
        }
        return ans;
    }
    static boolean isSubstring(String str, String s){
        int M = s.length();
        int pow = (int)Math.pow(10,M-1);
        int N = str.length();
        char sub[] = s.toCharArray();
        char[] arr = str.toCharArray();
        int subHash = calcHash( sub,0,M-1);
        int winHash = calcHash( arr,0,M-1);
        if (subHash == winHash && equals(arr,0, M-1, sub, 0, M-1)){
            return true;
        }
        for(int i = M; i < N; i++){
            int first = (arr[i-M]-'A'+1);
            int last  = (arr[i]-'A'+1);

            winHash = (winHash -first*pow)*10 + last;
            if (winHash == subHash && equals(arr,i-M+1, i, sub, 0, M-1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubstring("BAA","AA"));
        System.out.println(isSubstring("BDAAC","AAA"));
    }
}
