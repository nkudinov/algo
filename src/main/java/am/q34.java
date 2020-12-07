package am;

import javafx.util.Pair;

import java.util.*;

public class q34 {
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
         Map<String,List<Pair<Integer,String>>> map1 = new HashMap<>();
         for(int i = 0 ; i < username.length; i++){
             map1.putIfAbsent(username[i], new ArrayList<>());
             map1.get(username[i]).add(new Pair<>(timestamp[i], website[i]));
         }
         Map<String,Integer> map2 = new HashMap<>();
         for(String name: map1.keySet()){
             List<Pair<Integer,String>> lst = map1.get(name);
             Collections.sort(lst,(a,b) -> a.getKey() - b.getKey());
             for(int i = 0; i < lst.size(); i++){
                 for(int j = i + 1; j < lst.size(); j++){
                     for(int k = j + 1; k < lst.size();k++){
                         String site1 = lst.get(i).getValue();
                         String site2 = lst.get(j).getValue();
                         String site3 = lst.get(k).getValue();
                         String key = site1 +"."+site2+"."+site3;
                         map2.merge(key,1,(a,b) -> a+b);
                     }
                 }
             }
         }
         String maxPath = "";
         int maxCount = Integer.MIN_VALUE;
         for(String path:map2.keySet()){
             if ( map2.get(path) > maxCount ||(  map2.get(path) == maxCount && path.compareTo(maxPath)   < 0 )){
                 maxCount = map2.get(path);
                 maxPath  = path;
             }
         }
         return Arrays.asList( maxPath.split("\\."));
    }
    /*
["zkiikgv","zkiikgv","zkiikgv","zkiikgv"]
[436363475,710406388,386655081,797150921]
["wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"]
wnaaxbfhxp, mryxsjc, wlarkzzqht
["oz","mryxsjc","wlarkzzqht"]

386655081
436363475
710406388
797150921
     */
    public static void main(String[] args) {
        String k1 = "oz";
        String k2 =  "wnaaxbfhxp";
        System.out.println(k1.compareTo(k2));
        System.out.println();
        String[] arr = new String[]{"zkiikgv","zkiikgv","zkiikgv","zkiikgv"};
        int[] times = new int[]{436363475,710406388,386655081,797150921};
        String[] sites = new String[]{"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"};
        System.out.println( mostVisitedPattern(arr, times, sites));
    }
}
