package f;

public class q13 {
    static String findEncryptedWord(String s) {
        if (s.length() <=1){
           return s;
        }

        int mid = s.length()/2;
        if (s.length()%2==0) {
            mid--;
        }
        String s1 = s.substring(mid,mid+1);
        String s2 = findEncryptedWord(s.substring(0,mid));
        String s3 =findEncryptedWord(s.substring(mid+1));
        return s1+s2+s3;
    }
    public static void main(String[] args) {
     //   System.out.println(findEncryptedWord("a"));
      //  System.out.println(findEncryptedWord("abc"));
        System.out.println(findEncryptedWord("abcd"));
    }
}
