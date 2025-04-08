package com.n26.TestInitiator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.n26.ApiActions.UserActions;
import com.n26.ApiActionsManager.RestAssuredActions;
import com.n26.ExtentReportManager.ReportLogger;
import com.n26.ExtentReportManager.ReportManager;

import java.lang.reflect.Method;

public class BaseTest {

    private static final ThreadLocal<TestContext> testContext = new ThreadLocal<>();
    private static final ReportManager reportManager = new ReportManager();
    
    @BeforeMethod
    public void beforeMethod(Method method) {
        ReportLogger reportLogger = new ReportLogger(reportManager);
        RestAssuredActions rest = new RestAssuredActions(reportLogger);
        UserActions userActions = new UserActions(rest);
        TestContext context = new TestContext(reportManager, reportLogger, rest, userActions);
        testContext.set(context);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("flushing report");
        testContext.get().getReportManager().flushReports();
        testContext.remove();
    }

    public TestContext testContext() {
        return testContext.get();
    }
    
}
