package c1;

public class q8 {
    public static boolean isRotation(String x, String y){
        if (x.length() == y.length() && x.length() > 0){
            return (x+y).indexOf(y) >0;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle","erbottlewat"));
    }
}
