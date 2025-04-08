package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BalancePage;
import pages.DashboardPage;
import pages.WelcomePage;
import utils.AppInteractions;

/*
 * In this test scenarios covered are
 * 1. To Launch the App and to skip the welcome Tour
 * 2. To Add an Income Entry
 * 3. Verify in Balance Page whether the Income Entry displays
 * 4. Edit the Category of the previously added Entry
 * 5. Verify in Balance Page whether the Edited Category displays
 */

public class ChangeCategoryTest extends BaseTest {
    WelcomePage welcomePage;
    DashboardPage dashboardPage;
    BalancePage balancePage;

    @BeforeClass
    public void beforeClass() {
        AppInteractions.closeApp();
        AppInteractions.launchApp();
    }

    @BeforeMethod
    public void beforeMethod() {
        welcomePage = new WelcomePage();
        dashboardPage = new DashboardPage();
        balancePage = new BalancePage();
    }

    @Test(priority = 0, description = "Change Category Test - Skipping Welcome Tour")
    public void verifyWelcomePageTour() {
        welcomePage.clickGetStartedButton()
                .clickAmazingButton()
                .clickIAmReadyButton()
                .clickYesPleaseButon()
                .closeOfferButton();
    }

    @Test(priority = 1, description = "Change Category Test - Add Income Entry")
    public void ableToAddIncomeEntry() {
        String expectedCategory = "Salary";
        dashboardPage.clickIncomeButton()
                .clickAmountTextBox()
                .clickKeyboardButton("2")
                .clickKeyboardButton("0")
                .clickIncomeCategory()
                .clickSalaryCategory()
                .clickBalanceButton();
        Assert.assertEquals(balancePage.getFirstEntryCategory(), expectedCategory);
    }

    @Test(priority = 2, description = "Change Category Test - Edit Category")
    public void ableToEditCategory() {
        String expectedCategory = "Deposits";
        balancePage.clickFirstEntryHeader()
                .clickFirstEntryDetail()
                .clickIncomeCategory()
                .clickDepositsCategory();
        Assert.assertEquals(balancePage.getFirstEntryCategory(), expectedCategory);
    }
}