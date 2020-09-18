import java.util.Arrays;

public class pramp {
    static boolean isOverlap(int[]  slotsA, int[]  slotsB){
        int l = Math.max(slotsA[0], slotsB[0]);
        int r = Math.min(slotsA[1], slotsB[1]);
        return r - l > 0;
    }

    // [[10, 50], [60, 120], [140, 210]]
    // [[ 0, 15], [60, 70]]
    //  dur = 8

    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int i = 0;
        int j = 0;
        while ( i < slotsA.length && j < slotsB.length){
            int l = Math.max(slotsA[i][0], slotsB[j][0]);
            int r = Math.min(slotsA[i][1], slotsB[j][1]);
            if (r - l >= dur){
                return new int[]{ l, l + dur};
            }
            if (  slotsA[i][1] > slotsB[j][1] ){
                j++;
            } else {
                i++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] slotA = new int[][]{{6,12}};
        int[][] slotB = new int[][]{{2,11}};
        int dur = 5;
        System.out.println(Arrays.toString(meetingPlanner(slotA, slotB, dur)));
        slotA = new int[][]{{1,10}};
        slotB = new int[][]{{2,3},{5,7}};
        dur = 2;
        System.out.println(Arrays.toString(meetingPlanner(slotA, slotB, dur)));

        slotA = new int[][]{{0,5},{50,70},{120,125}};
        slotB = new int[][]{{0,50}};
        dur = 8;
        System.out.println(Arrays.toString(meetingPlanner(slotA, slotB, dur)));

        slotA = new int[][]{{10,50},{60,120},{140,210}};
        slotB = new int[][]{{0,15},{60,70}};
        dur = 8;
        System.out.println(Arrays.toString(meetingPlanner(slotA, slotB, dur)));

        slotA = new int[][]{{10,50},{60,120},{140,210}};
        slotB = new int[][]{{0,15},{60,72}};
        dur = 12;
        System.out.println(Arrays.toString(meetingPlanner(slotA, slotB, dur)));
    }
}
