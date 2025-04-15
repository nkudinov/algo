import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public class CompletableFuture<T>  {
    private volatile T value = null;
    private final Lock lock = new ReentrantLock();
    private final Condition isCompleted = lock.newCondition();
    private boolean completed = false;

    public CompletableFuture(Supplier<T> supplier) {
        if (supplier == null) throw new IllegalArgumentException("Supplier cannot be null");
        new Thread(() -> {
            T result = supplier.get();
            complete(result);
        }).start();
    }
java.util.concurrent.CompletableFuture()
    public void complete(T obj) {
        lock.lock();
        try {
            if (completed) {
                throw new IllegalStateException("Value already completed");
            }
            value = obj;
            completed = true;
            isCompleted.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T get() throws InterruptedException {
        lock.lock();
        try {
            while (!completed) {
                isCompleted.await();
            }
            return value;
        } finally {
            lock.unlock();
        }
    }

    public boolean isDone() {
        lock.lock();
        try {
            return completed;
        } finally {
            lock.unlock();
        }
    }


    public static <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        return new CompletableFuture<>(supplier);
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> f = new CompletableFuture<>( ()->{return "hello";});
        System.out.println(f.get());
    }
}
