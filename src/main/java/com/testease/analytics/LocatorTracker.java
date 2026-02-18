package com.testease.analytics;

import java.util.HashMap;
import java.util.Map;

public class LocatorTracker {

    private static Map<String, Integer> failures = new HashMap<>();

    public static void recordFailure(String locator) {
        failures.put(locator, failures.getOrDefault(locator, 0) + 1);
    }

    public static void printReport() {

        System.out.println("\n====== LOCATOR FAILURE REPORT ======");

        for (Map.Entry<String, Integer> entry : failures.entrySet()) {
            System.out.println(entry.getKey() + "  →  " + entry.getValue() + " failures");
        }
    }
}
