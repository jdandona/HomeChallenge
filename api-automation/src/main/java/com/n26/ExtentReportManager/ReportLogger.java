package com.n26.ExtentReportManager;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;

public class ReportLogger {

    private final ReportManager reportmanager;

    public ReportLogger(ReportManager reportmanager) {
        this.reportmanager = reportmanager;
    }

    public  void logInfo(String message) {
        reportmanager.getCurrentTest().info(message);
    }

    public  void logPass(String message) {
        reportmanager.getCurrentTest().pass(message);
    }

    public  void logPass(Markup message) {
        reportmanager.getCurrentTest().pass(message);
    }

    public  void logFail(String message) {
        reportmanager.getCurrentTest().fail(message);
    }
    public  void logFail(Markup message) {
        reportmanager.getCurrentTest().fail(message);
    }

    public  void logWarning(String message) {
        reportmanager.getCurrentTest().warning(message);
    }

    public  void highlight(String message, ExtentColor color) {
        reportmanager.getCurrentTest().info(
            MarkupHelper.createLabel(message, color)
        );
    }

    public  void logRequestAndResponse(String request, String response) {
        reportmanager.getCurrentTest().info("📤 Request:\n" + request);
        reportmanager.getCurrentTest().info("📥 Response:\n" + response);
    }

    public  void info(String message) {
        reportmanager.getCurrentTest().info(message);
    }

    public  void skip(Markup message) {
        reportmanager.getCurrentTest().skip(message);
    }
}