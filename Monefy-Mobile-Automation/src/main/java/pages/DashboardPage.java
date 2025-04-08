package pages;

import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;

public class DashboardPage extends BasePage {
private final By expenseButton = AppiumBy.id("com.monefy.app.lite:id/expense_button");
private final By incomeButton = AppiumBy.id("com.monefy.app.lite:id/income_button");
private final By balanceButton = AppiumBy.id("com.monefy.app.lite:id/balance_amount");
    

    public NewExpensePage clickExpenseButton(){
        click(expenseButton,"Expense Button");
        return new NewExpensePage();
    }

    public NewIncomePage clickIncomeButton(){
        click(incomeButton,"Income Button");
        return new NewIncomePage();
    }

    public BalancePage clickBalanceButton(){
        click(balanceButton,"Income Button");
        return new BalancePage();
    }
}


