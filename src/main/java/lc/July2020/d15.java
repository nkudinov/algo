package lc.July2020;

public class d15 {
    static public String reverseWords(String s) {
       if( s==null || s.length() == 0){
           return s;
       }
       String[] arr=  s.split(" ");
       StringBuilder sb = new StringBuilder();
       for(int i = arr.length-1;i >=0;i--){
           String e = arr[i].trim();
           if (e!=null && e.length()!=0){
               sb.append(e+" ");
           }
       }
       return sb.toString().trim();
    }
    public static void  main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
