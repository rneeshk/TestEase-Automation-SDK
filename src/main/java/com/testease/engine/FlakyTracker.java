package com.testease.engine;

import java.util.HashMap;
import java.util.Map;

import com.testease.logger.Log;

public class FlakyTracker {

    private static Map<String, Integer> failureMap = new HashMap<>();

    public static void recordFailure(String locator) {
        failureMap.put(locator, failureMap.getOrDefault(locator, 0) + 1);

        Log.warn("Flaky detection: " + locator +
                " failed " + failureMap.get(locator) + " times");
    }
}
