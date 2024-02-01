package com.apoorv;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RateLimiterApplication {
    public static void main(String[] args) {
        // Test SlidingWindowRateLimiter (Sliding Window)
        System.out.println("=== Testing SlidingWindowRateLimiter (Sliding Window) ===");
        RateLimiter slidingWindowLimiter = new SlidingWindow(5, 8);
        simulateRequests(slidingWindowLimiter, 1000);

        // Test FixedWindowRateLimiter (Fixed Window)
        System.out.println("\n=== Testing FixedWindowRateLimiter (Fixed Window) ===");
        RateLimiter fixedWindowLimiter = new FixedWindow(5, 60);
        simulateRequests(fixedWindowLimiter, 8000);
    }

    private static void simulateRequests(RateLimiter rateLimiter, long differenceBetweenRequests) {
        String userId = "user123";

        for (int i = 1; i <= 20; i++) {
            boolean isAllowed = rateLimiter.isAllowed(userId);

            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String timestamp = dateFormat.format(new Date());

            if (isAllowed) {
                System.out.println(timestamp + " - Request " + i + ": Accepted");
            } else {
                System.out.println(timestamp + " - Request " + i + ": Denied");
            }

            // Simulate some time passing between requests
            try {
                Thread.sleep(differenceBetweenRequests);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}