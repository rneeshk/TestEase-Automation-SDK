package com.testease.retry;

import com.testease.logger.Log;
import com.testease.utils.ConfigReader;

public class RetryEngine {

    public static void execute(Runnable action) {

        int attempts = Integer.parseInt(ConfigReader.get("retry.count"));
        int count = 0;

        while (count < attempts) {
            try {
                action.run();
                return;
            } catch (Exception e) {
                count++;

                Log.warn("Retry attempt: " + count);

                if (count == attempts) {
                    Log.error("Action failed after retries");
                    throw e;
                }
            }
        }
    }
}
