package c7;

public class q3 {
    public static class Line {
        private static double epsilon = 0.000001;
        private double k ;
        private double b;

        public Line(double k, double b) {
            this.k = k;
            this.b = b;
        }
        public boolean intersect(Line line2){
           return Math.abs(this.k - line2.k) > epsilon || Math.abs(line2.b -this.b) < epsilon;
        }
    }

    public static void main(String[] args) {
       Line l1 = new Line(1,1);
       Line l2 = new Line(2,2);
       Line l3 = new Line(1,2);

       System.out.println(l1.intersect(l2));
       System.out.println(l1.intersect(l3));
    }

}
