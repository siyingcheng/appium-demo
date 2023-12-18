package com.simon.pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class NativeAppNavigator extends IOSBasePage {

    //    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.CHAIN)
    @iOSXCUITFindBy(accessibility = "Swipe")
    WebElement swipeBtn;

    public NativeAppNavigator(IOSDriver driver) {
        super(driver);
    }

    public NativeAppSwipePage navigateToSwipePage() {
        wait.until(elementToBeClickable(swipeBtn)).click();
        return new NativeAppSwipePage(driver);
    }
}
