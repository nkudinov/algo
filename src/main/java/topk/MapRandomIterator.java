package topk;


import java.util.*;

class MapRandomIterator<T> implements Iterator<T> {
    private Map<T,Integer> freq;
    private Random rand;
    public MapRandomIterator( Map<T, Integer> freq) {
        this.freq = freq;
        this.rand = new Random();
    }

    @Override
    public boolean hasNext() {
        return freq.size() > 0;
    }

    @Override
    public T next() {
        int i = rand.nextInt(freq.keySet().size());
        for(T key: freq.keySet()){
            if ( i == 0){
                if ( freq.get(key) == 1){
                    freq.remove(key);
                } else {
                    freq.merge(key, -1, (a,b) -> a+b);
                }
                return key;
            }
            i--;
        }
        throw new NoSuchElementException();
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,3);
        map.put(2,2);
        MapRandomIterator<Integer> iter = new MapRandomIterator<>(map);
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}