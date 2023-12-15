package com.simon.testcases.ios;

import com.simon.core.test.AppIOSTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.appium.java_client.ios.touch.IOSPressOptions.iosPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class IOSTouchTest extends AppIOSTest {
    @Test(groups = "WIP")
    public void tapTest() {
        WebElement intA = iosDriver.findElement(By.id("IntegerA"));
        WebElement intB = iosDriver.findElement(By.id("IntegerB"));
        intA.clear();
        intB.clear();
        intA.sendKeys("2");
        intB.sendKeys("4");

        WebElement e = iosDriver.findElement(AppiumBy.accessibilityId("ComputeSumButton"));
        new IOSTouchAction(iosDriver)
                .tap(tapOptions()
                        .withElement(element(e)))
                .perform();
        assertEquals(iosDriver.findElement(By.xpath("//*[@name = \"Answer\"]")).getText(), "6");
    }

    @Test(groups = "WIP")
    public void touchWithPressureTest() {
        WebElement intA = iosDriver.findElement(By.id("IntegerA"));
        WebElement intB = iosDriver.findElement(By.id("IntegerB"));
        intA.clear();
        intB.clear();
        intA.sendKeys("2");
        intB.sendKeys("4");

        WebElement e = iosDriver.findElement(AppiumBy.accessibilityId("ComputeSumButton"));
        new IOSTouchAction(iosDriver)
                .press(iosPressOptions()
                        .withElement(element(e))
                        .withPressure(1))
                .waitAction(waitOptions(ofMillis(100)))
                .release()
                .perform();
        assertEquals(iosDriver.findElement(By.xpath("//*[@name = \"Answer\"]")).getText(), "6");
    }

    @Test(groups = "WIP")
    public void multiTouchTest() {
        WebElement e = iosDriver.findElement(AppiumBy.accessibilityId("ComputeSumButton"));
        WebElement e2 = iosDriver.findElement(AppiumBy.accessibilityId("show alert"));

        IOSTouchAction tap1 = new IOSTouchAction(iosDriver)
                .tap(tapOptions().withElement(element(e)));
        IOSTouchAction tap2 = new IOSTouchAction(iosDriver)
                .tap(tapOptions().withElement(element(e2)));

        new MultiTouchAction(iosDriver).add(tap1).add(tap2).perform();

        WebDriverWait waiting = new WebDriverWait(iosDriver, Duration.ofSeconds(10));
        assertNotNull(waiting.until(alertIsPresent()));
        iosDriver.switchTo().alert().accept();
    }

    @Test(groups = "WIP")
    public void doubleTapTest() {
        WebElement firstField = iosDriver.findElement(By.id("IntegerA"));
        firstField.sendKeys("2");

        IOSTouchAction iosTouchAction = new IOSTouchAction(iosDriver);
        iosTouchAction.doubleTap(element(firstField));
        WebElement editingMenu = iosDriver.findElement(AppiumBy.className("XCUIElementTypeTextField"));
        assertNotNull(editingMenu);
    }
}
