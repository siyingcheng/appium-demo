package com.simon.testcases.ios;

import com.simon.core.test.AppIOSTest;
import io.appium.java_client.AppiumBy;
import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Supplier;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertTest extends AppIOSTest {
    private static final Duration ALERT_TIMEOUT = Duration.ofSeconds(5);
    private static final int CLICK_RETRIES = 2;
    private static final String IOS_AUTOMATION_TEXT = "show alert";

    @AfterMethod
    public void tearDown() {
        try {
            iosDriver.switchTo().alert().accept();
        } catch (WebDriverException e) {
            // ignore
        }
    }

    @Test(groups = "WIP")
    public void acceptAlertTest() {
        Supplier<Boolean> acceptAlert = () -> {
            ensureAlertPresence();
            iosDriver.switchTo().alert().accept();
            return true;
        };
        Assert.assertTrue(acceptAlert.get());
    }

    @Test(groups = "WIP")
    public void dismissAlertTest() {
        Supplier<Boolean> dismissAlert = () -> {
            ensureAlertPresence();
            iosDriver.switchTo().alert().dismiss();
            return true;
        };
        Assert.assertTrue(dismissAlert.get());
    }

    @Test(groups = "WIP")
    public void getAlertTextTest() {
        ensureAlertPresence();
        Assert.assertFalse(iosDriver.switchTo().alert().getText().trim().isEmpty());
    }

    private void ensureAlertPresence() {
        int retry = 0;
        // CI might not be performant enough, so we need to retry
        while (true) {
            try {
                iosDriver.findElement(AppiumBy.accessibilityId(IOS_AUTOMATION_TEXT)).click();
            } catch (WebDriverException e) {
                // ignore
            }
            try {
                getWait(ALERT_TIMEOUT).until(alertIsPresent());
                return;
            } catch (TimeoutException e) {
                retry++;
                if (retry > CLICK_RETRIES) {
                    throw e;
                }
            }
        }
    }
}
