package f;

public class q44 {
    static public boolean isMatch1(String s, String p) {
        if (p.isEmpty()){
            return s.isEmpty();
        }
        boolean firstMatch = (!s.isEmpty()&&(s.charAt(0) == p.charAt(0) || (p.charAt(0)=='.')));
        if (p.length() >=2 && p.charAt(1)=='*'){
            return (isMatch1(s,p.substring(2))) || (firstMatch && (isMatch1(s.substring(1),p)));
        } else {
            return firstMatch && isMatch1(s.substring(1),p.substring(1));
        }
    }

    static public boolean isMatch2(String text, String pattern){
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch2(text, pattern.substring(2)) ||
                    (first_match && isMatch2(text.substring(1), pattern)));
        } else {
            return first_match && isMatch2(text.substring(1), pattern.substring(1));
        }
    }
    static public boolean isMatch3(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch3(text, pattern.substring(2)) ||
                    (first_match && isMatch3(text.substring(1), pattern)));
        } else {
            return first_match && isMatch3(text.substring(1), pattern.substring(1));
        }
    }
    public static void main(String[] args) {
        System.out.println(isMatch1("aa",".*"));

     //   System.out.println(isMatch2("aa",".*"));
      //  System.out.println(isMatch3("aa",".*"));
    }
}
