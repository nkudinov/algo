package rest;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ConsistentHash {
    static class Tuple implements Comparable<Tuple> {
        int machine;
        int replica;
        double hash;

        public Tuple(int machine, int replica, double hash) {
            this.machine = machine;
            this.replica = replica;
            this.hash = hash;
        }

        @Override
        public int compareTo(@NotNull Tuple t) {
            if (t.hash == this.hash)
                return 0;
            else if (this.hash>t.hash)
                return 1;
            else
                return -1;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "machine=" + machine +
                    ", replica=" + replica +
                    ", hash=" + hash +
                    '}';
        }
    }
    int numMachines;
    int numReplicas;
    List<Tuple>  hashTuples;

    public ConsistentHash(int numMachines, int numReplicas) throws Exception {
        this.numMachines = numMachines;
        this.numReplicas = numReplicas;
        hashTuples = new LinkedList<>();
        for(int i = 0; i < numMachines; i++){
            for(int j = 0; j < numReplicas; j++){
                hashTuples.add(new Tuple( i, j, hash(i+"_"+j)));
            }
        }
        Collections.sort(hashTuples);
    }
    public void print(){
        System.out.println(hashTuples.toString());
    }
    /*
    return hash in range[0,1)
     */
    public static double hash(String key) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(key.getBytes("UTF-8"));
        return (new BigInteger(thedigest).intValue()% 1000000)/1000000.0;
    }
    public int getMachine(String key){
         return 0;
    }
    public static void main(String[] args) throws Exception {
        ConsistentHash ch = new ConsistentHash(7,3);
        ch.print();
        System.out.println(hash("1"));
    }
}
