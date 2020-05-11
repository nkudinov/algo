package c17;

public class q5 {
    public static final long MAXIMUM_PAGE_SIZE_BYTES = ((1L << 31) - 1) * 8L;
    public static void main(String[] args) {
        System.out.println(MAXIMUM_PAGE_SIZE_BYTES/1024/1024/1024);
    }

}
