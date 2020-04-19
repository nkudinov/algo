import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class p13 {
    static class Chopstick {
        private Lock lock;

        public Chopstick() {
            this.lock = new ReentrantLock();
        }

        boolean take(int millis){
            try{
                Thread.sleep(millis);
            }catch (Exception e){

            }

            return lock.tryLock();
        }

       void drop(){
          lock.unlock();
       }

    }
    static class Person extends Thread {
        private Random random;
        private int bites = 201;
        private Chopstick right;
        private Chopstick left;
        private int id;
        private int count = 0;

        public Person(int id, Random random) {
            this.id    = id;
            this.random = random;
        }

        public void addChopstick(Chopstick right,Chopstick left){
            this.right = right;
            this.left  = left;
        }

        @Override
        public void run() {
            eat();
        }

        public void eat() {
            while( count < bites) {
                if (left.take(random.nextInt(100))) {
                    if (right.take(random.nextInt(100))) {
                        System.out.println("eat " + id);
                        right.drop();
                    }
                    left.drop();
                    count++;
                }

            }
        }

    }
    static class CircularTable {
        private int n;
        private Person[] persons;
        private Chopstick[] chopsticks;
        private Random rand;
        public CircularTable(int n) {
            this.n = n;
            persons = new Person[n];
            chopsticks = new Chopstick[n];
            rand = new Random(100);
        }

        public void fill() {
            for(int i = 0; i < n; i++){
                persons[i] = new Person(i, rand);
                chopsticks[i] = new Chopstick();
            }
           for( int i = 0; i < n ; i++){
               persons[i].addChopstick( chopsticks[i], chopsticks[(i+1)%n]);
           }
        }
        public void start() throws Exception {
            for( int i=0; i < n; i ++ ){
                persons[i].start();
            }
            for( int i=0; i < n; i ++ ){
                persons[i].join();
            }
           }

    }
    public static void main(String[] args) throws Exception  {
        CircularTable t = new CircularTable(100);
        t.fill();
        t.start();
        System.out.println("finish");
    }
}
