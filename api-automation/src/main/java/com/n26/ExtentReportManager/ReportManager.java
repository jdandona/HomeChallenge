package com.n26.ExtentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static final ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/ExtentReport/";
    private static ExtentReports extent;

    public static void initReports() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = null;
        try {
            spark = new ExtentSparkReporter(EXTENTREPORTFOLDERPATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("API Automation Report");
        spark.config().setReportName("Test Report");
    }

    public static void flushReports() {
        try {
            extent.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public static ExtentTest createTest(String testName) {
    ExtentTest test = extent.createTest(testName);
    currentTest.set(test);
    return test;
}

public static ExtentTest getCurrentTest() {
    return currentTest.get();
}
    
}
