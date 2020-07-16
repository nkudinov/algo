package f;

public class q1 {
    enum Direction {
        asc,
        desc,
        notdetected
    }
    static boolean isMonotomic(int[] arr){
        if (arr == null || arr.length == 0 || arr.length == 1){
            return true;
        }
        Direction direction = Direction.notdetected;
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (prev == arr[i] ) {

            } else if (prev > arr[i]){
                if (direction == Direction.notdetected){
                    direction = Direction.desc;
                } else if (direction == Direction.asc){
                    return false;
                }
            } else {
                if (direction == Direction.notdetected){
                    direction = Direction.asc;
                } else if (direction == Direction.desc){
                    return false;
                }
            }
            prev = arr[i];
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isMonotomic(new int[]{3,3,4}));

    }
}
