package c7;

public class q3 {
    public static class Line {
        private static double epsilon = 0.000001;
        private double slope ;
        private double yintersept;

        public Line(double slope, double yintersept) {
            this.slope = slope;
            this.yintersept = yintersept;
        }
        public boolean intersect(Line line2){
           return Math.abs(this.slope - line2.slope) >epsilon || Math.abs(line2.yintersept -this.yintersept) < epsilon;
        }
    }

    public static void main(String[] args) {
       Line l1 = new Line(1,1);
       Line l2 = new Line(2,2);
       System.out.println(l1.intersect(l2));
    }

}
