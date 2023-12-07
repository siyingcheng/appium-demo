package com.simon.pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndroidHomePage extends AndroidBasePage {
    @AndroidFindBy(accessibility = "tab bar option cart")
    private WebElement cartBtn;

    public AndroidHomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isDisplay() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cartBtn()));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement cartBtn() {
        return this.cartBtn;
    }
}
