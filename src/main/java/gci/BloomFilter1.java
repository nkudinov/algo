package gci;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class BloomFilter1 {
    private byte[] set;
    private MessageDigest md;
    public BloomFilter1(int capacity) {
        set = new byte[capacity];
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException("can not find MessageDigest instance for MD5 ");
        }
    }
    private int getHash(int n){
        md.reset();
        byte[] bytes = ByteBuffer.allocate(4).putInt(n).array();
        md.update(bytes, 0, bytes.length);
        return Math.abs(new BigInteger(1, md.digest()).intValue()) % (set.length - 1);
    }
    private int[] getIndexes(int x){
       int[] ret = new int[32];
       for(int i=0; i < 32; i++){
           ret[i] = x % (set.length - 1);
           x = x >> 1;
       }
       return ret;
    }
    public void add(Object o){
       for(int index:getIndexes(o.hashCode())){
           set[index] = 1;
       }
    }
    public boolean contains(Object o){
        for(int index:getIndexes(o.hashCode())){
           if (set[index] == 0)
               return false;
        }
        return true;
    }
    public static void main(String[] args) {
       BloomFilter1 bf = new BloomFilter1(1024);
       Integer n1 = 10000;
       String  s1 = "hello";
       bf.add(n1);
       bf.add(s1);
       System.out.println(bf.contains(n1));
       System.out.println(bf.contains(s1));
        System.out.println(bf.contains(1111));
        System.out.println(bf.contains("world"));
    }
}
