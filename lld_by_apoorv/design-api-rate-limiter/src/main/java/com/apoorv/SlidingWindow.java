package com.apoorv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindow implements RateLimiter{

    private final Map<String, List<Long>> requestTimestampMap;
    private final int maxRequests;
    private final long windowInSeconds;

    SlidingWindow(int maxRequest, long windowInSeconds){
        this.requestTimestampMap = new HashMap<>();
        this.maxRequests = maxRequest;
        this.windowInSeconds = windowInSeconds;
    }

    @Override
    public boolean isAllowed(String userId) {
        long currentTimestamp = System.currentTimeMillis()/1000;
        requestTimestampMap.putIfAbsent(userId, new ArrayList<>());

        List<Long> timestamps = requestTimestampMap.get(userId);

        // Remove timestamps that are outside the time window
        timestamps.removeIf(timestamp -> currentTimestamp - timestamp >= windowInSeconds);

        // Check if user is allowed to hit the request;
        if(timestamps.size() > maxRequests)
            return false;

        // Add current timestamp and allow the current request
        timestamps.add(currentTimestamp);
        return true;
    }
}
