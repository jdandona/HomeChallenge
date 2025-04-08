package driver;

import io.appium.java_client.AppiumDriver;

public class DriverManager {

    private DriverManager(){
    }

    private static ThreadLocal<AppiumDriver> dr = new ThreadLocal<>();

    public static AppiumDriver getDriver(){
        return dr.get();
    }

    static void setDriver(AppiumDriver driverReference){
        dr.set(driverReference);
    }

    static void unload(){
        dr.remove();
    }
}
