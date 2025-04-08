package driver;

import constants.FrameworkConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertyUtils;

import java.net.URL;

public class DriverFactory {

    private DriverFactory(){}

    public static AppiumDriver getDriver(){
        AppiumDriver driver = null;
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyUtils.getValue("platformName"));
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertyUtils.getValue("platformVersion"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyUtils.getValue("deviceName"));

            String platformName = PropertyUtils.getValue("platformName");
            switch (platformName){
                case "Android":
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertyUtils.getValue("androidAutomationName"));
                    caps.setCapability("appPackage", PropertyUtils.getValue("androidAppPackage"));
                    caps.setCapability("appActivity", PropertyUtils.getValue("androidAppActivity"));
                    //caps.setCapability(MobileCapabilityType.APP, FrameworkConstants.getResourcesPath() + PropertyUtils.getValue("androidAppLocation"));

                    URL url = new URL(PropertyUtils.getValue("appiumUrl"));
                    driver = new AndroidDriver(url, caps);
                    break;

                case "IOS":
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertyUtils.getValue("iOSAutomationName"));
                    caps.setCapability(MobileCapabilityType.APP, FrameworkConstants.getResourcesPath()+PropertyUtils.getValue("iOSAppLocation"));
                    url = new URL(PropertyUtils.getValue("appiumUrl"));
                    driver = new IOSDriver(url, caps);
                    break;

                default:
                    throw new Exception("Invalid platform :"+platformName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver;
    }
}
