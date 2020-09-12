package g;

import java.util.*;

public class q15 {
    static class AutocompleteSystem {

        static class Trie {
            Map<Character,Trie> childs;
            int count;

            public Trie() {
                this.childs = new HashMap<>();
                this.count  = 0;
            }
        }
        static class Pair {
            String str;
            int count;

            public Pair(String str, int count) {
                this.str = str;
                this.count = count;
            }
        }

        Trie root;
        Trie curr;
        String str ="";

        private Trie insert(Trie root, char ch){
            if (root.childs.containsKey(ch)){
                return root.childs.get(ch);
            } else {
                Trie node = new Trie();
                root.childs.put(ch, node);
                return node;
            }
        }

        public void insert(Trie root, String sentence, int count){
            Trie curr = root;
            for(int i = 0; i < sentence.length();i++){
                curr = insert( curr, sentence.charAt(i));
            }
            curr.count = curr.count+count;
        }

        public AutocompleteSystem(String[] sentences, int[] times) {
           root = new Trie();
           curr = root;
           for(int i = 0; i < sentences.length; i++){
               insert(root, sentences[i] , times[i]);
           }
        }
        private void helper( List<Pair> acc, Trie node, String str){
            if (node.childs.size() == 0 || node.count!=0){
                acc.add(new Pair(str, node.count));
            }
            for(Map.Entry<Character,Trie> e:node.childs.entrySet()){
                helper(acc, e.getValue(),str+e.getKey());
            }
        }
        private  List<String> getList(String prefix, Trie node){
            List<String> ret = new ArrayList<>();
            if (node == null){
                return ret;
            }
            List<Pair> acc = new ArrayList<>();
            helper( acc , node, prefix);
            Collections.sort( acc, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o1.count == o2.count){
                        return o1.str.compareTo(o2.str);
                    }
                    return o2.count - o1.count;
                }
            });

            for(int i = 0; i < acc.size() && i < 3; i++){
                ret.add( acc.get(i).str);
            }
            return ret;

        }
        public List<String> input(char c) {

            if ( c== '#'){
              insert( root, str, 1);
              str = "";
              curr = root;
              return new ArrayList<>();
            } else {
                str = str + c;
            }

            if (curr != null && curr.childs.containsKey(c)){
                curr = curr.childs.get(c);
            } else {
                curr = null;
            }
            return getList(str, curr);
        }
    }

    public static void main(String[] args) {
        String[] sentences = new String[] {"abc","abbc","a"};
        int[] times = new int[]{3,3,3};
        AutocompleteSystem ac = new AutocompleteSystem(sentences, times);
        for(String s:ac.input('a')){
            System.out.println(s);
        }

    }
}
