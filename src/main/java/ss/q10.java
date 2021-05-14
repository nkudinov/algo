package ss;

public class q10 {
    static String decrypt(String word) {
        // your code goes here
        //dnotq -> crime
        // 'z'(122) -> 97
        //a -> z
        //d -> c -> tempSum 100
        //n(110) -> (10) -> 114(r) // 110 - tempSum -> 10 += 26*4 114 -> n -> r // tempSum += 114 -> 214
        //o(111) 214 -> -103 -> 105 i // tempSum += 319

        //z -> a
        //aa (97) (96) += 26 -> z(122)
        //a(97) - 122 = -25 += 26 105 i
        //zi -> aa
        int len = word.length();//2
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int i = 0; i < len; i++) {
            int asciiValue = (int) word.charAt(i);
            int c = (asciiValue  - (i == 0 ? 1 : prev)); // i = 2, c = 111 - 214 = -103
            while (c < (int)'a') c += 26; // 122 105
            sb.append((char)c);//zi
            prev = asciiValue;//
        }
        return sb.toString();

    }
    static String decrypt1(String word) {

        if ( word == null || word.length() == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // 100	110	111	116	113
        int prev = 0 ;

        for(char ch:word.toCharArray()) {
            int asciiValue = (int) ch;
            if ( sb.length() == 0) {
                //O(N*N)
                if ( asciiValue == 97 ){
                    sb.append('z');
                } else {
                    sb.append((char)(asciiValue-1));
                }

            } else {
                asciiValue -= prev;
                while( asciiValue < 97){
                    asciiValue += 26;
                }
                sb.append((char)(asciiValue));
            }
            prev = (int)ch;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(decrypt1("aa"));
        //System.out.println((int)(char)(-90));
    }
}
