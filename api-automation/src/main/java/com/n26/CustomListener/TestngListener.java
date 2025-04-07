package com.n26.CustomListener;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.n26.ExtentReportManager.ReportLogger;
import com.n26.ExtentReportManager.ReportManager;

public class TestngListener implements ITestListener, ISuiteListener {
    
    @Override
    public void onStart(ISuite suite) {
        ReportManager.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ReportManager.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ReportManager.createTest(result.getMethod().getMethodName());
        //ReportManager.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    public void onTestSuccess(ITestResult result) {
        String logText = "<b>" + result.getMethod().getMethodName() + " is passed.</b>";
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        ReportLogger.logPass(markup_message);

    }

    public void onTestFailure(ITestResult result) {
        ReportLogger.logFail(result.getMethod().getMethodName()+ " is failed");
        ReportLogger.logFail(result.getThrowable().toString());

        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        String message = "<details><summary><b><font color=red> Exception occurred, click to see details: "
                + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
                + "</details> \n";

            ReportLogger.logFail(message);

        String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>";
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.RED);
        ReportLogger.logFail(markup_message);
    }

    public void onTestSkipped(ITestResult result) {
        String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.</b>";
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        ReportLogger.skip(markup_message);
    }
}
