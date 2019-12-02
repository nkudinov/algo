package gci;

public class SimpleKNN {
    private static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean classify( Point p, int k){

        return true;
    }
    public static void main(String[] args) {

        System.out.println(classify(new Point(1,1),5));
    }

}
