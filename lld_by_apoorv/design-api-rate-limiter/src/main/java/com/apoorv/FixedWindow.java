package com.apoorv;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class FixedWindow implements RateLimiter{

    private final Map<String, Integer> requestCounts;
    private final int maxRequests;

    public FixedWindow(int maxRequests, long windowInSeconds){
        this.requestCounts = new HashMap<>();
        this.maxRequests = maxRequests;

        // Schedule a task to reset counts for each user after the fixed window duration
        Timer timer = new Timer(true);

        // The first argument to scheduleAtFixedRate is the TimerTask instance, which defines the code to be executed when the timer fires
        // The second argument is the delay before the first execution
        // The third argument is the period between successive executions
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                resetCounts();
            }
        },0, windowInSeconds * 1000);
    }

    private void resetCounts(){
        // clear the entire map
        requestCounts.clear();
    }

    @Override
    public boolean isAllowed(String userId) {

        // Check if user is allowed to hit the request
        if(requestCounts.getOrDefault(userId, 0) >= maxRequests){
            return false;
        }

        // Increment the request count and allow the current request
        requestCounts.put(userId, requestCounts.getOrDefault(userId, 0 ) + 1);
        return true;
    }
}
