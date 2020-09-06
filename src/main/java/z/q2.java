package z;

public class q2 {
    static public String solution(String S) {
        if (S == null || S.length() <=1){
            return S;
        }
        String ret = S;
        while( true){
           String curr = ret;
           ret = ret.replaceFirst("AB","");
           ret = ret.replaceFirst("BA","");
           ret = ret.replaceFirst("CD","");
           ret = ret.replaceFirst("DC","");
           if (ret == null || curr.equals(ret)){
               break;
           }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBACD"));
        System.out.println(solution("ACBDACBD"));
        System.out.println(solution("CABABD"));
        System.out.println(solution("AB"));
    }
}
