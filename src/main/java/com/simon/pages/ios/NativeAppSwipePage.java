package com.simon.pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class NativeAppSwipePage extends IOSBasePage {

    @iOSXCUITFindBy(accessibility = "Or swipe vertical to find what I'm hiding.")
    WebElement contentText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage")
    WebElement robotImage;

    public NativeAppSwipePage(IOSDriver driver) {
        super(driver);
    }
}
