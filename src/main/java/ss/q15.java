package ss;

public class q15 {
    static boolean  isSub(String s, String word){
        int N = s.length();
        int M = word.length();
        int j = 0;
        for(int i = 0; i < N && j < M; i++ ){
            if (s.charAt(i) == word.charAt(j)){
                j++;
            }
        }
        return j == M ;
    }
    public static int numMatchingSubseq(String s, String[] words) {
        int ans =0;
        for(String word:words){
            if (isSub(s, word)){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(numMatchingSubseq( "abcde", new String[]{"a","bb","acd","ace"}));

    }
}
