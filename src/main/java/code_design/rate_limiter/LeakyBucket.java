package code_design.rate_limiter;

import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket implements RateLimitingStrategy {
    private final int capacity;
    private final int leakRate;
    private Queue<Integer> bucket;
    private long lastLeakTime;

    public LeakyBucket(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.lastLeakTime = System.currentTimeMillis();
        this.bucket = new LinkedList<>();
    }

    @Override
    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastLeakTime;

        // Leak the appropriate amount from the bucket
        for (int i = 0; i < elapsedTime * leakRate / 1000 && !bucket.isEmpty(); i++) {
            bucket.poll();
        }

        // If the bucket is not full, add new request to the bucket
        if (bucket.size() < capacity) {
            bucket.add(1);
            lastLeakTime = currentTime;
            return true;
        }

        // If the bucket is full, deny the request
        return false;
    }
}
