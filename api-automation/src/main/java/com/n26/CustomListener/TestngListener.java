package com.n26.CustomListener;

import java.util.Arrays;

import com.n26.TestInitiator.BaseTest;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestngListener implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testInstance;
            baseTest.testContext().getReportManager().initReports();
            baseTest.testContext().getReportManager().createTest(result.getMethod().getMethodName());
        }
    }


    public void onTestSuccess(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testInstance;
            String logText = "<b>" + result.getMethod().getMethodName() + " is passed.</b>";
            Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            baseTest.testContext().getReportLogger().logPass(markup_message);
        }

    }

    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testInstance;
            baseTest.testContext().getReportLogger().logFail(result.getMethod().getMethodName()+ " is failed");
            baseTest.testContext().getReportLogger().logFail(result.getThrowable().toString());

            String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
            String message = "<details><summary><b><font color=red> Exception occurred, click to see details: "
                + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
                + "</details> \n";

            baseTest.testContext().getReportLogger().logFail(message);

            String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>";
            Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.RED);
            baseTest.testContext().getReportLogger().logFail(markup_message);

        }
        
    }

    public void onTestSkipped(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testInstance;
            String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.</b>";
            Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            baseTest.testContext().getReportLogger().skip(markup_message);
        }

        
    }
}
