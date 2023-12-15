package com.simon.testcases.ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class IOSWebViewTest extends BaseIOSWebViewTest {
    private static final Duration LOOKUP_TIMEOUT = Duration.ofSeconds(30);

    @Test(groups = "WIP")
    public void webViewPageTestCase() throws InterruptedException {
        new WebDriverWait(iosDriver, LOOKUP_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("login")))
                .click();
        new WebDriverWait(iosDriver, LOOKUP_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("webView")))
                .click();
        new WebDriverWait(iosDriver, LOOKUP_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Webview")));
        findAndSwitchToWebView();
        assertTrue(iosDriver.findElement(By.partialLinkText("login")).isDisplayed());
    }
}
