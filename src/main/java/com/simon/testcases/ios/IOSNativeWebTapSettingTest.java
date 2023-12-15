package com.simon.testcases.ios;

import com.simon.core.test.BaseSafariTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

/**
 *  Safari testing required safari driver: appium driver install safari
 */
public class IOSNativeWebTapSettingTest extends BaseSafariTest {
    // Disabled("https://github.com/appium/appium/issues/17014")
    @Test(groups = "WIP")
    public void nativeWebTapSettingTest() {
        assertTrue(iosDriver.isBrowser());
        iosDriver.get("https://saucelabs.com/test/guinea-pig");

        // do a click with nativeWebTap turned on, and assert we get to the right page
        iosDriver.nativeWebTap(true);
        WebElement el = iosDriver.findElement(By.id("i am a link"));
        el.click();
        assertTrue(new WebDriverWait(iosDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.titleIs("I am another page title - Sauce Labs")));
        iosDriver.navigate().back();

        // now do a click with it turned off and assert the same behavior
        assertTrue(new WebDriverWait(iosDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.titleIs("I am a page title - Sauce Labs")));
        iosDriver.nativeWebTap(false);
        el = iosDriver.findElement(By.id("i am a link"));
        el.click();
        assertTrue(new WebDriverWait(iosDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.titleIs("I am another page title - Sauce Labs")));
    }
}
