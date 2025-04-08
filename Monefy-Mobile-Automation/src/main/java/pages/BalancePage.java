package pages;

import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;

public class BalancePage extends BasePage {
    private final By firstEntryCategory = AppiumBy.id("com.monefy.app.lite:id/textViewCategoryName");
    private final By firstEntryCategoryAmount = AppiumBy.id("com.monefy.app.lite:id/textViewWholeAmount");
    private final By firstEntryHeader = AppiumBy.id("com.monefy.app.lite:id/transaction_group_header");
    private final By firstEntryDetail = AppiumBy.id("com.monefy.app.lite:id/textViewTransactionDate");

    public String getFirstEntryCategory() {
        return driver.findElement(firstEntryCategory).getText();
    }

    public String getFirstEntryAmount() {
        return driver.findElement(firstEntryCategoryAmount).getText();
    }

    public BalancePage clickFirstEntryHeader() {
        click(firstEntryHeader, "First Entry Header");
        return this;
    }

    public EditIncomePage clickFirstEntryDetail() {
        click(firstEntryDetail, "First Entry Detail");
        return new EditIncomePage();
    }
}


