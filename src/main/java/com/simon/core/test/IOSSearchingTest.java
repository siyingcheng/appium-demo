package com.simon.core.test;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

public class IOSSearchingTest extends AppIOSTest {
    @Test(groups = "WIP")
    public void findByAccessibilityIdTest() {
        assertNotNull(iosDriver
                .findElement(AppiumBy.accessibilityId("ComputeSumButton"))
                .getText());
        assertNotEquals(iosDriver
                .findElements(AppiumBy.accessibilityId("ComputeSumButton"))
                .size(), 0);
    }

    @Test(groups = "WIP")
    public void findByByIosPredicatesTest() {
        assertNotNull(iosDriver
                .findElement(AppiumBy.iOSNsPredicateString("name like 'Answer'"))
                .getText());
        assertNotEquals(iosDriver
                .findElements(AppiumBy.iOSNsPredicateString("name like 'Answer'"))
                .size(), 0);
    }

    @Test(groups = "WIP")
    public void findByByIosClassChainTest() {
        assertNotNull(iosDriver
                .findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton"))
                .getText());
        assertNotEquals(iosDriver
                .findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeButton"))
                .size(), 0);
    }
}
