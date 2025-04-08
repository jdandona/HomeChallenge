package pages;

import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;

public class WelcomePage extends BasePage {
    private final By continueButton = AppiumBy.id("com.monefy.app.lite:id/buttonContinue");
    private final By closeOffer = AppiumBy.id("com.monefy.app.lite:id/buttonClose");
    

    public WelcomePage clickGetStartedButton(){
        click(continueButton,"Get Started Button");
        return this;
    }

    public WelcomePage clickAmazingButton(){
        click(continueButton,"Amazing Button");
        return this;
    }

    public WelcomePage clickIAmReadyButton() {
        click(continueButton, "I am Ready Button");
        return this;
    }
    public WelcomePage clickYesPleaseButon(){
        click(continueButton,"Yes, Please!");
        return this;
    }

    public DashboardPage closeOfferButton(){
        click(closeOffer,"Close Offer Button");
        return new DashboardPage();
    }
}


