package f;

import java.util.Arrays;

public class q9 {
    static long getDayUsers(int day, float[] growthRates){
        long count = 0;
        for(float r:growthRates){
            count += (long) Math.pow(r,day);
        }
        return count;
    }
    static int getStartDay(int value, float[] growthRates){
        float m = growthRates[0];
        for(float e:growthRates){
            if ( e>m){
                m = e;
            }
        }
       return (int)(Math.log(value/growthRates.length)/Math.log(m));
    }
    static int getBillionUsersDay(float[] growthRates) {
        int value = 1_000_000_000;
        int day = getStartDay(value, growthRates);
        long total = 0;
        while ( total < value){
            total = getDayUsers( ++day, growthRates);
        }
        return day;
    }
    public static void main(String[] args) throws Exception {
       // System.out.println(getBillionUsersDay2(new float[]{1.01f, 1.02f}));
        //System.out.println(getBillionUsersDay(new float[]{1.01f, 1.02f}));
        //1.1f, 1.2f, 1.3f

        System.out.println(Math.log(1_000_000_000/3)/Math.log(1.1f));

    }
}
