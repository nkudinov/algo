package lc.aug2020;

public class d13 {
    private static String gen(String characters, int bits){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < characters.length(); i++){
            int bit = (bits & (1 << i));
            if ( bit == 1){
                sb.append(characters.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(gen("abc",3));
    }

}
