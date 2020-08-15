package lc.f;

public class d1 {
    public static int myAtoi(String str) {
        if ( str == null || str.length()==0){
            return 0;
        }
        char[] arr = str.toCharArray();
        int i = 0;
        while(i < str.length() && arr[i] == ' '){
            i++;
        }

        if (i < str.length() && (arr[i] == '+' || arr[i] =='-' || Character.isDigit(arr[i]))){
            int sign = 1;
            if (arr[i] == '+'){
                i++;
            } else if (arr[i] == '-'){
                sign = -1;
                i++;
            }
            long ret = 0;
            while (i < arr.length && Character.isDigit(arr[i])) {
                char ch = arr[i];
                int value = ch-'0';
                ret = ret*10 + value;
                i++;
                if ( sign*ret > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if ( sign*ret < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
            return sign*((int)ret);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("  "));
    }

}
