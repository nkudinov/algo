package am;

import java.util.*;

public class q36 {
    static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for(String word:wordDict){
            words.add(word);

        }
        return DFS(s, words, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
    public static void main(String[] args) {
       String[] arr = new String[]{"cat","cats","and","sand","dog"};
       for(String path: wordBreak("catsanddog", Arrays.asList(arr) )){
           System.out.println(":"+path);
       }
    }


}
