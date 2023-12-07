package com.simon.pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IOSHomePage extends IOSBasePage {

    @iOSXCUITFindBy(accessibility = "tab bar option cart")
    private WebElement cartBtn;

    public IOSHomePage(IOSDriver driver) {
        super(driver);
    }

    public WebElement cartBtn() {
        return this.cartBtn;
    }

    public boolean isDisplay() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cartBtn()));
            System.out.println(this.cartBtn.getTagName());
            System.out.println(this.cartBtn.getText());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
