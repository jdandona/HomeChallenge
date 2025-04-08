package com.n26.TestInitiator;

import com.n26.ApiActions.UserActions;
import com.n26.ApiActionsManager.RestAssuredActions;
import com.n26.ExtentReportManager.ReportLogger;
import com.n26.ExtentReportManager.ReportManager;

public class TestContext {

    private final ReportManager reportManager;
    private final ReportLogger reportLogger;
    private final RestAssuredActions restAssuredActions;
    private final UserActions userActions;

    public TestContext(ReportManager reportManager, ReportLogger reportLogger,
                       RestAssuredActions restAssuredActions, UserActions userActions) {
        this.reportManager = reportManager;
        this.reportLogger = reportLogger;
        this.restAssuredActions = restAssuredActions;
        this.userActions = userActions;
    }

    public ReportManager getReportManager() {
        return reportManager;
    }

    public ReportLogger getReportLogger() {
        return reportLogger;
    }

    public RestAssuredActions getRestAssuredActions() {
        return restAssuredActions;
    }

    public UserActions getUserActions() {
        return userActions;
    }
}

