package lc.aug2020;

import java.util.HashMap;
import java.util.Map;

public class d5 {
    static class WordDictionary {
        static class Node {
            boolean isEnd;
            Map<Character,Node> childs;

            public Node() {
                this.childs = new HashMap<>();
                this.isEnd  = false;
            }
        }
        Node root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
           Node curr = root;
           for(Character ch:word.toCharArray()){
              if (curr.childs.containsKey(ch)){
                  Node node = curr.childs.get(ch);
                  curr = node;
              } else {
                  Node node = new Node();
                  curr.childs.put(ch, node);
                  curr = node;
              }
           }
           curr.isEnd = true;
        }
        private  boolean search(Node head, String word){
            if (word == null || word.length() == 0){
                if (head.isEnd){
                    return true;
                } else {
                    return false;
                }

            }
            char ch = word.charAt(0);
            Node curr = head;
            if ( ch == '.'){
               boolean ret = false;
               String rest = word.substring(1);
               for( Node node:head.childs.values()){
                   if ( search( node, rest)){
                       return true;
                   }
               }
               return false;
            } else {
              if (head.childs.containsKey(ch)){
                  return search( head.childs.get(ch), word.substring(1));
              } else {
                  return false;
              }
            }

        }
        public boolean search(String word) {
             return search(root, word);
        }
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
//["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search",//"search","search","search","search"]
//[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("."));
     //   System.out.println(wd.search("bad"));
     //   System.out.println(wd.search(".ad"));
    }
}
