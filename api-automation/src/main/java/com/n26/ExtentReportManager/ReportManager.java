package com.n26.ExtentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static final ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/ExtentReport/";
    private static ExtentReports extent = null;

    public void initReports() {
        if (extent == null) {

            try {
                extent = new ExtentReports();
                ExtentSparkReporter spark = new ExtentSparkReporter(EXTENTREPORTFOLDERPATH);
                extent.attachReporter(spark);
                spark.config().setTheme(Theme.DARK);
                spark.config().setDocumentTitle("API Automation Report");
                spark.config().setReportName("Test Report");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    public  void flushReports() {
        try {
            extent.flush();
            currentTest.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  ExtentTest createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        currentTest.set(test);
        return test;
    }

    public  ExtentTest getCurrentTest() {
        return currentTest.get();
    }
    
}
