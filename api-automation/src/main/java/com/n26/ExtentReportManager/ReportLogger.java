package com.n26.ExtentReportManager;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;

public class ReportLogger {

    public static void logInfo(String message) {
        ReportManager.getCurrentTest().info(message);
    }

    public static void logPass(String message) {
        ReportManager.getCurrentTest().pass(message);
    }

    public static void logPass(Markup message) {
        ReportManager.getCurrentTest().pass(message);
    }

    public static void logFail(String message) {
        ReportManager.getCurrentTest().fail(message);
    }
    public static void logFail(Markup message) {
        ReportManager.getCurrentTest().fail(message);
    }

    public static void logWarning(String message) {
        ReportManager.getCurrentTest().warning(message);
    }

    public static void highlight(String message, ExtentColor color) {
        ReportManager.getCurrentTest().info(
            MarkupHelper.createLabel(message, color)
        );
    }

    public static void logRequestAndResponse(String request, String response) {
        ReportManager.getCurrentTest().info("📤 Request:\n" + request);
        ReportManager.getCurrentTest().info("📥 Response:\n" + response);
    }

    public static void info(String message) {
        ReportManager.getCurrentTest().info(message);
    }

    public static void skip(Markup message) {
        ReportManager.getCurrentTest().skip(message);
    }
}