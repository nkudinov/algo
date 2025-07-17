import java.util.*;
import java.util.concurrent.*;

class FrameSampler {

    private final Map<List<String>, Integer> stackSamples = new HashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private int sampleCount = 0;

    public void startSampling(long intervalMillis, int totalSamples) {
        Runnable sampleTask = () -> {
            sampleStackTraces();
            sampleCount++;
            if (sampleCount >= totalSamples) {
                scheduler.shutdown();
                System.out.println("\n✅ Sampling finished. Stack traces (like flamegraph):\n");
                printFlameLikeOutput();
            }
        };

        scheduler.scheduleAtFixedRate(sampleTask, 0, intervalMillis, TimeUnit.MILLISECONDS);
    }

    private void sampleStackTraces() {
        Map<Thread, StackTraceElement[]> allStacks = Thread.getAllStackTraces();

        for (Map.Entry<Thread, StackTraceElement[]> entry : allStacks.entrySet()) {
            StackTraceElement[] stack = entry.getValue();
            List<String> stackList = new ArrayList<>();

            // Build from root (bottom of stack) to top
            for (int i = stack.length - 1; i >= 0; i--) {
                stackList.add(stack[i].toString());
            }

            // You may optionally filter system threads here
            stackSamples.merge(stackList, 1, Integer::sum);
        }
    }

    private void printFlameLikeOutput() {
        List<Map.Entry<List<String>, Integer>> sortedStacks = new ArrayList<>(stackSamples.entrySet());

        // Sort by frequency (most common stacks on top)
        sortedStacks.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<List<String>, Integer> entry : sortedStacks) {
            List<String> stack = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < stack.size(); i++) {
                String indent = "  ".repeat(i);
                System.out.println(indent + stack.get(i));
            }
            System.out.println("  ".repeat(stack.size()) + "↑ [" + count + " samples]\n");
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.submit(() -> {
            int a = 1; int b = 1;
            for (int i = 0; i < 10000000; i++) {
                try {
                    Thread.sleep(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            executorService.shutdown();
        });
        FrameSampler sampler = new FrameSampler();
        sampler.startSampling(1, 2000); // 10ms interval, 200 samples (~2 sec)
    }
}
