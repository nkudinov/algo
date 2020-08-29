package f;

public class q39 {
    public static  String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int [] pos = new int [n+m];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < pos.length ;i++) {
            if (i == 0){
                if (pos[0]!=0){
                    sb.append(pos[i]);
                }
            }  else {
                sb.append(pos[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(multiply("9","99"));
    }
}
