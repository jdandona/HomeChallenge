package listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import driver.DriverManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        if(result.getThrowable()!=null){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
        }
        File file = DriverManager.getDriver().getScreenshotAs(OutputType.FILE);
        byte[] encoded = null;
        try {
            encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        ExtentReport.getTest().fail("Screenshot",
                MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());

        ExtentReport.getTest().fail(result.getThrowable().toString());

        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        String message = "<details><summary><b><font color=red> Exception occurred, click to see details: "
                + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
                + "</details> \n";

        ExtentReport.getTest().fail(message);

        String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>";
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.RED);
        ExtentReport.getTest().fail(markup_message);

    }

    public void onTestStart(ITestResult result) {
        ExtentReport.startTest(result.getName(),result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReport.getTest().log(Status.PASS,"Test Passed");
    }

    public void onTestSkipped(ITestResult result) {
        ExtentReport.getTest().log(Status.SKIP,"Test Skipped");
    }

    public void onFinish(ITestContext context) {
        ExtentReport.getReporter().flush();
    }
}