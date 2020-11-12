package am;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q6 {

    private PriorityQueue<Integer> minQ;
    private PriorityQueue<Integer> maxQ;

    public q6() {
        minQ = new PriorityQueue<>();
        maxQ = new PriorityQueue<>( (a,b) -> b-a );
    }

    public void addNum(int num) {
        if ( maxQ.size() == 0){
            maxQ.add(num);
        } else {
            if (maxQ.peek() > num){
                maxQ.add(num);
            } else {
                minQ.add(num);
            }

            if (maxQ.size() > minQ.size()){
              minQ.add(maxQ.poll());
            } else if (maxQ.size() < minQ.size()) {
              maxQ.add(minQ.poll());
            }
        }
    }

    public double findMedian() {

        String s1 = Arrays.toString(minQ.toArray(new Integer[minQ.size()]));
        String s2 = Arrays.toString(maxQ.toArray(new Integer[maxQ.size()]));
        System.out.println("maxQ=" + s2);
        System.out.println("minQ=" + s1);

        if (maxQ.size() == minQ.size()) {
            return (minQ.peek() + maxQ.peek()) / 2.0;
        } else if (maxQ.size() > minQ.size()) {
            return maxQ.peek() * 1.0;
        } else {
            return minQ.peek();
        }

    }

    public static void main(String[] args) {
        q6 q = new q6();
        int[] arr = new int[]{-1,-2,-3};
        for(int x:arr){
            q.addNum(x);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(q.findMedian());
    }

}
