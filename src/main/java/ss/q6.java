package ss;

import javax.xml.bind.SchemaOutputResolver;

public class q6 {
    public static int maximumGain(String s, int x, int y) {
        int ans = 0;
        int prev = -1;
        while( ans != prev){
            prev = ans;
            if ( x > y){
                while(s.indexOf("ab") >=0){
                    s = s.replaceFirst("ab","");
                    ans += x;
                }
            } else {
                while(s.indexOf("ba") >=0){
                    s = s.replaceFirst("ba","");
                    ans += y;
                }
            }

        }
        System.out.println(s);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumGain("ab",4,5));
    }

}
