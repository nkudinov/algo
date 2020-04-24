package c16;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class q6 {
 static class Foo {
   CountDownLatch l1 = new CountDownLatch(1);
   CountDownLatch l2 = new CountDownLatch(1);
   public void  first(){
       System.out.println("first");
       l1.countDown();


   }
   public void second(){
     try {
         l1.await();
         System.out.println("second");
         l2.countDown();
     } catch (Exception e){

     }
   }
   public void third()  {
      try {
          l2.await();
          System.out.println("third");
      } catch (Exception e){

      }
   }
 }
  static class Worker1 extends Thread {
      Foo foo;
      public Worker1(Foo foo) {
          this.foo = foo;
      }

      @Override
      public void run() {
          foo.first();
      }
  }
    static class Worker2 extends Thread {
        Foo foo;
        public Worker2(Foo foo) {
           this.foo = foo;
        }

        @Override
        public void run() {
           foo.second();
        }
    }
    static class Worker3 extends Thread {
        Foo foo;
        public Worker3(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            foo.third();
        }
    }
    public static void main(String[] args) throws Exception  {
        Foo foo = new Foo();
        Worker3 w3 = new Worker3(foo);
        w3.start();

        Worker2 w2 = new Worker2(foo);
        w2.start();

        Worker1 w1 = new Worker1(foo);
        w1.start();

        w3.join();
        w1.join();
        w2.join();

    }
}
