package l100;

public class q67 {
    public static String mirrorEnds(String str) {
    int i = 0;
    int j = str.length() - 1;
    StringBuilder sb = new StringBuilder();
while(i <=j)

    {
        if (str.charAt(i) == str.charAt(j)) {
            sb.append(str.charAt(i));
            i++;
            j--;
        } else {
            break;
        }
    }
    return sb.toString();
}
    public static void main(String[] args) {
        String str= "abcOPGTcba";
        System.out.println(mirrorEnds(str));
    }

}
