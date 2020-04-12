package rest;
import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class u {
    public static void main(String[] args) throws Exception {
        Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
        unsafeConstructor.setAccessible(true);

        Unsafe unsafe =unsafeConstructor.newInstance();
        long address = unsafe.allocateMemory(4L);
        int[] arr = new int[10];
        int offset = unsafe.arrayBaseOffset(byte[].class);
        unsafe.putInt(null,offset+8, 110);
       // System.out.println(Arrays.toString(arr));
    }
}
