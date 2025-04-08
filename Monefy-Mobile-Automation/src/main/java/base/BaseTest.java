package base;

import driver.Driver;
import listeners.TestListener;
import org.testng.annotations.*;
import utils.AppiumServer;

@Listeners(value = {TestListener.class})
public class BaseTest {
    @BeforeSuite
    public void beforeSuite() {
        AppiumServer.startServer();
        
    }

    @AfterSuite
    public void afterSuite() {
        AppiumServer.stopServer();
    }

    @BeforeTest()
    public void beforeTest() {
        Driver.initDriver();
    }

    @AfterTest()
    public void afterTest() {
        Driver.quitDriver();
    }

}
