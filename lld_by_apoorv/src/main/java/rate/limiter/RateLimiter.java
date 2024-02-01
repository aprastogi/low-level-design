package rate.limiter;

public interface RateLimiter {

    // This method will return true if user to allowed to hit the request at this moment or not
    boolean isAllowed(String userId);
}
