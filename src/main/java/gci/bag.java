package gci;

public class bag {
    public static double backpack(int W, String[] names, double[] costs, int[] weights) {
      double [][] matrix = new double[names.length+1][W+1];
      for(int i = 0; i < matrix.length; i++ ){
          for(int w = 0; w <= W; w++){
              if ( i == 0 || w == 0 ){
                 matrix[i][w] = 0;
              } else {
                  double prev = matrix[i-1][w];
                  double curr;
                  if (weights[i-1] <= w) {
                      curr = costs[i-1] + matrix[i - 1][(int) (w - weights[i-1])];
                  }else {
                      curr =  matrix[i-1][w];
                  }
                  matrix[i][w] = Math.max( curr, prev);
              }
          }
      }
      return matrix[names.length][W];
    }
    public static void main(String[] args) {
        int W = 4;
        String [] names   = new String[]{"магнитофон","notebook","gitar"};
        double [] costs   = new double[]{ 3000,2000,1500};
        int [] weights    = new int[]{ 4, 3, 1};
        System.out.println(backpack(W,names, costs, weights));
    }
}
