package l100;

public class q38 {
    public static boolean checkStraightLine(int[][] coordinates) {
        //y1 = k*x1 + b
        //y2 = k*x2 + b
        //y1 = k*x1 + y2-k*x2 => y1 = k*(x1-x2) => k = y1-y2/x1-x2
        //(y1 -b)*x2 = (y2-b)*x1
        //y1*x2 -b*x2 = y2*x1 - b*x1
        //y1*x2 -y2*x1 = b(x2-x1)
        // b = (y1*x2-y2*x1)/(x2-x1)
        // [ [0,0],[0,1],[0,-1]]
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        double k = (y1-y2)*1.0/(x1-x2);

        double b = (y1*x2-y2*x1)*1.0/(x2-x1);

        for(int[] c:coordinates){
            if (Double.isInfinite(k)){
                if (c[0] != 0){
                    return false;
                }
            } else  if (c[1]*1.0 != k *c[0]+b){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0},{0,1},{0,-1}};
        System.out.println(checkStraightLine(points));

    }


}
