package base;

import com.aventstack.extentreports.Status;
import constants.FrameworkConstants;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

import org.openqa.selenium.By;
import reports.ExtentReport;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected AppiumDriver driver;


    public BasePage() {
        this.driver = DriverManager.getDriver();
        //PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);

    }

    public void waitForVisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getWaitTime()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator,String elementName){
        waitForVisibility(locator);
        driver.findElement(locator).click();
        ExtentReport.getTest().log(Status.INFO,elementName+" is clicked");
    }

    public void sendKeys(By locator, String text,String elementName){
        waitForVisibility(locator);
        driver.findElement(locator).sendKeys(text);
        ExtentReport.getTest().log(Status.INFO,elementName+" is entered with "+text);
    }

    public void navigateBack(){
        DriverManager.getDriver().navigate().back();
    }

    public String getText(By locator){
        waitForVisibility(locator);
        return driver.findElement(locator).getText();
    }

    public String getAttribute(By locator, String attribute){
        waitForVisibility(locator);
        return driver.findElement(locator).getAttribute(attribute);
    }
}
