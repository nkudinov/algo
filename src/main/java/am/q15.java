package am;

import javafx.util.Pair;

import java.util.*;

public class q15 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word:wordList){
            int N = word.length();
            for(int i = 0; i < N; i++){
                String newWord  = word.substring(0,i) + "." + word.substring(i+1,N);
                map.putIfAbsent(newWord, new ArrayList<>());
                map.get(newWord).add(word);
               }
        }
//        for(String key:map.keySet()){
//            System.out.println(key+":"+ map.get(key));
//        }
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord, 0));
        Set<String> visited = new HashSet<>();
        while( !q.isEmpty() ){
            Pair<String,Integer> pair = q.poll();
            String word = pair.getKey();
            int level = pair.getValue();
            int N = word.length();
            for(int i = 0; i < N; i++){
                String newWord  = word.substring(0,i) + "." + word.substring(i+1,N);
                for( String nextWord:map.getOrDefault(newWord,new ArrayList<>())){
                    if (endWord.equals(nextWord)){
                        return level;
                    }
                    if (!visited.contains(nextWord)) {
                        q.add(new Pair<>(nextWord, level + 1));
                        visited.add(nextWord);
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log"});
        int ans =  ladderLength("hit","cog", wordList);
        System.out.println(ans);
    }
}
