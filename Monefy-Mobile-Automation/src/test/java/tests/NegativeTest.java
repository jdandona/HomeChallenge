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
 * This test covers the negative scenarios
 * This test is to check if Report displays failed test along with proper Stack trace
 */

public class NegativeTest extends BaseTest {
    WelcomePage welcomePage;
    DashboardPage dashboardPage;
    BalancePage balancePage;

    @BeforeClass
    public void beforeClass(){
        AppInteractions.closeApp();
        AppInteractions.launchApp();
    }

    @BeforeMethod
    public void beforeMethod() {
        welcomePage = new WelcomePage();
        dashboardPage = new DashboardPage();
        balancePage = new BalancePage();
    }

    @Test(priority = 0,description = "Add Expense/Income Test - Skipping Welcome Tour")
    public void verifyWelcomePageTour(){
        welcomePage.clickGetStartedButton()
                .clickAmazingButton()
                .clickIAmReadyButton()
                .clickYesPleaseButon()
                .closeOfferButton();
    }

    @Test(priority = 1,description = "Add Expense/Income Test - Add Expense Entry")
    public void ableToAddExpenseEntry() {
        String expectedCategory = "Bills";
        String errorAmount = "$20.00";
        BalancePage balancePage = dashboardPage.clickExpenseButton()
                .clickAmountTextBox()
                .clickKeyboardButton("1")
                .clickKeyboardButton("2")
                .clickExpenseCategory()
                .clickBillCategory()
                .clickBalanceButton();
        Assert.assertEquals(balancePage.getFirstEntryCategory(),expectedCategory);
        Assert.assertEquals(balancePage.getFirstEntryAmount(),errorAmount);
    }
}