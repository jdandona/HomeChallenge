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
 * 2. To Add an Expense Entry
 * 3. Verify in Balance Page whether the Expense Entry displays
 * 4. To Add an Income Entry
 * 5. Verify in Balance Page whether the Income Entry displays
 */

public class AddExpenseAndIncomeEntryTest extends BaseTest {
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
        String expectedAmount = "£12.00";
        BalancePage balancePage = dashboardPage.clickExpenseButton()
                .clickAmountTextBox()
                .clickKeyboardButton("1")
                .clickKeyboardButton("2")
                .clickExpenseCategory()
                .clickBillCategory()
                .clickBalanceButton();
        Assert.assertEquals(balancePage.getFirstEntryCategory(),expectedCategory);
        Assert.assertEquals(balancePage.getFirstEntryAmount(),expectedAmount);

        balancePage.navigateBack();
    }

    @Test(priority = 2,description = "Add Expense/Income Test - Add Income Entry")
    public void ableToAddIncomeEntry() {
        String expectedCategory = "Salary";
        String expectedAmount = "£20.00";
        dashboardPage.clickIncomeButton()
                .clickAmountTextBox()
                .clickKeyboardButton("2")
                .clickKeyboardButton("0")
                .clickIncomeCategory()
                .clickSalaryCategory()
                .clickBalanceButton();
        Assert.assertEquals(balancePage.getFirstEntryCategory(),expectedCategory);
        Assert.assertEquals(balancePage.getFirstEntryAmount(),expectedAmount);
    }
}