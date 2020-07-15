package lc.July2020;

public class d14 {
    static public double angleClock(int hour, int minutes) {
       double hDegree = (hour*5%60)*6+(minutes/12.0*6);
       double mDegree = (minutes%60)*6;
       return mDegree - hDegree;
    }
    public static void main(String[] args) {
        System.out.println( angleClock(12,30));
    }
}
