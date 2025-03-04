public class RateLimiter {

    private long lastRefreshTime;
    int refilInterval;
    int refilTokens;
    long maxTokens;
     long availableTokens;
    public RateLimiter(int refilInterval, int refilTokens, long maxTokens) {
        this.refilInterval = refilInterval;
        this.refilTokens = refilTokens;
        this.maxTokens = maxTokens;
        this.lastRefreshTime = System.nanoTime();
        this.availableTokens = maxTokens;
    }
    void refill(){
        long delta = System.nanoTime() - lastRefreshTime;
        if (delta > refilInterval) {
            availableTokens = Math.max(maxTokens, availableTokens + delta*refilTokens/refilInterval);
            lastRefreshTime = System.nanoTime();
        }
       
    }
    public boolean allowed(){
       refill();
       return availableTokens > 0;
    }
}
