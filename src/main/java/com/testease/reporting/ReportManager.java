package com.testease.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {
            ExtentSparkReporter reporter =
                new ExtentSparkReporter("reports/TestEaseReport.html");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }
}
