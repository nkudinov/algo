package z;

public class dd {

    static String decrypt(String word) {

        if ( word == null || word.length() == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // 100	110	111	116	113
        int prev =0;

        for(char ch:word.toCharArray()) {
            int asciiValue = (int) ch;
            if ( sb.length() == 0) {

                if ( asciiValue == 97 ){
                    sb.append('z');
                } else {
                    sb.append((char)(asciiValue-1));
                }

            } else {
                int firstValue = (int) word.charAt(0);
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
        System.out.println( decrypt("dnotq") );
    }
}
