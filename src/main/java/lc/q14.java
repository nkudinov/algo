package lc;

public class q14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
      String str = "";
      String ret = "";
      for(Character c:strs[0].toCharArray()){
          str = str + c;
          boolean found = true;
          for(int i =1; i< strs.length;i++){
            if (!strs[i].startsWith(str)){
                found = false;
            }
          }
          if (found){
              if (str.length() > ret.length())
                  ret = str;
          } else {
              return ret;
          }
      }
      return ret;
    }

    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));
    }
}
