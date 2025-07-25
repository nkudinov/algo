import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        System.out.println("Main thread: " + Thread.currentThread().getName());

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("runAsync: " + Thread.currentThread().getName());
        }, executorService);

        CompletableFuture<Object> finalFuture = future.thenApply(unused -> {
            System.out.println("thenApply: " + Thread.currentThread().getName());
            return null;
        }).exceptionallyAsync(
                throwable -> {
                    System.out.println("exceptionallyAsync: " + Thread.currentThread().getName());
                    return null;
                }
        ).whenComplete((unused1, unused2) -> {
            System.out.println("whenComplete: " + Thread.currentThread().getName());
        });

        // Ждем завершения всей цепочки
        // Ждем завершения всей цепочки
        finalFuture.join();

        System.out.println("After join: " + Thread.currentThread().getName());

        Thread.sleep(100);

        System.out.println("After sleep: " + Thread.currentThread().getName());

        executorService.shutdown();


    }
}
