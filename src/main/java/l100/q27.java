package l100;

import java.util.Arrays;

public class q27 {
    static class  Car {
        int position;
        double time;
        Car(int position, double time){
            this.position = position;
            this.time     = time;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "position=" + position +
                    ", time=" + time +
                    '}';
        }
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];
        for(int i  = 0 ; i < N ; i++){
            cars[i] = new Car(position[i], (target-position[i])*1.0/speed[i]);
        }
        Arrays.sort(cars, (a, b) -> a.position - b.position);
        System.out.println(Arrays.toString(cars));
        int t = N-1;
        int ans  = 0;
        while(t > 0){
            if ( cars[t].time <= cars[t-1].time ){
                ans++;
            } else {
                cars[t-1] = cars[t];
            }
            t--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(carFleet(12 , new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
    }

}
