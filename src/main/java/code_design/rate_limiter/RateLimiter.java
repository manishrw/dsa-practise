package code_design.rate_limiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    Map<String, RateLimitingStrategy> strategies;
    private final int LIMIT = 10;
    private final int INTERVAL = 60;

    public RateLimiter() {
        strategies = new HashMap<>();
    }

    public boolean allowRequest(String resource) {
        strategies.computeIfAbsent(resource, k -> new FixedWindowCounter(LIMIT, INTERVAL));
        return strategies.get(resource).allowRequest();
    }
}
