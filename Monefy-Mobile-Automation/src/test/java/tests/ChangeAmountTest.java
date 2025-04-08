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
 * 4. Edit the Amount of the previously added Entry
 * 5. Verify in Balance Page whether the Edited Amount displays
 */

public class ChangeAmountTest extends BaseTest {
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

    @Test(priority = 0, description = "Change Amount Test - Skipping Welcome Tour")
    public void verifyWelcomePageTour() {
        welcomePage.clickGetStartedButton()
                .clickAmazingButton()
                .clickIAmReadyButton()
                .clickYesPleaseButon()
                .closeOfferButton();
    }

    @Test(priority = 1, description = "Change Amount Test - Add Income Entry")
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

    @Test(priority = 2, description = "Change Amount Test - Edit Amount of existing Entry")
    public void ableToEditAmount() {
        String expectedCategory = "Salary";
        String expectedAmount = "£201.00";
        balancePage.clickFirstEntryHeader()
                .clickFirstEntryDetail()
                .clickAmountTextBox()
                .clickKeyboardButton("1")
                .navigateBack();
        Assert.assertEquals(balancePage.getFirstEntryCategory(), expectedCategory);
        Assert.assertEquals(balancePage.getFirstEntryAmount(), expectedAmount);
    }
}