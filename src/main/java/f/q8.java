package f;

public class q8 {
    static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for(char ch:input.toCharArray()){
            char newChar = ch;
            if ( ch >='A' && ch <= 'Z') {
                newChar = (char) ('A' + (ch - 'A' + rotationFactor) % 26);
            } else if (ch >='a' && ch <= 'z')  {
                newChar = (char) ('a' + (ch - 'a' + rotationFactor) % 26);
            } else if ( ch >='0' && ch <='9'){
                newChar = (char)('0' + (ch -'0' + rotationFactor)%10);
            }
            sb.append(newChar);
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        //System.out.println(rotationalCipher("All-convoYs-9-be:Alert1.",4));
    }
}
