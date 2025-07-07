import static java.lang.Long.reverse;

public class isKaprekar {
    static boolean isKaprekar(int x) {
        if (x == 1) return true;

        long square = (long) x * x;
        String sqStr = String.valueOf(square);
        int len = sqStr.length();

        for (int i = 1; i < len; i++) {
            String leftPart = sqStr.substring(0, i);
            String rightPart = sqStr.substring(i);

            long left = Long.parseLong(leftPart);
            long right = Long.parseLong(rightPart);

            if (right != 0 && (left + right) == x) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 45, 55, 99, 297, 703, 999, 2223, 2728, 4879, 4950, 5050, 7272, 7777, 9999, 17344, 22222, 77778, 82656, 95121, 99999, 142857, 148149, 181819, 187110, 208495, 318682, 329967, 351352, 356643, 390313, 461539, 466830, 499500, 500500, 533170, 538461, 609687, 643357, 648648, 670033, 681318, 791505, 812890, 818181, 851851, 857143, 961038, 994708, 999999};
        for (int x : arr) {
            if (!isKaprekar(x)) {
                System.out.println("error, x=" + x);
            }
        }
        System.out.println(isKaprekar(45));
    }
}
