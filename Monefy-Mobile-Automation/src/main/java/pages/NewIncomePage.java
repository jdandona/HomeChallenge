package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NewIncomePage extends BasePage {
    private final By backButton = AppiumBy.accessibilityId("Navigate up");
    private final By chooseCategoryButton = AppiumBy.id("com.monefy.app.lite:id/keyboard_action_button");
    private final By salaryCategory = AppiumBy.xpath("//*[@text='Salary']");
    private final By amountTextBox = AppiumBy.id("com.monefy.app.lite:id/amount_text");

    public DashboardPage clickBackButton() {
        click(backButton, "Back Button");
        return new DashboardPage();
    }

    public NewIncomePage clickKeyboardButton(String buttonToClick) {
        String locator = constructKeyboardNumber(buttonToClick);
        By buttonLocator = By.id(locator);
        click(buttonLocator, buttonToClick);
        return this;
    }

    public NewIncomePage clickIncomeCategory() {
        click(chooseCategoryButton, "Choose Category Button");
        return this;
    }

    public DashboardPage clickSalaryCategory() {
        click(salaryCategory, "Bills Category");
        return new DashboardPage();
    }

    public NewIncomePage clickAmountTextBox(){
        click(amountTextBox,"Amount Text Box");
        return this;
    }

    private String constructKeyboardNumber(String value) {
        return "com.monefy.app.lite:id/buttonKeyboard" + value;
    }
}


