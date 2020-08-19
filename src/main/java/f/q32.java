package f;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class q32 {
    Iterator<Character> iter = new Iterator<Character>() {
        private int index = -1;
        private List<Character> buff = new ArrayList<>();
        @Override
        public boolean hasNext() {
            if (buff.size() == 0){
                char[] buf4 = new char[4];
                int ret = 0;//read4(buf4);
                for(int i =0; i < ret; i++){
                    buff.add(buf4[i]);
                }
            }
            return buff.size() ==0;
        }

        @Override
        public Character next() {
            char ch = buff.get(0);
            buff.remove(0);
            return ch;
        }
    };
    public int read(char[] buf, int n) {
        int count = 0;
        while(iter.hasNext()){
            if (count == n){
                break;
            }
            buf[count] = iter.next();
            count++;

        }
        return count;
    }

    public static void main(String[] args) {

    }
}
