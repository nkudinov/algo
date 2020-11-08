package am;




import java.util.*;

public class q4 {
    public static  String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<String>();
        for(String word:banned){
            set.add(word);
        }
        String[] words =  paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
        System.out.println(Arrays.toString(words));
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            if (!set.contains(word) && word.length()!=0){
                map.merge(word,1, (a,b) -> a + b  );
            }
        }
        Integer maxValue = 0;
        String  maxKey   = "";
        for(Map.Entry<String,Integer> e:map.entrySet()){
            if ( e.getValue() > maxValue){
                maxValue = e.getValue();
                maxKey   = e.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
      String str = "Bob hit a ball, the hit BALL flew far after it was hit.";
        System.out.println(mostCommonWord(str,new String[] {"hit"}));
    }
}
