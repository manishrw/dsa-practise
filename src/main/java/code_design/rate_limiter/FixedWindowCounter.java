package code_design.rate_limiter;

/**
 * FixedWindowCounter is a rate limiting strategy that uses the fixed window counter algorithm.
 * It allows a certain number of requests within a fixed time interval.
 * Once the limit is reached, all further requests are denied until the next interval starts.
 */
public class FixedWindowCounter implements RateLimitingStrategy {

    private final int limit;
    private final int intervalInSeconds;
    private long startTime;
    private int counter;

    /**
     * Constructs a new FixedWindowCounter with the specified limit and interval.
     *
     * @param limit The maximum number of requests allowed within the interval.
     * @param intervalInSeconds The length of the interval in seconds.
     */
    public FixedWindowCounter(int limit, int intervalInSeconds) {
        this.limit = limit;
        this.intervalInSeconds = intervalInSeconds;
        this.startTime = System.currentTimeMillis() / 1000;
        this.counter = 0;
    }

    /**
     * Determines whether a request should be allowed or denied based on the rate limit.
     * If the current time is within the interval from the start time, and the counter is less than the limit,
     * the request is allowed and the counter is incremented.
     * If the current time is outside the interval, the counter and start time are reset, and the request is allowed.
     * If the counter has reached the limit, the request is denied.
     *
     * @return true if the request is allowed, false otherwise.
     */
    @Override
    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis() / 1000;
        if (currentTime - startTime >= intervalInSeconds) {
            startTime = currentTime;
            counter = 1;
            return true;
        } else {
            if (counter < limit) {
                counter++;
                return true;
            }
            return false;
        }
    }
}
