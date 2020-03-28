package sp.c4;

public class q4 {
    public static void main(String[] args) {
        int n =3;
        for(int mask =0; mask < (1<<n);mask++){
            System.out.print("{");
            for(int i = 0; i< n; i++){
                if ((mask & (1 << i)) > 0 )
                    System.out.print (" " +i + " ");
            }
            System.out.println("}");
        }
    }
}
