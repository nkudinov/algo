package l100;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class q62 {
    public static class Codec {
        Map<String,String> map = new HashMap<>();
        MessageDigest md;
        Codec(){
            try {

                md = MessageDigest.getInstance("MD5");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        public String shorturl(String str){
            md.update(str.getBytes());
            return Base64.getEncoder().encodeToString(md.digest()).substring(10);
        }
        public String encode(String longUrl) {
              int i = 0;
              String ans = shorturl(longUrl);
              while(map.containsKey(ans) ){
                  i++;
                  ans = shorturl(longUrl + i);
              }
              return  ans;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }
    public static void main(String[] args) throws Exception {
        Codec c = new Codec();
        System.out.println(c.encode("3"));
        System.out.println(c.encode("10"));



    }
}
