package l100;

import java.util.*;

public class q58 {
    static public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Map<String,Integer> index1 = new HashMap<>();
        Map<Integer,String> index2 = new HashMap<>();
        for(int i = 0 ; i < products.length; i++){
            index1.put(products[i], i);
            index2.put(i, products[i]);
        }
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        for(String product: products){
            String prefix = "";

            for(int i = 0; i < product.length(); i++){
                prefix = product.substring(0, i+1);
                map.putIfAbsent( prefix, new PriorityQueue<>((a,b)-> index2.get(b).compareTo( index2.get(a))));
                PriorityQueue<Integer> q = map.get(prefix);
                q.add(index1.get(product));
                if (q.size() == 4){
                    q.poll();
                }
            }

        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < searchWord.length(); i++){
            String prefix = searchWord.substring(0, i+1);
            if (map.containsKey(prefix)){
                PriorityQueue<Integer> q = map.get(prefix);
                List<String> tmp = new ArrayList<>();
                while(!q.isEmpty()){
                    tmp.add(index2.get(q.poll()));
                }
                Collections.sort(tmp);
                ans.add(tmp);
            } else {
                ans.add(new ArrayList<>());
            }

        }
        return ans;
    }


    public static void main(String[] args) {
      String[] arr = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
      for(List<String> lst :suggestedProducts(arr,"mouse")){
          System.out.println(lst);
      }

    }
}
