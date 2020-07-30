package f;

public class q14 {
    static boolean canGetExactChange(int targetMoney, int[] denominations) {
       if (targetMoney == 0){
           return true;
       } else if ( targetMoney < 0){
           return false;
       } else {
          for(int i = 0; i < denominations.length; i++){
              if (canGetExactChange(targetMoney - denominations[i], denominations)){
                  return true;
              }
          }
          return false;
       }

    }
    public static void main(String[] args) {
        System.out.println( canGetExactChange(94, new int[]{4, 17, 29}));
    }
}
