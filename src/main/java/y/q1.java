package y;

public class q1 {
    public static  String compress(String s){
        if (s == null || s.length() == 0 ){
            return "";
        }
        int N = s.length();
        int cnt = 0;
        char prev = '#';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++ ){
            char ch = s.charAt(i);
            if ( i > 0 && ch != prev){
                sb.append(prev);
                if ( cnt != 1) {
                    sb.append(cnt);
                }
                cnt  = 0;
            }
            prev = ch;
            cnt++;
        }
        if ( cnt >= 1){
            sb.append(prev);
            if ( cnt != 1) {
                sb.append(cnt);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(compress("A"));
        System.out.println(compress("AA"));
        System.out.println(compress("AABB"));
        System.out.println(compress("AABBC"));
    }
}
