package am;

import java.util.*;

public class q8 {
    public static  List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word: words){
            map.merge(word,1,(a,b) -> a + b);
        }
        Comparator<Map.Entry<String,Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if ( b.getValue() - a.getValue() != 0){
                    return  b.getValue() - a.getValue();
                } else {
                    return a.getKey().compareTo(b.getKey());
                }
            }
        };
        PriorityQueue<Map.Entry<String,Integer>> q = new PriorityQueue<>(cmp);
        for(Map.Entry<String,Integer> e: map.entrySet()){
            q.add(e);
        }
        List<String> ans = new ArrayList<>();
        for(int i = 1; i <=k; i++){
            ans.add(q.poll().getKey());
        }
        return ans;
    }
    public static  List<String> topKFrequentV2(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word: words){
            map.merge(word,1,(a,b) -> a + b);
        }
        List<String> arr = new ArrayList<>(map.keySet());
        Collections.sort( arr, (a, b) -> map.get(b)-map.get(a) != 0? map.get(b)-map.get(a) : a.compareTo(b));

        return arr.subList(0, k);
    }
    public static void main(String[] args) {
        for(String s:topKFrequentV2(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2)){
            System.out.println(s);
        };
    }

}
