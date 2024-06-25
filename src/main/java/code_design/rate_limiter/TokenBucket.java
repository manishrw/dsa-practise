package code_design.rate_limiter;

public class TokenBucket implements RateLimitingStrategy {

    private final int maxTokens;
    private final int refillRate;
    private int tokens;
    private long lastRefillTime;

    public TokenBucket(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.tokens = maxTokens;
        this.lastRefillTime = System.currentTimeMillis();
    }

    @Override
    public boolean allowRequest() {
        refillTokens();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refillTokens() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastRefillTime;
        int tokensToAdd = (int) (elapsedTime * refillRate / 1000);
        tokens = Math.min(tokens + tokensToAdd, maxTokens);
        lastRefillTime = currentTime;
    }
}
