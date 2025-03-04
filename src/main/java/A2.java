import java.util.*;

class A2 {
    // you can also use imports, for example:


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


    static boolean isValid(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            if (diff >= 2) {
                return false;
            }
        }
        return diff <= 1;
    }

    public static String solution(String[] words) {

        int n = words.length;
        int k = words[0].length();
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> mustUse = new HashMap<>();
        for (int i = 0; i < k; i++) {
            Map<Character, Integer> freq = new HashMap<>();
            for (String w : set) {
                freq.merge(w.charAt(i), 1, Integer::sum);
            }
            if (freq.keySet().size() != 1) {
                if (!mustUse.isEmpty()) {
                    for(char key:mustUse.keySet()) {
                        freq.merge(key, mustUse.get(key), Integer::sum);
                    }
                }
                char ch = freq.keySet().iterator().next();
                for (Character cur : freq.keySet()) {
                    if (freq.get(cur) > freq.get(ch)) {
                        ch = cur;
                    }
                }
                sb.append(ch);
                mustUse.clear();
                for(char key:freq.keySet()) {
                    if (key != ch ) {
                        mustUse.merge(key, freq.get(key), Integer::sum);
                    }
                }
            } else {
                sb.append(freq.keySet().stream().iterator().next());
            }

        }
        String res = sb.toString();
        for (String w : set) {
            if (!isValid(res, w)) {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println("ans=" + solution(new String[]{"bay", "zaz", "bab"}));
    }
}

