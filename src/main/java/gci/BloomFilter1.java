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
    public void add(Object o){
       int index = getHash(o.hashCode());
       set[index]= 1;
    }
    public boolean contains(Object o){
       int index = getHash(o.hashCode());
       return set[index]== 1;
    }
    public static void main(String[] args) {
       BloomFilter1 bf = new BloomFilter1(1024);
       Integer n1 = 10000;
       bf.add(n1);
       System.out.println(bf.contains(n1));
    }
}
