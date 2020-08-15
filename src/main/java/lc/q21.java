package lc;

public class q21 {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            if (strs[i].length() < minLen){
                minLen = strs[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < minLen; i++){
            char ch = strs[0].charAt(i);
            boolean flag = true;
            for(int j = 0; j <strs.length; j++){
                if (strs[j].charAt(i)!=ch){
                    flag = false;
                }
            }
            if (flag){
                sb.append(ch);
            } else {
                break;
            }
        }
       return sb.toString();
    }
    public static void main(String[] args) {

    }
}
