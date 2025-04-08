package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class EditIncomePage extends BasePage {
   private final By backButton = AppiumBy.accessibilityId("Navigate up");
   private final By chooseCategoryButton = AppiumBy.id("com.monefy.app.lite:id/keyboard_action_button");
   private final By depositsCategory = AppiumBy.xpath("//*[@text='Deposits']");
   private final By amountTextBox = AppiumBy.id("com.monefy.app.lite:id/amount_text");

    public DashboardPage clickBackButton() {
        click(backButton, "Back Button");
        return new DashboardPage();
    }

    public EditIncomePage clickKeyboardButton(String buttonToClick) {
        String locator = constructKeyboardNumber(buttonToClick);
        By buttonLocator = By.id(locator);
        click(buttonLocator, buttonToClick);
        return this;
    }

    public EditIncomePage clickIncomeCategory() {
        click(chooseCategoryButton, "Choose Category Button");
        return this;
    }

    public DashboardPage clickDepositsCategory() {
        click(depositsCategory, "Bills Category");
        return new DashboardPage();
    }

    public EditIncomePage clickAmountTextBox(){
        click(amountTextBox,"Amount Text Box");
        return this;
    }

    private String constructKeyboardNumber(String value) {
        return "com.monefy.app.lite:id/buttonKeyboard" + value;
    }
}


