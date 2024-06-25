package code_design.rate_limiter;

public interface RateLimitingStrategy {
    boolean allowRequest();
}
