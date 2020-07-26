package lc.July2020;

public class d28 {
    public int addDigits(int num) {
        int ret = num;
        while(ret >= 10){
            int x = ret;
            ret = 0;
            while(x > 0 ){
                ret = ret + x%10;
                x = x/10;
            }
        }
        return ret;
    }
}
