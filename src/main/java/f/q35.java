package f;

public class q35 {
    static public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if ( sLen > tLen){
            return isOneEditDistance(t,s);
        }
        if (tLen - sLen > 1){
            return false;
        }
        for(int i = 0; i < sLen; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if ( ch1 != ch2){
                if ( sLen == tLen){
                    return s.substring(i+1).equals(t.substring(i+1));
                } else {
                    //a,b,c,f
                    //a,  d,c
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return (sLen + 1 == tLen);
    }
    public static void main(String[] args) {
        System.out.println(isOneEditDistance("a",""));
    }

}
